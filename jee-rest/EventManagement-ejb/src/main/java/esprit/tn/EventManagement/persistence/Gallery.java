package esprit.tn.EventManagement.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Gallery
 *
 */
@Entity

public class Gallery implements Serializable {

	
	private Integer id_Gallery;
	private String nom;
	private String description;
	
	private Event event;
	
	private List<Image> images;
	private List<Video> videos;
	
	private static final long serialVersionUID = 1L;

	public Gallery() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId_Gallery() {
		return this.id_Gallery;
	}

	public void setId_Gallery(Integer id_Gallery) {
		this.id_Gallery = id_Gallery;
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
	@OneToMany(mappedBy="gallery")
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	@OneToOne
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	@OneToMany(mappedBy="gallery")
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
   
}
