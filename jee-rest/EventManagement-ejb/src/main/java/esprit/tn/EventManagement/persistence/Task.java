package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity

public class Task implements Serializable {

	   
	@Id
	private int id;
	private String description;
	private int assignBy;
	private int orderTo;
	private Date dateDebut;
	private Date dateFin;
	private String statutTask;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JsonBackReference
	private Event event;
	
	@ManyToOne
	@JsonBackReference
	private Organizer organizer;

	public Task() {
		super();
	}  
	
	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getStatutTask() {
		return statutTask;
	}

	public void setStatutTask(String statutTask) {
		this.statutTask = statutTask;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}  
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public int getAssignBy() {
		return this.assignBy;
	}

	public void setAssignBy(int assignBy) {
		this.assignBy = assignBy;
	}   
	public int getOrderTo() {
		return this.orderTo;
	}

	public void setOrderTo(int orderTo) {
		this.orderTo = orderTo;
	}
   @Override
	public String toString() {
		
		return super.toString()  + this.getAssignBy() + this.getDescription() + this.getId()+this.getEvent().getDescription() +this.getOrganizer().getEmail() ;
	}
}
