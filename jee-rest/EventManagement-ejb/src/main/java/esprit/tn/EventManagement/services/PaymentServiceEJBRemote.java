package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.Payment;

@Remote
public interface PaymentServiceEJBRemote {
	public Boolean addPayment(Payment pay);
	public Boolean deletePayment(int id);
	public Boolean modifyPayment(Payment pay);
	public Payment searchPaymentById(int id);
	public List<Payment> listAllPayment();
}
