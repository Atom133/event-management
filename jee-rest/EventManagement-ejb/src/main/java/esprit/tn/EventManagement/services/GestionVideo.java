package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import esprit.tn.EventManagement.persistence.Ticket;
import esprit.tn.EventManagement.persistence.Video;

/**
 * Session Bean implementation class GestionVideo
 */
@Stateless
@LocalBean
public class GestionVideo implements GestionVideoRemote {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionVideo() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public String addVideo(Video p) {
		em.persist(p);
		return "ok";
	}
	@Override
	public void deleteVideo(int id) {
		em.remove(em.merge(em.find(Video.class, id)));
		
	}
	@Override
	public void updateVideo(Video p) {
		em.merge(p);
		
	}
	@Override
	public Video findVideoById(int idVideo) {
		return em.find(Video.class, idVideo);
	}
	@Override
	public List<Video> findAllVideos() {
		return em.createQuery("SELECT c FROM Client c",Video.class).getResultList();
	}

}
