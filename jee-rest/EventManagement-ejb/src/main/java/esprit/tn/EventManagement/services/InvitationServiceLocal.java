package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Local;

import esprit.tn.EventManagement.persistence.*;

@Local
public interface InvitationServiceLocal {

	public String sendInvitation(Participant p, Event e, User u);
	public List<Invitation> getAllInvitationsSend(Participant p);
	public List<Invitation> getAllInvitationsByInvited(int idInvited);
	public String updateInvitationSend(int id, User u);
	public String updateInvitationEtat(int id, String etat);
	public String deleteInvitation(int id);
	//public String acceptInvitations(int id);*/
	
}
