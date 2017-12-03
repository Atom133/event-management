package esprit.tn.EventManagement.services;

import java.util.List;

import javax.ejb.Remote;


import esprit.tn.EventManagement.persistence.Video;

@Remote
public interface GestionVideoRemote {

	public String addVideo(Video p);
	public void deleteVideo(int id);
	public void updateVideo(Video p);
	public Video findVideoById(int idVideo);
	public List<Video> findAllVideos();
}
