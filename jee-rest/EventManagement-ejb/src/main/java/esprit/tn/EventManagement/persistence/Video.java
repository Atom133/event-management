package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Image
 *
 */
@Entity

public class Video implements Serializable {

	
	private Integer id_Video;
	private String nom;
	private String description;
	private String url;
	
	private Gallery gallery;
	private User user;
	
	private static final long serialVersionUID = 1L;

	public Video() {
		super();
	}   
	@Id    
	public Integer getId_Video() {
		return this.id_Video;
	}

	public void setId_Video(Integer id_Video) {
		this.id_Video = id_Video;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@ManyToOne
	public Gallery getGallery() {
		return gallery;
	}
	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}
	
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
   
}
