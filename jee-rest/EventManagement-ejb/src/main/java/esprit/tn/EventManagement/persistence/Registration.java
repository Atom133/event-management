package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Registration
 *
 */
@Entity
public class Registration implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date dateRegistration;
	private Double priceTicket;
	private String etatPayment;
	private String InformationsOfTicket;
	private int invitedBy;
	
	@ManyToOne
    @JoinColumn(name = "event_id")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name = "participant_id")
	private Participant participant;
	
	private static final long serialVersionUID = 1L;

	public Registration() {
		super();
	}   
	

	public int getId() {
		return this.id;
	}
 
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	

	public int getInvitedBy() {
		return invitedBy;
	}
	public void setInvitedBy(int invitedBy) {
		this.invitedBy = invitedBy;
	}
	

	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	public void setId(int id) {
		this.id = id;
	}   
	

	public String getEtatPayment() {
		return etatPayment;
	}
	public void setEtatPayment(String etatPayment) {
		this.etatPayment = etatPayment;
	}
	

	public String getInformationsOfTicket() {
		return InformationsOfTicket;
	}
	public void setInformationsOfTicket(String informationsOfTicket) {
		InformationsOfTicket = informationsOfTicket;
	}
	

	public Date getDateRegistration() {
		return this.dateRegistration;
	}

	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}   
	

	public Double getPriceTicket() {
		return this.priceTicket;
	}

	public void setPriceTicket(Double priceTicket) {
		this.priceTicket = priceTicket;
	}
   
}
