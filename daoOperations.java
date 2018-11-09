package com.agilecrm.dao;

import java.util.List;

import com.agilecrm.model.Contact;

public interface daoOperations {
	public void addContact(Contact c);
	public void delContact(String name);
	public void updateContact(Contact c , String email);
	public Contact retrieveContact(int id);
	//public List<Contact> retrieveContacts();
	//public List<Contact> retrieveContacts(String arg);
}
