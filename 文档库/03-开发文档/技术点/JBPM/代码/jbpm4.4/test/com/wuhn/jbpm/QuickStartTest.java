package com.wuhn.jbpm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.NewDeployment;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
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
		//启动 通过查看表才能知道id 使用比较少
		//executionService.startProcessInstanceById("helloworld-1");
		
		//设置流程时，流程有name------默认生成流程key
		executionService.startProcessInstanceByKey("helloworld");
		
	}
}
