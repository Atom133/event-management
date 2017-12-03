package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.Propositon;

@Remote
public interface PServiceEJBRemote {


	void addProposition(Propositon p);
	void UpdateProposition(Propositon p);
	void DeleteProposition(Propositon p);
	Propositon findById(int id);
	List<Propositon> findAll(); 
	
}
