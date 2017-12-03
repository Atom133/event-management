package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.*;

@Remote
public interface InvitationServiceRemote {

	public String sendInvitation(Participant p, Event e, User u);
	public List<Invitation> getAllInvitationsSend(Participant p);
	public String updateInvitationSend(int id, User u);
	public String updateInvitationEtat(int id, String etat);
	public String deleteInvitation(int id);
	public List<Invitation> getAllInvitationsByInvited(int idInvited);
	//public String acceptInvitations(int id);*/
	
}
