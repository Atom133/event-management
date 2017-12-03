package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Payment
 *
 */
@Entity

public class Payment implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String typePayment;
	private String email;
	private String firstName;
	private String lastName;
	private Double priceTicket;
	private static final long serialVersionUID = 1L;

	public Payment() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTypePayment() {
		return this.typePayment;
	}

	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public Double getPriceTicket() {
		return this.priceTicket;
	}

	public void setPriceTicket(Double priceTicket) {
		this.priceTicket = priceTicket;
	}
   
}
