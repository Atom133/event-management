package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
public class Event implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String category;
	private String place;
	private Date dateEvent;
	private String InformationsOfTicket;
	//saafi work
	@OneToOne(mappedBy="event")
	private Gallery gallery;
	@OneToMany(mappedBy="event")
	private List<Ticket> tickets;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "createdBy")
	private President president;
	
	@OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Registration> registrations = new HashSet<Registration>();
	
	@OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Invitation> invitations = new HashSet<Invitation>();
	
	@OneToMany(mappedBy="event")
	@JsonIgnore
	private List<Task> tasks;
	
	@OneToMany(mappedBy="event" , cascade=CascadeType.ALL , fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Propositon> propositions = new ArrayList<Propositon>();
	
	
	public Event() {
		super();
	} 
	
	public Set<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(Set<Invitation> invitations) {
		this.invitations = invitations;
	}

	public String getInformationsOfTicket() {
		return InformationsOfTicket;
	}

	public void setInformationsOfTicket(String informationsOfTicket) {
		InformationsOfTicket = informationsOfTicket;
	}

	public President getPresident() {
		return president;
	}
	public void setPresident(President president) {
		this.president = president;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	@Column(name = "event_id")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}

	public void setName(String name) {
		this.name = name;
	}   
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public List<Propositon> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Propositon> propositions) {
		this.propositions = propositions;
	}

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
 
}
