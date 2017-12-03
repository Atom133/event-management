package esprit.tn.EventManagement.services;

import java.util.Calendar;
//import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
//import javax.persistence.PrePersist;
//import javax.persistence.Query;

import esprit.tn.EventManagement.persistence.User;

/**
 * Session Bean implementation class UserServiceEJB
 */
@Stateless
@LocalBean
public class UserServiceEJB implements UserServiceEJBRemote, UserServiceEJBLocal {

	@PersistenceContext(unitName = "EventManagement-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UserServiceEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> findAllUsers() {
		return em.createQuery("SELECT u FROM User u ", User.class).getResultList();
	}

	@Override
	public List<User> findUserByName(String name) {
		return em.createQuery("SELECT u FROM User u WHERE u.firstName LIKE :name", User.class)
				.setParameter("name", name).getResultList();
	}

	@Override
	public User findUserByCin(long cin) {
		try {
			return (User) em.createQuery("SELECT u FROM User u WHERE u.cin = :mycin", User.class)
					.setParameter("mycin", cin).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public User findUserById(int id) {

		try {
			return (User) em.createQuery("SELECT u FROM User u WHERE u.id = :myid", User.class).setParameter("myid", id)
					.getSingleResult();
		} catch (Exception u) {
			return null;
		}

	}

	@Override
	public String createUser(User user) {
		User userExist = findUserById(user.getId());

		if (userExist == null) {
			if (user.getStatutUser() == null) {
				user.setStatutUser("active");
			}
			if (user.getRole() == null) {
				this.registerUserRole(user);
			}
			em.persist(user);
			java.util.Date date = Calendar.getInstance().getTime();
			user.setDateRegistration(date);
			return "Add User success";
		}
		return "Add User failed";
	}

	public void registerUserRole(User user) {

		switch (user.getClass().getSimpleName()) {
		case "Organizer":
			user.setRole("organizer");
			break;
		case "President":
			user.setRole("president");
			break;

		default:
			user.setRole("user");
			break;
		}
	}

	@Override
	public String deleteUser(User user) {
		if (user != null) {
			em.remove(em.merge(user));
			return "Delete ok !";

		}
		return "delete user failed";
	}

	@Override
	public String updateUser(User user) {
//		User userExist = findUserById(user.getId());
//		if (userExist != null) {
			this.registerUserRole(user);
		em.merge(user);
		return "update ok!";
//			return "Update User success";
//		}
//		return "Update User failed";
	}

	@Override
	public User authentificate(String login, String pwd) {

		User user = (User) em.createQuery("select u from User u where u.login like :l and u.pwd like :p")
				.setParameter("l", login).setParameter("p", pwd).getSingleResult();
		try {
			System.out.println("Authentification succes");
		} catch (Exception u) {
			user = null;
		}
		return user;

	}

	@Override
	public String BlockUser(int id) {
		User userExist = findUserById(id);
		if (userExist != null) {
			userExist.setStatutUser("blocked");
			em.merge(userExist);
			return "user blocked";
		}
		return "update User failed";

	}

	@Override
	public String ActivateUser(int id) {
		User userExist = findUserById(id);
		if (userExist != null) {
			userExist.setStatutUser("active");
			em.merge(userExist);
			return "User activated";
		}
		return "update User failed";

	}

}
