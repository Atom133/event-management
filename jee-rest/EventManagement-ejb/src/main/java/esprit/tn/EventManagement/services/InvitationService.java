package esprit.tn.EventManagement.services;

import java.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import esprit.tn.EventManagement.persistence.*;

/**
 * Session Bean implementation class InvitationService
 */
@Stateless
@LocalBean
public class InvitationService implements InvitationServiceRemote, InvitationServiceLocal {

	@PersistenceContext(unitName="EventManagement-ejb")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public InvitationService() {
        // TODO Auto-generated constructor stub
    }

    public String sendInvitation(Participant p, Event e, User u){
    	Invitation i = new Invitation();
    	//if(u!=null){
    		i.setInvited(u.getId());
        	i.setDateEnvoi(new Date());
        	i.setParticipant(p);
        	i.setEvent(e);
        	em.merge(i);
        	return "send succeeded";
    	/*}else{
    		return "User not found";
    	}*/
    }
    
    public List<Invitation> getAllInvitationsSend(Participant p){
    	Query query = em.createQuery("SELECT i FROM Invitation i WHERE i.participant = :invitedBy");
    	query.setParameter("invitedBy", p);
    		List<Invitation> invitations = query.getResultList();
    		return invitations;
    }
    
    public String updateInvitationSend(int id, User u){
    	Invitation i = em.find(Invitation.class, id);
    	i.setInvited(u.getId());
    	return "update suceeded";
    }
    
    public String updateInvitationEtat(int id, String etat){
    	Invitation i = em.find(Invitation.class, id);
    	i.setEtat(etat);
    	return "update suceeded";
    }
    
    public String deleteInvitation(int id){
    	Invitation i = em.find(Invitation.class, id);
    	em.remove(em.merge(i));
    	return "delete suceeded";
    }
    
    public List<Invitation> getAllInvitationsByInvited(int idInvited){
    	Query query = em.createQuery("SELECT i FROM Invitation i WHERE i.invited = :invited");
    	query.setParameter("invited", idInvited);
    		List<Invitation> invitations = query.getResultList();
    		return invitations;
    }

}
