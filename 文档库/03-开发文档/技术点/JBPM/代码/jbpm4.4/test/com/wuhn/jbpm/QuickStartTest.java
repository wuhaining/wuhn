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
 * @����ʱ�� 2015-12-22
 * @���� ����
 * **/
public class QuickStartTest {
	@Before
	public void testBefore(){
		System.out.println("********���Կ�ʼ**********");
	}
	
	@After
	public void testAfter(){
		System.out.println("********���Խ���**********");
	}
	
	
	@Test
	public void testHibernateCreateTable(){
		System.out.println("**********ʹ��hibernate����************");
		//�ܷ�ʹ��hibernate���������ļ���������
		Configuration configuration = new Configuration();//����hibernate.properties
		configuration.configure("jbpm.hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		//���ﲻ���ύ��ֻҪ�Զ������ɡ�
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testJbpmCreateTable(){
		System.out.println("**********ʹ��jbpm����************");
		//ʹ��jbpm�ṩconfiguration
		org.jbpm.api.Configuration.getProcessEngine();//һ����伴��
		
	}
	
	@Test
	public void testJbpmDeploy(){
		System.out.println("**********��������************");
		//���ProcessEngine�������棬���Ի�ò�ͬService�����������Ӧ�Ĺ���
		ProcessEngine processEngine = org.jbpm.api.Configuration.getProcessEngine();
		
		//����ʵ�� RepositoryService getRepositoryService() ���ʵ������Service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		
		//����һ���������
		NewDeployment createDeployment = repositoryService.createDeployment();
		
		createDeployment.addResourceFromClasspath("helloworld/helloworld.jpdl.xml");
		createDeployment.addResourceFromClasspath("helloworld/helloworld.png");
		
		//����
		createDeployment.deploy();
		
	}
	
	@Test
	public void testJbpmStartProcess(){
		System.out.println("**********��������ʵ��************");
		
		ProcessEngine processEngine = org.jbpm.api.Configuration.getProcessEngine();//һ����伴��
		
		//�������̻��ExecutionService
		ExecutionService executionService = processEngine.getExecutionService();
		//���� ͨ���鿴�����֪��id ʹ�ñȽ���  �� jbpm4_deployprop
		//executionService.startProcessInstanceById("helloworld-1");
		
		//��������ʱ��������name------Ĭ����������key
		executionService.startProcessInstanceByKey("helloworld");
		
	}
	
	@Test
	public void testJbpmPersonTask(){
		System.out.println("**********�鿴��������************");
		//ʹ��jbpm�ṩconfiguration
		ProcessEngine processEngine = org.jbpm.api.Configuration.getProcessEngine();//һ����伴��
		//�鿴���� ��ȡ����TaskService
		TaskService taskService = processEngine.getTaskService();
		//��ѯ��������
		List<Task> personalTasks = taskService.findPersonalTasks("Ա��");
		System.out.println(personalTasks);
		for(Task task:personalTasks){
			System.out.println("����Id:"+task.getId());	
			System.out.println("��������:"+task.getName());
			System.out.println("����İ�����:"+task.getAssignee());	
			System.out.println("ִ������ʵ��Id:"+task.getExecutionId());
			System.out.println("******************************");
		}
		
	}
	
	@Test
	public void testJbpmCompleteTask(){
		System.out.println("**********��������************");
		//ʹ��jbpm�ṩconfiguration
		ProcessEngine processEngine = org.jbpm.api.Configuration.getProcessEngine();//һ����伴��
		
		//��ѯ����
		TaskService taskService = processEngine.getTaskService();
		
		//����ͨ������id���а���
		taskService.completeTask("10002");
		
	}
	
	
	@Test
	public void testJbpmDeploymentQuery(){
		System.out.println("**********�鿴����ʵ��************");
		/**
		 * DeploymentQuery createDeploymentQuery()  ------ jbpm4_deployment   ��ѯ������Ϣ
		 * ProcessDefinitionQuery createProcessDefinitionQuery() ----- jbpm4_deployprop  ��ѯ����ʵ����ϸ����  ���ص㣩
		 * **/
		
		//ʹ��jbpm�ṩconfiguration
		RepositoryService repositoryService = org.jbpm.api.Configuration.getProcessEngine().getRepositoryService();
		//��ò�ѯ����ʵ��Query����
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
		//processDefinitionQuery.processDefinitionId("helloworld-1");//����key����ѯ��Ӧ������
		//processDefinitionQuery.count();//��ѯ��������������
		//processDefinitionQuery.page(1, 5);//��ҳ��ѯ
		//processDefinitionQuery.orderAsc(processDefinitionQuery.PROPERTY_ID);//����
		//��ѯ��������
		List<ProcessDefinition> list = processDefinitionQuery.list();
		System.out.println(list);
		for(ProcessDefinition task:list){
			System.out.println("���̶�ӦId:"+task.getId());	
			System.out.println("���̶�Ӧname:"+task.getName());
			System.out.println("���̶�Ӧkey:"+task.getKey());	
			System.out.println("�汾:"+task.getVersion());
			System.out.println("******************************");
		}
		
	}
	
	@Test
	public void testJbpmDeleteProcess(){
		System.out.println("**********ɾ������ʵ��************");
		//��һ��ͨ��idɾ�� Ψһ��
		RepositoryService repositoryService = org.jbpm.api.Configuration.getProcessEngine().getRepositoryService();
		//ɾ��id (ͨ������id) �� jbpm4_deployment
		//repositoryService.deleteDeployment("40001");
		
		//���Ϸ�����ע�����⣺ ��������Լ������ˣ�����ִ����Ϣ�����޷�ɾ�� ��������취��
		//repositoryService.deleteDeploymentCascade("40001");
		
		//�ڶ��ָ���keyɾ��(Ĭ�����ֻ�ܸ���idɾ��) ������ͬһ������ �����˶���汾�� �Ȳ�ѯ����ɾ����
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
		for(ProcessDefinition processDefinition:list){
			//�� jbpm4_deployprop
			repositoryService.deleteDeployment(processDefinition.getDeploymentId());
		}	
		
	}
	
	@Test
	public void testJbpmUpdateProcess(){
		System.out.println("**********�޸����� ������  ������ ***********");
		RepositoryService repositoryService = org.jbpm.api.Configuration.getProcessEngine().getRepositoryService();
		//��������ز���������һ���������޷��޸ģ�
		
		//��β�ѯ���µ����̣�
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().processDefinitionKey("helloworld").orderDesc(ProcessDefinitionQuery.PROPERTY_VERSION).list();
		if(list.size() > 0){
			ProcessDefinition processDefinition = list.get(0);
			System.out.println("���̶�Ӧid ��"+processDefinition.getId());
			System.out.println("���̶�Ӧname: " + processDefinition.getName());
			System.out.println("���̶�Ӧkey �� " + processDefinition.getKey());
			System.out.println("�汾��" + processDefinition.getVersion());
		}
	}
	
	@Test
	public void testSignal(){
		System.out.println("**********�������һ�� ***********");
		//��֮ǰʵ�������һ��
		//���һ���������ʵ���������ǵ�ǰ��ɫ��
		
		//����ʵ��  ��jbpm4_execution  ID_
		String pid = "helloworld.50008";  
		//��һ���ڵ�transition��name
		String next = "to ����[���ž���]";
		
		ProcessEngine processEngine = org.jbpm.api.Configuration.getProcessEngine();//һ����伴��
		
		processEngine.getExecutionService().signalExecutionById(pid, next);
	}
	
	
}

