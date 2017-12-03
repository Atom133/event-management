package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Participant
 *
 */
@Entity
public class Participant extends User implements Serializable {

	@Column(name="points",nullable=true)
	private float points;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "participant",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Registration> registrations = new HashSet<Registration>();
	
	@OneToMany(mappedBy = "participant",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Invitation> invitations = new HashSet<Invitation>();

	@OneToMany(mappedBy="user" , cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Propositon> propositions = new ArrayList<Propositon>();
	
	
	public Participant() {
		super();
	}

	public List<Propositon> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Propositon> propositions) {
		this.propositions = propositions;
	}

	public float getPoints() {
		return this.points;
	}
	
	public Set<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(Set<Invitation> invitations) {
		this.invitations = invitations;
	}

	
	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}

	public void setPoints(float points) {
		this.points = points;
	}
   
}
