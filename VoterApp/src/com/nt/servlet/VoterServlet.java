package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=null;
		
		//get PrintWriter
		pw=resp.getWriter();
		
		//set content type
		resp.setContentType("text/html");
		
		String name=null,vStatus=null,tage=null;
		int age=0;
		
		//read values from html page
		name=req.getParameter("pname");
		tage=req.getParameter("page");
		age=Integer.parseInt(tage);
		
		vStatus=req.getParameter("vflag");
		if(vStatus.equals("no")) {
			//server side form validation logic
			if(name.equals("") || name==null || name.length()==0) {
				pw.println("<font color=yellow>Person Name is Mandatory</font>");
				return;
			}
			if(tage.equals("no") || tage==null || tage.length()==0 ) {
				pw.println("<font color=orange>Person Age is Mandatory</font>");
				return;
			}
			else {
				try {
					age=Integer.parseInt(tage);
				}
				catch(NumberFormatException nfe) {
					pw.println("<font color=orange>Age must be a Numeric value</font>");
					return;
				}
			}
			System.out.println("Server side validations are done");
		}//if
		
		//write request processing logic
		if(age>=18) 
			pw.println("<h1><font color='green'>"+name+":: u r eligible to vote</font></h1>");
		else
			pw.println("<h1><font color='green'>"+name+":: u r not eligible to vote</font></h1>");
		
		pw.println("<br><br><a href='input.html'><img src='home.jpg'></a>");
		
		//close stream
		pw.close();
	}
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req,resp);
	}

}




