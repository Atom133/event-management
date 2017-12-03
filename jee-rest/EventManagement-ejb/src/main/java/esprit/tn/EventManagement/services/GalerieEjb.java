package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import esprit.tn.EventManagement.persistence.Gallery;



/**
 * Session Bean implementation class GalerieEjb
 */
@Stateless
@LocalBean
public class GalerieEjb implements GalerieEjbRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;
    public GalerieEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addGalerie(Gallery c) {
		em.persist(c);
		
	}

	@Override
	public void deleteGalerie(Gallery c) {
		em.remove(c);
		
	}

	@Override
	public void updateGalerie(Gallery c) {
		em.merge(c);
		
	}

	@Override
	public Gallery findGalerieById(int idGalerie) {
		// TODO Auto-generated method stub
		return em.find(Gallery.class, idGalerie);
	}

	@Override
	public List<Gallery> findAllGalerie() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT c FROM Client c ",Gallery.class).getResultList();
	}

	

}
