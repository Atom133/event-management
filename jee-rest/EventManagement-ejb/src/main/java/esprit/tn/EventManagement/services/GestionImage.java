package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import esprit.tn.EventManagement.persistence.Image;
import esprit.tn.EventManagement.persistence.Ticket;

/**
 * Session Bean implementation class GestionImage
 */
@Stateless
@LocalBean
public class GestionImage implements GestionImageRemote {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionImage() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public String addImage(Image i) {
		em.persist(i);
		return "ok";
	}
	@Override
	public void deleteImage(int id ) {
		em.remove(em.merge(em.find(Image.class, id)));
		
	}
	@Override
	public void updateImage(Image i) {
		em.merge(i);
		
	}
	@Override
	public Image findImageById(int idIm) {
		return em.find(Image.class, idIm);
	}
	@Override
	public List<Image> findAllImages() {
		return em.createQuery("SELECT c FROM Client c",Image.class).getResultList();
	}

}
