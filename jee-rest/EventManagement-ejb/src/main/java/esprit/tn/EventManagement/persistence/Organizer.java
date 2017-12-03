package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlList;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Organizer
 *
 */
@Entity
public class Organizer extends User implements Serializable {

	
	private int nbrTask;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="organizer")
	@JsonIgnore
	private List<Task> tasks;

	public Organizer() {
		super();
	}   
	
	@XmlList
	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}


	public int getNbrTask() {
		return this.nbrTask;
	}

	public void setNbrTask(int nbrTask) {
		this.nbrTask = nbrTask;
	}
   
}
