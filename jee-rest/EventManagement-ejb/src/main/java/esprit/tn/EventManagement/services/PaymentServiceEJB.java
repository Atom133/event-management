package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import esprit.tn.EventManagement.persistence.Payment;


/**
 * Session Bean implementation class PaymentServiceEJB
 */
@Stateless
@LocalBean
public class PaymentServiceEJB implements PaymentServiceEJBRemote, PaymentServiceEJBLocal {
	@PersistenceContext(unitName="EventManagement-ejb") 
	EntityManager em ;
    /**
     * Default constructor. 
     */
    public PaymentServiceEJB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public Boolean addPayment(Payment pay) {
	
			em.persist(pay);
			return true;

	
	}
	@Override
	public Payment searchPaymentById(int id) {
	 	   try{
	 			return (Payment) em.createQuery("SELECT p FROM Payment p WHERE p.id = :id ",Payment.class)
						.setParameter("mail", id)
						.getSingleResult();
		    } catch(NoResultException e) {
		        return null;
		    }
		}

	@Override
	public Boolean deletePayment(int id) {
			Payment pay = em.find(Payment.class, id);
			if(pay!= null){
				em.remove(em.merge(pay));
				return true;
			}
			return false;
		
		
	}

	@Override
	public Boolean modifyPayment(Payment pay) {
		em.merge(pay);
		return true;
	}
	@Override
	public List<Payment> listAllPayment() {
		   try{
			   	 return em.createQuery(
					        "SELECT p FROM Payment p ",Payment.class).getResultList();
		    } catch(Exception e) {
		        return null;
		    }   
		}

    
    
    
}
