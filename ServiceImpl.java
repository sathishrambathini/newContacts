package com.agilecrm.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.agilecrm.daoImpl.DaoImpl;
import com.agilecrm.model.Contact;
import com.agilecrm.services.serviceOperations;

public class ServiceImpl implements serviceOperations {

	public void addContactService(Contact c) 
	{
		DaoImpl d=new DaoImpl();
		d.addContact(c);
	}
	public void delContactService(String c1)
	{
		DaoImpl d1=new DaoImpl();
		d1.delContact(c1);
	}
	public void updateContactService(Contact c, String email) 
	{
		DaoImpl d=new DaoImpl();
		d.updateContact(c, email);
	}
	public Contact retrieveContactService(int id) 
	{
		DaoImpl d=new DaoImpl();
		return d.retrieveContact(id);
	}
	/**public Contact retriveAllContacts() {
		// TODO Auto-generated method stub
		DaoImpl d=new DaoImpl();
		return d.retrieveContact(id);
	}*/
}
















































