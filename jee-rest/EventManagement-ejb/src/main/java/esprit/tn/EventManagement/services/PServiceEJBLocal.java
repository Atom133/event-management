package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Local;

import esprit.tn.EventManagement.persistence.Propositon;

@Local
public interface PServiceEJBLocal {
	

	void addProposition(Propositon p);
	void UpdateProposition(Propositon p);
	void DeleteProposition(Propositon p);
	Propositon findById(int id);
	List<Propositon> findAll(); 

}
