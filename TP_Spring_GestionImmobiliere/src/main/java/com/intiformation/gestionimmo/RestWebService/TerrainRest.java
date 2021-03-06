package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.Terrain;
import com.intiformation.gestionimmo.repository.TerrainRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/terrain-rest")
public class TerrainRest {
	
	@Autowired
	private TerrainRepository terrainRepo;

	public void setTerrainRepo(TerrainRepository terrainRepo) {
		this.terrainRepo = terrainRepo;
	}
	
	
	@RequestMapping(value="/terrainList", method=RequestMethod.GET)
	public List<Terrain> listeTerrain() {
		return terrainRepo.findAll();
	
	}//end getall	
	
//	@PreAuthorize("hasAnyRole('ADMIN','AGENT','LOC','PROP')")	
	@RequestMapping(value="/terrainAdd", method=RequestMethod.POST)
	public void saveTerrain(@RequestBody Terrain terrain) {
		
		terrainRepo.save(terrain);
		
	}//end save
	
	@RequestMapping(value="/terrain/{identifiant}", method=RequestMethod.GET)
	public Terrain getTerrain(@PathVariable("identifiant") int pIdTerrain) {
		
		return terrainRepo.getTerrainById(pIdTerrain);
		
	}//end get
	
//	@PreAuthorize("hasAnyRole('ADMIN','AGENT','LOC','PROP')")
	@RequestMapping(value="/terrainUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upTerrain (@PathVariable("identifiant") int pIdTerrain, @RequestBody Terrain pTerrain) {
		
		terrainRepo.saveAndFlush(pTerrain);
		
	}//end update
	
//	@PreAuthorize("hasAnyRole('ADMIN','AGENT','LOC','PROP')")	
	@RequestMapping(value="/terrainDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delTerrain(@PathVariable("identifiant") int pIdTerrain) {
		
		terrainRepo.deleteById(pIdTerrain);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
	@RequestMapping(value="/terrainList/prix/{prixMax}", method=RequestMethod.GET)
	public List<Terrain> listeTerrainByPrixMax(@PathVariable("prixMax") int pPrixMax) {
		return terrainRepo.getTerrainByPrixMax(pPrixMax);
	
	}//end getAllByPrixMax
	
	
	@RequestMapping(value="/terrainList/offre/{offre}", method=RequestMethod.GET)
	public List<Terrain> listeTerrainByOffre(@PathVariable("offre") String pOffre) {
		return terrainRepo.getTerrainByOffre(pOffre);
	
	}//end getAllByOffre
	
	
	@RequestMapping(value="/terrainList/superficie/{superficie}", method=RequestMethod.GET)
	public List<Terrain> listeTerrainBySuperficie(@PathVariable("superficie") int pSuperficie) {
		return terrainRepo.getTerrainBySuperficie(pSuperficie);
	
	}//end getAllBySuperficie
	

}
