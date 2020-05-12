package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.Photo;
import com.intiformation.gestionimmo.repository.PhotoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/photo-rest")
public class PhotoRest {

	@Autowired
	private PhotoRepository photoRepo;

	public void setPhotoRepo(PhotoRepository photoRepo) {
		this.photoRepo = photoRepo;
	}
	
	
	@RequestMapping(value="/photoList", method=RequestMethod.GET)
	public List<Photo> listePhoto() {
		return photoRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/photoAdd", method=RequestMethod.POST)
	public void savePhoto(@RequestBody Photo photo) {
		
		photoRepo.save(photo);
		
	}//end save
	
	@RequestMapping(value="/photo/{id_photo}", method=RequestMethod.GET)
	public Photo getPhoto(@PathVariable("id_photo") int pIdPhoto) {
		
		return photoRepo.getPhotoById(pIdPhoto);
		
	}//end get
	
	
	@RequestMapping(value="/photoUpdate/{id_photo}", method=RequestMethod.PUT)
	public void upPhoto (@PathVariable("id_photo") int pIdPhoto, @RequestBody Photo pPhoto) {
		
		photoRepo.saveAndFlush(pPhoto);
		
	}//end update
	
	
	@RequestMapping(value="/photoDelete/{id_photo}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delPhoto(@PathVariable("id_photo") int pIdPhoto) {
		
		photoRepo.deleteById(pIdPhoto);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
	@RequestMapping(value="/photoList/bien/{id_bien}", method=RequestMethod.GET)
	public List<Photo> listePhotoByIdBien(@PathVariable("id_bien") int pIdBien) {
		return photoRepo.getPhotoByIdBien(pIdBien);
	
	}//end getallByIdBien
	
	
}
