package esprit.tn.EventManagement.services;

import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import esprit.tn.EventManagement.persistence.Participant;


/**
 * Session Bean implementation class ParticipantServiceEJB
 */
@Stateless
public class ParticipantServiceEJB implements ParticipantServiceEJBRemote, ParticipantServiceEJBLocal {
	
	
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ParticipantServiceEJB() {
    }

	@Override
	public List<Participant> countParticipantPoints() {
		
		
		List<Participant> participants  = (List<Participant>) em.createQuery("select p from Participant p ").getResultList();
	 	for(Participant p : participants)
		{
			long invitedBy = (long) em.createQuery("select count(r) from Registration r  where r.invitedBy= :x").setParameter("x",p.getId()) .getSingleResult() ;
			long invitedTo = (long) em.createQuery("select count(r) from Registration r inner join r.participant p where p.id= :x").setParameter("x",p.getId()) .getSingleResult() ;
			if(invitedBy>0)
			{
			p.setPoints(invitedTo/invitedBy);
			}
			
			else
				p.setPoints(1);
			em.merge(p);
			
		System.out.println(p.getPoints());
			
		}
		
		return participants ;
	}

	@Override
	public boolean addParticipant() {
		
		em.persist(new Participant());
		return true;
	}

	@Override
	public Participant getById(int id) {
		return em.find(Participant.class,id);
	}

		
		
		
	


			
		
	

}
