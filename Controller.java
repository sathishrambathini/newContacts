package com.agilecrm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agilecrm.model.Contact;
import com.agilecrm.serviceImpl.ServiceImpl;
import com.agilecrm.util.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ObjectMapper mapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("in doGet Method");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doPost Method");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hello you in doPost");
		String type = request.getParameter("actionType");
		ServiceImpl s = new ServiceImpl();
		if (type.equals("add")) {
			try {
				Contact c = new Contact();
				c.setFirstName(request.getParameter("fName"));
				c.setLastName(request.getParameter("lName"));
				c.setEmail(request.getParameter("email"));
				c.setCreatedBy(request.getParameter("createdBy"));
				c.setCreatedDate(DateUtil.toDateTime(request.getParameter("createdDate")));
				c.setAddress(request.getParameter("address"));
				c.setDob(DateUtil.toDate(request.getParameter("dob")));
				c.setActive(true);
				c.setUpdatedBy(request.getParameter("updatedBy"));
				c.setUpdatedDate((DateUtil.toDateTime(request.getParameter("updatedDate"))));
				s.addContactService(c);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (type.equals("delete")) {
			String email = request.getParameter("email");
			s.delContactService(email);
		} else if (type.equals("update")) {
			Contact c = new Contact();
			String email = request.getParameter("email");
			c.setFirstName(request.getParameter("fName"));
			s.updateContactService(c, email);
		} else if (type.equals("retrive")) {
			String id1 = request.getParameter("id");
			int id = Integer.parseInt(id1);
			Contact cc = s.retrieveContactService(id);
			mapper.writeValueAsString(cc);

			String jsonInString1 = mapper.writeValueAsString(cc);
			System.out.println(jsonInString1);

			jsonInString1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cc);
			System.out.println(jsonInString1);

		}
	}
}
