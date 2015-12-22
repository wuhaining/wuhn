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
		//���� ͨ���鿴�����֪��id ʹ�ñȽ���
		//executionService.startProcessInstanceById("helloworld-1");
		
		//��������ʱ��������name------Ĭ����������key
		executionService.startProcessInstanceByKey("helloworld");
		
	}
}
