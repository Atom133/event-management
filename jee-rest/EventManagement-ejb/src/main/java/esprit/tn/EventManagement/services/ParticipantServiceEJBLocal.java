package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Local;

import esprit.tn.EventManagement.persistence.Participant;
import esprit.tn.EventManagement.persistence.Registration;

@Local
public interface ParticipantServiceEJBLocal {
	
	
 List<Participant> countParticipantPoints();
 boolean addParticipant();
 Participant getById(int id);

}
