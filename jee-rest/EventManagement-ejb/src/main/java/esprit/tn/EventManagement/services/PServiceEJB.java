package esprit.tn.EventManagement.services;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import esprit.tn.EventManagement.persistence.Propositon;

/**
 * Session Bean implementation class PServiceEJB
 */
@Stateless
public class PServiceEJB implements PServiceEJBRemote, PServiceEJBLocal {

	
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public PServiceEJB() {
    	
    	
    }

	@Override
	public void addProposition(Propositon p) {
		em.persist(p);
	}

	@Override
	public void UpdateProposition(Propositon p) {
		em.merge(p);
	}

	@Override
	public void DeleteProposition(Propositon p) {
		em.remove(em.merge(em.find(Propositon.class,p.getId())));
	}

	@Override
	public Propositon findById(int id) {
		return em.find(Propositon.class,id);
		
	}

	@Override
	public List<Propositon> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
