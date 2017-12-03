package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.Image;

@Remote
public interface GestionImageRemote {
	
	public String addImage(Image i);
	public void deleteImage(int id);
	public void updateImage(Image i);
	public Image findImageById(int idIm);
	public List<Image> findAllImages();

}
