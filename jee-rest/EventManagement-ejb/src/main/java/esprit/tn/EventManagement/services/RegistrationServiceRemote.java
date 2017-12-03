package esprit.tn.EventManagement.services;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.*;

@Remote
public interface RegistrationServiceRemote {

	public String register(Participant p, Double priceTicket, String informationsOfTicket, Event e, String etatPayment, int invitedBy);

}
