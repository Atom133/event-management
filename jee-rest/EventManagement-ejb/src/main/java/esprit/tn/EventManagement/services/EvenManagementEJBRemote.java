package esprit.tn.EventManagement.services;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.Event;

@Remote
public interface EvenManagementEJBRemote {
	
	
	String seeDetailsAboutEvent( int id);
	Event getById(int id);


}
