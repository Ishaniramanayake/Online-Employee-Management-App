package com.worktime;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertworktimeServlet")
public class InsertworktimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isTrue;

String defaulthours =request.getParameter("default hours");
String workinghours =request.getParameter("working hours");
String OThours =request.getParameter("OT hours");
String OTbonuses=request.getParameter("OT bonuses");


		
	isTrue =worktimeDButil.insertworktime( defaulthours, workinghours,OThours,OTbonuses);
		
		if(isTrue == true)
			request.getRequestDispatcher("success.jsp").forward(request, response);
		
		else
			request.getRequestDispatcher("unsuccess.jsp").forward(request, response);
	}

}
	



