package com.agilecrm.services;

import com.agilecrm.model.Contact;

public interface serviceOperations {
	public void addContactService(Contact c);
	public void delContactService(String email);
	public void updateContactService(Contact c,String email);
	public Contact retrieveContactService(int id);
	//public Contact retriveAllContacts();
}
