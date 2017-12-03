package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Invitation
 *
 */
@Entity
public class Invitation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date dateEnvoi;
	private int invited;
	private String etat;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    @JoinColumn(name = "event_id")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name = "invitedBy")
	private Participant participant;

	public Invitation() {
		super();
	}   
	
	public int getId() {
		return this.id;
	}

	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public void setId(int id) {
		this.id = id;
	}   
	
	public Date getDateEnvoi() {
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}   
	
	public int getInvited() {
		return this.invited;
	}

	public void setInvited(int invited) {
		this.invited = invited;
	}
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
   
}
