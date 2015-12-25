package com.wuhn.jbpm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.NewDeployment;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wuhn
 * @创建时间 2015-12-22
 * @功能 测试
 * **/
public class QuickStartTest {
	@Before
	public void testBefore(){
		System.out.println("********测试开始**********");
	}
	
	@After
	public void testAfter(){
		System.out.println("********测试结束**********");
	}
	
	
	@Test
	public void testHibernateCreateTable(){
		System.out.println("**********使用hibernate建表************");
		//能否使用hibernate加载配置文件，创建表
		Configuration configuration = new Configuration();//加载hibernate.properties
		configuration.configure("jbpm.hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		//这里不需提交，只要自动建表即可。
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testJbpmCreateTable(){
		System.out.println("**********使用jbpm建表************");
		//使用jbpm提供configuration
		org.jbpm.api.Configuration.getProcessEngine();//一条语句即可
		
	}
	
	@Test
	public void testJbpmDeploy(){
		System.out.println("**********部署流程************");
		//获得ProcessEngine流程引擎，可以获得不同Service对象，来完成相应的功能
		ProcessEngine processEngine = org.jbpm.api.Configuration.getProcessEngine();
		
		//部署实例 RepositoryService getRepositoryService() 获得实例管理Service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		
		//创建一个部署对象
		NewDeployment createDeployment = repositoryService.createDeployment();
		
		createDeployment.addResourceFromClasspath("helloworld/helloworld.jpdl.xml");
		createDeployment.addResourceFromClasspath("helloworld/helloworld.png");
		
		//发布
		createDeployment.deploy();
		
	}
	
	@Test
	public void testJbpmStartProcess(){
		System.out.println("**********启动流程实例************");
		
		ProcessEngine processEngine = org.jbpm.api.Configuration.getProcessEngine();//一条语句即可
		
		//启动流程获得ExecutionService
		ExecutionService executionService = processEngine.getExecutionService();
		//启动 通过查看表才能知道id 使用比较少  表 jbpm4_deployprop
		//executionService.startProcessInstanceById("helloworld-1");
		
		//设置流程时，流程有name------默认生成流程key
		executionService.startProcessInstanceByKey("helloworld");
		
	}
	
	@Test
	public void testJbpmPersonTask(){
		System.out.println("**********查看个人任务************");
		//使用jbpm提供configuration
		ProcessEngine processEngine = org.jbpm.api.Configuration.getProcessEngine();//一条语句即可
		//查看任务 获取服务TaskService
		TaskService taskService = processEngine.getTaskService();
		//查询个人任务
		List<Task> personalTasks = taskService.findPersonalTasks("员工");
		System.out.println(personalTasks);
		for(Task task:personalTasks){
			System.out.println("任务Id:"+task.getId());	
			System.out.println("任务名称:"+task.getName());
			System.out.println("任务的办理人:"+task.getAssignee());	
			System.out.println("执行流程实例Id:"+task.getExecutionId());
			System.out.println("******************************");
		}
		
	}
	
	@Test
	public void testJbpmCompleteTask(){
		System.out.println("**********办理任务************");
		//使用jbpm提供configuration
		ProcessEngine processEngine = org.jbpm.api.Configuration.getProcessEngine();//一条语句即可
		
		//查询任务
		TaskService taskService = processEngine.getTaskService();
		
		//必须通过任务id进行办理
		taskService.completeTask("10002");
		
	}
	
	
	@Test
	public void testJbpmDeploymentQuery(){
		System.out.println("**********查看流程实例************");
		/**
		 * DeploymentQuery createDeploymentQuery()  ------ jbpm4_deployment   查询发布信息
		 * ProcessDefinitionQuery createProcessDefinitionQuery() ----- jbpm4_deployprop  查询流程实例详细属性  （重点）
		 * **/
		
		//使用jbpm提供configuration
		RepositoryService repositoryService = org.jbpm.api.Configuration.getProcessEngine().getRepositoryService();
		//获得查询流程实例Query对象
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
		//processDefinitionQuery.processDefinitionId("helloworld-1");//根据key来查询对应的流程
		//processDefinitionQuery.count();//查询出来的流程数量
		//processDefinitionQuery.page(1, 5);//分页查询
		//processDefinitionQuery.orderAsc(processDefinitionQuery.PROPERTY_ID);//排序
		//查询所有流程
		List<ProcessDefinition> list = processDefinitionQuery.list();
		System.out.println(list);
		for(ProcessDefinition task:list){
			System.out.println("流程对应Id:"+task.getId());	
			System.out.println("流程对应name:"+task.getName());
			System.out.println("流程对应key:"+task.getKey());	
			System.out.println("版本:"+task.getVersion());
			System.out.println("******************************");
		}
		
	}
	
	@Test
	public void testJbpmDeleteProcess(){
		System.out.println("**********删除流程实例************");
		//第一种通过id删除 唯一的
		RepositoryService repositoryService = org.jbpm.api.Configuration.getProcessEngine().getRepositoryService();
		//删除id (通过发布id) 表 jbpm4_deployment
		//repositoryService.deleteDeployment("40001");
		
		//以上方法，注意问题： 如果流程以及开启了（含有执行信息，将无法删除 ）。解决办法：
		//repositoryService.deleteDeploymentCascade("40001");
		
		//第二种根据key删除(默认情况只能根据id删除) （用于同一个流程 发布了多个版本） 先查询，后删除。
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
		for(ProcessDefinition processDefinition:list){
			//表 jbpm4_deployprop
			repositoryService.deleteDeployment(processDefinition.getDeploymentId());
		}	
		
	}
	
	@Test
	public void testJbpmUpdateProcess(){
		System.out.println("**********修改流程 ？？？  不允许 ***********");
		RepositoryService repositoryService = org.jbpm.api.Configuration.getProcessEngine().getRepositoryService();
		//和流程相关操作（流程一旦创建将无法修改）
		
		//如何查询最新的流程？
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().processDefinitionKey("helloworld").orderDesc(ProcessDefinitionQuery.PROPERTY_VERSION).list();
		if(list.size() > 0){
			ProcessDefinition processDefinition = list.get(0);
			System.out.println("流程对应id ："+processDefinition.getId());
			System.out.println("流程对应name: " + processDefinition.getName());
			System.out.println("流程对应key ： " + processDefinition.getKey());
			System.out.println("版本：" + processDefinition.getVersion());
		}
	}
	
	@Test
	public void testSignal(){
		System.out.println("**********流程向后一步 ***********");
		//将之前实例，向后一步
		//向后一步针对流程实例（不考虑当前角色）
		
		//流程实例  表：jbpm4_execution  ID_
		String pid = "helloworld.50008";  
		//下一个节点transition的name
		String next = "to 审批[部门经理]";
		
		ProcessEngine processEngine = org.jbpm.api.Configuration.getProcessEngine();//一条语句即可
		
		processEngine.getExecutionService().signalExecutionById(pid, next);
	}
	
	
}

