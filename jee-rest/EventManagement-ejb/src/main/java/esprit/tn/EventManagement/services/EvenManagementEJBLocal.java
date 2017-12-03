package esprit.tn.EventManagement.services;

import javax.ejb.Local;

import esprit.tn.EventManagement.persistence.Event;

@Local
public interface EvenManagementEJBLocal {
	
	
	String seeDetailsAboutEvent( int id);
	Event getById(int id);


}
