package com.worktime;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateworktimeServlet")
public class UpdateworktimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
          String wId = request.getParameter("wId");
          String defaulthours =request.getParameter("defaulthours");
          String workinghours =request.getParameter("workinghours");
          String OThours =request.getParameter("OThours");
          String OTbonuses=request.getParameter("OTbonuses");
          
          
          boolean isTrue;
  		
  		isTrue = worktimeDButil.updateworktime(wId, defaulthours, workinghours, OThours,OTbonuses);
  		
  		if(isTrue == true) {
  			
  			
  			RequestDispatcher dis = request.getRequestDispatcher("worktime.jsp");
    	    dis.forward(request, response);
  		}
  		
  		
  		else {
  	
  			
  			RequestDispatcher dis2 = request.getRequestDispatcher("worktime.jsp");
		    dis2.forward(request, response);
	    }
          
}         

}