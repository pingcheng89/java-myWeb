package com.systex.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

import com.systex.model.Customer;

/**
 * Servlet implementation class CreateCustomerController
 */
public class CreateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher view;
		LinkedList<String> errorMsgs = new LinkedList<>();
		request.setAttribute("errors", errorMsgs);
		
		// 1. Retrieve Form Data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String[] habits = request.getParameterValues("habit");
		
		
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
			view = request.getRequestDispatcher("createCustomer.jsp");
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
			cust.setBirth(birth);
			cust.setGender(gender);
			cust.setHabits(habits);
			
			request.setAttribute("cust", cust);
			
			view = request.getRequestDispatcher("createSuccessful.jsp");
			view.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			errorMsgs.add(e.getMessage());
			view = request.getRequestDispatcher("createCustomer.jsp");
			view.forward(request, response);
		}
		// 5. Select Next View
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
