package esprit.tn.EventManagement.services;

import javax.ejb.Local;

import esprit.tn.EventManagement.persistence.*;

@Local
public interface RegistrationServiceLocal {

	public String register(Participant p, Double priceTicket, String informationsOfTicket, Event e, String etatPayment, int invitedBy);

}
