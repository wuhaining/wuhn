package com.wuhn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wuhn.mail.SendRegisterEmail;
import com.wuhn.model.User;

public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setUsername(username);
            
            System.out.println("把用户信息注册到数据库中");
            //用户注册成功之后就使用用户注册时的邮箱给用户发送一封Email
            //发送邮件是一件非常耗时的事情，因此这里开辟了另一个线程来专门发送邮件
            SendRegisterEmail send = new SendRegisterEmail(user);
            //启动线程，线程启动之后就会执行run方法来发送邮件
            send.start();
            
            //注册用户
            //new UserService().registerUser(user);
            request.setAttribute("message", "恭喜您，注册成功，我们已经发了一封带了注册信息的电子邮件，请查收，如果没有收到，可能是网络原因，过一会儿就收到了！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "注册失败！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
	}

}
