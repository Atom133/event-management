package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.Participant;
import esprit.tn.EventManagement.persistence.Registration;

@Remote
public interface ParticipantServiceEJBRemote {
	
	 List<Participant> countParticipantPoints();
	 boolean addParticipant();
	 Participant getById(int id);





}
