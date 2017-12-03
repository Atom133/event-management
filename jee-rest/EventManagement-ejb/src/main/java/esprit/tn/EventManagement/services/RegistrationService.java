package esprit.tn.EventManagement.services;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import esprit.tn.EventManagement.persistence.*;

/**
 * Session Bean implementation class RegistrationService
 */
@Stateless
@LocalBean
public class RegistrationService implements RegistrationServiceRemote, RegistrationServiceLocal {

	@PersistenceContext(unitName="EventManagement-ejb")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public RegistrationService() {
    }

	@Override
	public String register(Participant p, Double priceTicket, String informationsOfTicket, Event e, String etatPayment, int invitedBy) {
		
		String etat=null;
		Registration registration = new Registration();
		registration.setDateRegistration(new Date());
		registration.setPriceTicket(priceTicket);
		registration.setInformationsOfTicket(informationsOfTicket);
		registration.setInvitedBy(invitedBy);
		registration.setParticipant(p);
		
		registration.setEvent(e);
		
		if(informationsOfTicket.equals("Payant"))
		{
			//Methode de payment 
			if(etatPayment.equals("payé")){
				registration.setEtatPayment(etatPayment);
				em.merge(registration);
				etat = "registration succeeded";
			}
			else
				etat = "registration failed";
		}else{
			registration.setEtatPayment(etatPayment);
			em.merge(registration);
			etat = "registration succeeded";
		}
		return etat;
	}

}
