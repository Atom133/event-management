package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.EventManagement.persistence.Gallery;


@Remote
public interface GalerieEjbRemote {

	public void addGalerie(Gallery c);
	public void deleteGalerie(Gallery c);
	public void updateGalerie(Gallery c);
	public Gallery findGalerieById(int idGalerie);
	public List<Gallery>findAllGalerie();
	
	
	
}
