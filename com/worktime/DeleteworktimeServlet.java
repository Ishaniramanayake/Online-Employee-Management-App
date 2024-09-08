package com.worktime;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteworktimeServlet")
public class DeleteworktimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

       String wId =request.getParameter("wId");
        
        boolean isTrue;
        
        isTrue = worktimeDButil.deleteworktime(wId);
        
        if(isTrue == true) {

  			RequestDispatcher dis = request.getRequestDispatcher("worktimeinsert.jsp");
    	    dis.forward(request, response);
  		}
        
        else {
  			
  			RequestDispatcher dis2 = request.getRequestDispatcher("worktime.jsp");
		    dis2.forward(request, response);
  			
  			
}
}
	
}