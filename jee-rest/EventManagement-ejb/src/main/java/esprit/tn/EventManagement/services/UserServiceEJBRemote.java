package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.User;

@Remote
public interface UserServiceEJBRemote {

	/**
	 * 
	 * @return Returns the list of users
	 */
	public List<User> findAllUsers();

	/**
	 * Finds the user by name
	 * 
	 * @param name
	 * @return returns the User
	 */
	public List<User> findUserByName(String name);

	/**
	 * Finds the user by cin
	 * 
	 * @param cin
	 * @return returns the User
	 */
	public User findUserByCin(long cin);

	/**
	 * Finds the user by id
	 * 
	 * @param id
	 * @return returns the User
	 */
	public User findUserById(int id);

	/**
	 * Creates a user in the database
	 * 
	 * @param user
	 */
	public String createUser(User user);

	/**
	 * deletes the user from the database
	 * 
	 * @param user
	 */
	public String deleteUser(User user);

	/**
	 * updates the user in the database
	 * 
	 * @param user
	 */
	public String updateUser(User user);

	/**
	 * authenticate the user
	 * 
	 * @param login
	 * @param pwd
	 * @return
	 */
	public User authentificate(String login, String pwd);

	/**
	 * block the user
	 * 
	 * @param id
	 * @return
	 */
	public String BlockUser(int id);

	/**
	 * Activate user
	 * 
	 * @param id
	 * @return
	 */
	public String ActivateUser(int id);

}
