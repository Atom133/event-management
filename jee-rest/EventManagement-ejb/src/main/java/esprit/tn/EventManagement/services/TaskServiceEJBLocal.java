package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Local;


import esprit.tn.EventManagement.persistence.Task;

@Local
public interface TaskServiceEJBLocal {
	public List<Task> consultAllTasksByOrganizer(int idOrg);
	public Task viewDetailTask(int idOrg);
	public Boolean rejectTask(int idTask);
	public Boolean confirmTask(int idTask);
	public List<Task> consultAllTasks() ;
}
