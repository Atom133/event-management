package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import esprit.tn.EventManagement.persistence.*;

/**
 * Session Bean implementation class TaskServiceEJB
 */
@Stateless
@LocalBean
public class TaskServiceEJB implements TaskServiceEJBRemote, TaskServiceEJBLocal {
	@PersistenceContext(unitName="EventManagement-ejb") 
	EntityManager em ;
	
	
    /**
     * Default constructor. 
     */
    public TaskServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Task> consultAllTasksByOrganizer(int idOrg) {
	   try{
		   	 return em.createQuery(
				        "SELECT t FROM Task t WHERE t.organizer.id = :myOrganizer",Task.class)
				        .setParameter("myOrganizer", idOrg).getResultList();
	    } catch(Exception e) {
	        return null;
	    }   
	}


	
	@Override
	public Task viewDetailTask(int idTask) {
 	   try{
 			return (Task) em.createQuery("SELECT t FROM Task t WHERE t.id = :idTask ",Task.class)
					.setParameter("idTask", idTask)
					.getSingleResult();
	    } catch(NoResultException e) {
	        return null;
	    }
	}

	@Override
	public Boolean rejectTask(int idTask) {
		Task mytask = em.find(Task.class, idTask);
		mytask.setStatutTask("rejected");
		em.merge(mytask);
		return true;
	}
	public Boolean confirmTask(int idTask) {
		Task mytask = (Task)	
		this.viewDetailTask(idTask);
		mytask.setStatutTask("confirmed");
		em.merge(mytask);
		return true;
	}
	@Override
	public List<Task> consultAllTasks() {

	 return em.createQuery("SELECT t FROM Task t",Task.class).getResultList();
		        
	}


}
