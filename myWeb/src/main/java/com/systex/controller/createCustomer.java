package com.systex.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;

import com.systex.model.Customer;

/**
 * Servlet implementation class createCustomer
 */
public class createCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
			case "cc1":
				processCC1(request,response);
				break;
			case "cc2":
				processCC2(request,response);
				break;
			default:
				//Error Handling
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void processCC1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view;
		LinkedList<String> errorMsgs = new LinkedList<>();
		request.setAttribute("errors", errorMsgs);
		
		
		// 1. Retrieve Form Data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		
		
		// 2. Convert Form Data
		// N/A
		
		// 3. Validate Form Data
		if(name == null || name.trim().isEmpty()) {
			errorMsgs.add("姓名欄位必須填寫");
		}
		if(email == null || email.trim().isEmpty()) {
			errorMsgs.add("電郵欄位必須填寫");
		}
		if(telephone == null || telephone.trim().isEmpty()) {
			errorMsgs.add("電話欄位必須填寫");
		}
		if(address == null || address.trim().isEmpty()) {
			errorMsgs.add("地址欄位必須填寫");
		}
		
		if(!errorMsgs.isEmpty()) {
			view = request.getRequestDispatcher("createCustomer1.jsp");
			view.forward(request, response);
			return; //return是把控制權還給container
		}
		// 4. Invoke Business Logic
		try {
			Customer cust = new Customer();
			cust.setName(name);
			cust.setEmail(email);
			cust.setTelephone(telephone);
			cust.setAddress(address);
			
			HttpSession session = request.getSession();
			session.setAttribute("cust", cust); //Session Scope
			
			view = request.getRequestDispatcher("createCustomer2.jsp");
			view.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			errorMsgs.add(e.getMessage());
			view = request.getRequestDispatcher("createCustomer1.jsp");
			view.forward(request, response);
		}
		// 5. Select Next View
		
	}
	
	protected void processCC2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view;
		LinkedList<String> errorMsgs = new LinkedList<>();
		request.setAttribute("errors", errorMsgs);
		HttpSession session = request.getSession();
		// 1. Retrieve Form Data
		
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String[] habits = request.getParameterValues("habit");
		
		
		// 2. Convert Form Data
		// N/A
		
		// 3. Validate Form Data
		if(birth == null || birth.trim().isEmpty()) {
			errorMsgs.add("請挑選您的生日");
		}
		if(gender == null) {
			errorMsgs.add("請挑選您的性別");
		}
		if(habits == null) {
			errorMsgs.add("請至少勾選一項嗜好");
		}
		
		if(!errorMsgs.isEmpty()) {
			view = request.getRequestDispatcher("createCustomer2.jsp");
			view.forward(request, response);
			return; //return是把控制權還給container
		}
		// 4. Invoke Business Logic
		try {
			Customer cust = (Customer)session.getAttribute("cust");
			cust.setBirth(birth);
			cust.setGender(gender);
			cust.setHabits(habits);
			
			
			session.setAttribute("cust", cust);
			
			view = request.getRequestDispatcher("createSuccessful.jsp");
			view.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			errorMsgs.add(e.getMessage());
			view = request.getRequestDispatcher("createCustomer2.jsp");
			view.forward(request, response);
		}
		// 5. Select Next View
	}

}
