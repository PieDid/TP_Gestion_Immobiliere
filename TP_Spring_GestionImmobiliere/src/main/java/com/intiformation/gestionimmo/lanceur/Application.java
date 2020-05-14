package com.intiformation.gestionimmo.lanceur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
///////////////////////////////////////////////////////////////////////////////////////////////////////////
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
///////////////////////////////////////////////////////////////////////////////////////////////////////////
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.intiformation.gestionimmo.RestWebService.AdministrateurRest;
import com.intiformation.gestionimmo.RestWebService.AgentRest;
import com.intiformation.gestionimmo.RestWebService.ClientRest;
import com.intiformation.gestionimmo.RestWebService.LocataireRest;
import com.intiformation.gestionimmo.RestWebService.ProprietaireRest;
import com.intiformation.gestionimmo.domain.*;
import com.intiformation.gestionimmo.repository.*;


@SpringBootApplication
@ComponentScan(basePackages = {"com.intiformation.gestionimmo"})
//@ComponentScan({"com.intiformation.gestionimmo"})
//////////////////////////////////////////////////////////////////////////////////////////////////////////
@EnableJpaRepositories("com.intiformation.gestionimmo.repository")
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//@EntityScan : détection des classes entités par spring boot 
@EntityScan(basePackages= {"com.intiformation.gestionimmo.domain"})
public class Application implements CommandLineRunner{

	@Autowired
	private Environment appEnvironment; // pour pointer le fichier application.properties
	
	//déclaration + injection de couche DAO
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AdresseRepository adresseRepository;
	
	@Autowired
	private AdressePersonneRepository adressePRepository;
	
	@Autowired
	private AdresseBienRepository adresseBRepository;
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private TerrainRepository terrainRepository;
	
	@Autowired
	private ProprietaireRepository proprietaireRepository;
	
	@Autowired
	private AdministrateurRepository administrateurRepository;
	
	@Autowired
	private LocataireRepository locataireRepository;
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired
	private BienRepository bienRepository;
	
	@Autowired
	private ContratRepository contratRepository;
	
	@Autowired
	private ContratLocationRepository contratLocationRepository;
	
	@Autowired
	private ContratVenteRepository contratVenteRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	/**
	 * Methode main : lance l'application
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext conteneurIoCSpring = SpringApplication.run(Application.class, args);
		System.out.println("... Lancement de l'application ...");
	}//end main
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * méthode de l'interface CommandLineRunner qu'on va utiliser pour
	 * tester la couche Dao implémentée dans la classe UserRepository. <br/>
	 * la méthode va s'exécuter après l'exécution de l'application.
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("... dans la méthode run()....");
	
		
//		/*________ Exposition (intégration) de l'id de user dans le ws __________*/
//		repositoryRestConfiguration.exposeIdsFor(User.class);
		
		
		/*========================================================================*/
		/*============== Méthode de bases de la DAO (*Repository) =============*/
		/*========================================================================*/
		
		/*========================================================================*/
		/*============== Ajout des role dans la table roles =============*/
		/*========================================================================*/

		Role roleClient = new Role(ERole.ROLE_CLIENT);
		Role roleProp = new Role(ERole.ROLE_PROP);
		Role roleAgent = new Role(ERole.ROLE_AGENT);
		Role roleAdmin = new Role(ERole.ROLE_ADMIN);
		Role roleLoc = new Role(ERole.ROLE_LOC);
		
		roleRepository.save(roleClient);
		roleRepository.save(roleProp);
		roleRepository.save(roleAgent);
		roleRepository.save(roleAdmin);
		roleRepository.save(roleLoc);
		
		/*========================================================================*/
		/*============== Tests sur les Méthode de AdresseRepository =============*/
		/*========================================================================*/
		/*____________________________ ajout d'une adressePersonne & adresseBien ___________________________*/
		// définir l'adressePersonne à ajouter
		AdressePersonne adresseP = new AdressePersonne("rue_P", "codePostal_P", "ville_P");
		AdressePersonne adresseP1 = new AdressePersonne("rue_P1", "codePostal_P1", "ville_P1");
		
		// définir l'adresseBien à ajouter
		AdresseBien adresseB = new AdresseBien("rue_B", "codePostal_B", "ville_B");
		AdresseBien adresseB1 = new AdresseBien("rue_B1", "codePostal_B1", "ville_B1");
		
		adressePRepository.save(adresseP1);
		adresseBRepository.save(adresseB1);
		
		/*____________________________ liste des adresses ___________________________*/
		List<Adresse> listeAdresses = adresseRepository.findAll();
		
		System.out.println("Liste des adresses dans la bdd : ");
		for (Adresse a : listeAdresses) {
			System.out.println("\t > " + a.toString());
		}
		/*____________________________ liste des adresses Personnes ___________________________*/
		List<AdressePersonne> listeAdressesPersonnes = adressePRepository.findAll();
		
		System.out.println("Liste des adressesPersonnes dans la bdd : ");
		for (AdressePersonne a : listeAdressesPersonnes) {
			System.out.println("\t > " + a.toString());
		}
		/*____________________________ liste des adresses Biens ___________________________*/
		List<AdresseBien> listeAdressesBiens = adresseBRepository.findAll();
		
		System.out.println("Liste des adressesBiens dans la bdd : ");
		for (AdresseBien a : listeAdressesBiens) {
			System.out.println("\t > " + a.toString());
		}
		
		/*____________________________ modif d'une adressePersonne & adresseBien ____________*/
		adresseP1.setCodePostal("75009");
		adresseB1.setCodePostal("75010");
		adressePRepository.save(adresseP1);
		adresseBRepository.save(adresseB1);
		
		/*____________________________ méthodes non crud sur adresse ____________*/
		Adresse ad = adresseRepository.getAdresseById(1);
		System.out.println("\t > " + ad.getIdAdresse() + " : " + ad.getRue() + ", " + ad.getCodePostal());
		
		ad = adresseRepository.getAdresseByRue("rue_B1");
		System.out.println("GET BY RUE\n\t > " + ad.getIdAdresse() + " : " + ad.getRue() + ", " + ad.getCodePostal());
		
		List<Adresse> liste_ad = adresseRepository.getListeAdresseByCodePostal("75009");
		for (Adresse a : liste_ad) {
			System.out.println("\t > " + a.getIdAdresse() + " : " + a.getRue() + ", " + a.getCodePostal());
		}
		
		liste_ad = adresseRepository.getListeAdresseByVille("ville_P");
		for (Adresse a : liste_ad) {
			System.out.println("\t > " + a.getIdAdresse() + " : " + a.getRue() + ", " + a.getCodePostal());
		}
		
		/*____________________________ suppression d'une adressePersonne & adresseBien ____________*/
		//suppression de l'entité par son id
//		adressePRepository.deleteById(1);
		
		//suppression de l'entité
//		adresseBRepository.delete(adresseB1);
		
		
		/*========================================================================*/
		/*============== Tests sur les Méthode de TerrainRepository ===============*/
		/*========================================================================*/
		// définir les terrains à ajouter
		Terrain terrain = new Terrain(true, "offre", 15000.00, "standard", null, "10/10/2020", "10/10/2020", null, null, 1230);
		Terrain terrain1 = new Terrain(true, "offre1", 25000.00, "standard1", null, "15/11/2020", "15/11/2020", null, null, 2000);
		
		terrainRepository.save(terrain);
		terrainRepository.save(terrain1);
				
		/*____________________________ liste des terrains ___________________________*/
		List<Terrain> listeTerrains = terrainRepository.findAll();
			
		System.out.println("Liste des terrains dans la bdd : ");
		for (Terrain a : listeTerrains) {
			System.out.println("\t > " + a.getId_bien() + " : \tOffre :" + a.getOffre() + ", " + a.getPrix() + "€ , Superficie : " + a.getSuperficie() + " Ares");
		}
		
				
		/*____________________________ modif d'un terrain ____________*/
		Terrain t = terrainRepository.getTerrainById(2);
		System.out.println("MODIF TERRAIN\n\t > " + t.getId_bien() + " : \tOffre :" + t.getOffre() + ", " + t.getPrix() + "€ , Superficie : " + t.getSuperficie() + " Ares");
		
		t.setPrix(17500.00);
		System.out.println("\t > " + t.getId_bien() + " : \tOffre :" + t.getOffre() + ", " + t.getPrix() + "€ , Superficie : " + t.getSuperficie() + " Ares");
		terrainRepository.save(t);
		
		
		/*____________________________ méthodes non crud sur terrain ____________*/
		List<Terrain> liste_t = terrainRepository.getTerrainByOffre("offre1");
		for (Terrain a : liste_t) {
			System.out.println("GET BY OFFRE\n\t > " + a.getId_bien() + " : \tOffre :" + a.getOffre() + ", " + a.getPrix() + "€ , Superficie : " + a.getSuperficie() + " Ares");
		}
		
		liste_t = terrainRepository.getTerrainByPrixMax(20000.00);
		for (Terrain a : liste_t) {
			System.out.println("GET BY PrixMax\n\t > " + a.getId_bien() + " : \tOffre :" + a.getOffre() + ", " + a.getPrix() + "€ , Superficie : " + a.getSuperficie() + " Ares");
		}
		
		liste_t = terrainRepository.getTerrainBySuperficie(1500);
		for (Terrain a : liste_t) {
			System.out.println("GET BY Superficie\n\t > " + a.getId_bien() + " : \tOffre :" + a.getOffre() + ", " + a.getPrix() + "€ , Superficie : " + a.getSuperficie() + " Ares");
		}
		
				
		/*____________________________ suppression d'un terrain ____________*/
		//suppression de l'entité par son id
//		terrainRepository.deleteById(1);
				
		//suppression de l'entité
//		terrainRepository.delete(t);
		

		/*========================================================================*/
		/*============== Tests sur les Méthode de ClientRepository ===============*/
		/*========================================================================*/
		/*____________________________ ajout d'un Client ___________________________*/
		// définir le Client à ajouter
		Client client1 = new Client("nom", "email", "motDePasse", true, "Andre_Fernandes.png", null, null, null);

		
		//ajout du client via la méthode save()
		// Encodage
		client1.setMotDePasse(encoder.encode(client1.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles = new HashSet<>();
		Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(clientRole);
		client1.setRoles(roles);
		clientRepository.save(client1);
		
		
		/*____________________________ liste des users ___________________________*/
		List<Client> listeClients = clientRepository.findAll();
		
		System.out.println("Liste des clients dans la bdd : ");
		for (Client c : listeClients) {
			System.out.println("\t > " + c.getIdentifiant() + " : " + c.getNom());
		}
		
		
		/*______________________ récup d'un client via son id ______________________*/
		/**
		 * 		> utilisation de la méhode findById()
		 * 				-> cette méthode retourne un type Optional<T>
		 * 						-> Optional<T> : objet conteneur pouvant ou non contenir
		 * 										 une valeur non null.
		 * 
		 * 										 si une valeur est présente, la méthode isPresent() renvoie 'true'
		 * 										 et la méthode get() renvoie la valeur
		 */
		System.out.println("Récup d'un client via son id : ");
		
		Client clientId1 = null;
		
		Optional<Client> clientOpt = clientRepository.findById(1);
		
		if(clientOpt.isPresent()) {
			clientId1 = clientOpt.get();
			System.out.println("\t -> " + clientId1.getIdentifiant() + " : " + clientId1.getNom());
		}
		
		
		/*______________________ nombre de clients dans la bdd _____________________*/
		System.out.println("Nombre de clients dans la bdd : ");
		
		Long nombreClientsBdd = clientRepository.count();
		
		System.out.println("\t > clients = " + nombreClientsBdd);
		
		
		/*____________________________ modif d'un client ___________________________*/
		/**
		 * 		> JpaRepository ne définit pas de méthode pour la mise à jour
		 * 
		 * 		> pour la mise à jour, on va utiliser 2 méthodes :
		 * 			
		 * 			-> getOne(ID id) : permet de récupérer une réf vers l'entité (proxy)
		 * 							sans faire de requete vers la bdd
		 * 
		 * 					-> sur cette réf, on peut définir ce qu'on veut
		 * 			
		 * 			-> save() : fera juste une instruction UPDATE vers la bdd
		 */
		System.out.println("Modif d'un client dans la bdd : ");
		
		Client clientUp = clientRepository.getClientById(1);
		
		clientUp.setNom("Geoffrey Turgeon");
		clientUp.setPhoto("Andre_Fernandes.png");
		
		clientUp.setMotDePasse(encoder.encode(clientUp.getMotDePasse()));
		clientRepository.save(clientUp);
		
		
		
		/*______________________ récup des users via le nom ______________________*/
		System.out.println("Liste des clients by name (méthode de requête)");
		
		List<Client> listeClientsByName = clientRepository.getClientByNom("Geoffrey Turgeon");
		
		for (Client u : listeClientsByName) {
			System.out.println("\t > " + u.getIdentifiant() + " : " + u.getNom());
		}System.out.println();
		
		
		/*_________________________ affichage du statut d'un client ________________________*/
		System.out.println("Liste des Clients by statut (méthode de requête)");
		
		List<Client> listeClientsByStatut = clientRepository.getClientByStatut(true);
		
		for (Client u : listeClientsByStatut) {
			System.out.println("\t > " + u.getIdentifiant() + " : " + u.getNom() + ", statut = " + u.isStatut());
		}System.out.println();
		
		
		/*_________________________ suppression d'un client ________________________*/
		/**
		 * 		> pour la suppression, on peut utiliser 2 méthodes :
		 * 			
		 * 			-> deleteById
		 * 			
		 * 			-> delete 
		 */
		
		//suppression de l'entité par son id
//		clientRepository.deleteById(1);
		
		//suppression de l'entité
//		clientRepository.delete(userUp);
		
		
	
		/*========================================================================*/
		/*=========== Tests sur les Méthode de ProprietaireRepository ============*/
		/*========================================================================*/
		// définir les adressePersonne pour proprietaires à ajouter
		AdressePersonne adresseP2 = new AdressePersonne("rue_P2", "codePostal_P2", "ville_P2");
		AdressePersonne adresseP3 = new AdressePersonne("rue_P3", "codePostal_P3", "ville_P3");
		adressePRepository.save(adresseP2);
		adressePRepository.save(adresseP3);
		
		// définir les proprietaires à ajouter  ## Pb avec l'adresse (Fetch) donc on test à null ##
		Proprietaire proprietaire = new Proprietaire("Thomas Bonneau", "TBonneau@gmail.com", "123456", true, "Thomas_Bonneau.png", null, null, "0600220022", "0700220022", null, null, null);
		Proprietaire proprietaire1 = new Proprietaire("nom1", "MAcalet@gmail.com", "123456", true, "Mathieu_Acalet.png", null, null, "0600220022", "0700220022", null, null, null);
		
		// Encodage
		proprietaire.setMotDePasse(encoder.encode(proprietaire.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles3 = new HashSet<>();
		Role propRole = roleRepository.findByName(ERole.ROLE_PROP)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles3.add(propRole);
		proprietaire.setRoles(roles3);
		proprietaireRepository.save(proprietaire);
		
		// Encodage
		proprietaire1.setMotDePasse(encoder.encode(proprietaire1.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles4 = new HashSet<>();
		Role propRole1 = roleRepository.findByName(ERole.ROLE_PROP)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles4.add(propRole1);
		proprietaire1.setRoles(roles4);		
		proprietaireRepository.save(proprietaire1);
				
		/*____________________________ liste des proprietaires ___________________________*/
		List<Proprietaire> listeProprietaires = proprietaireRepository.findAll();
			
		System.out.println("Liste des proprietaires dans la bdd : ");
		for (Proprietaire p : listeProprietaires) {
			System.out.println("\t > " + p.getIdentifiant() + " : " + p.getNom());
		}
		
				
		/*____________________________ modif d'un proprietaire ____________*/
		Proprietaire p1 = proprietaireRepository.getProprietaireById(3);
		System.out.println("MODIF PROPRIETAIRE :\n\t > " + p1.getIdentifiant() + " : " + p1.getNom() + ", [Adresse] : " + p1.getAdresseP());
		
		p1.setNom("Mathieu Acalet");
		System.out.println("\t > " + p1.getIdentifiant() + " : " + p1.getNom() + ", [Adresse] : " + p1.getAdresseP());
		// Encodage
		p1.setMotDePasse(encoder.encode(p1.getMotDePasse()));
		proprietaireRepository.save(p1);
		
		
		/*____________________________ méthodes non crud sur proprietaire ____________*/
		List<Proprietaire> liste_p = proprietaireRepository.getProprietaireByNom("nom");
		for (Proprietaire p : liste_p) {
			System.out.println("GET BY NOM\n\t > " + p.getIdentifiant() + " : " + p.getNom() + ", [Adresse] : " + p.getAdresseP());
		}
		
		liste_p = proprietaireRepository.getProprietaireByStatut(true);
		for (Proprietaire p : liste_p) {
			System.out.println("GET BY STATUT\n\t > " + p.getIdentifiant() + " : " + p.getNom() + ", [Adresse] : " + p.getAdresseP() + ", Statut : " + p.isStatut());
		}
		
				
		/*____________________________ suppression d'un agent ____________*/
		//suppression de l'entité par son id
//		proprietaireRepository.deleteById(2);
				
		//suppression de l'entité
//		proprietaireRepository.delete(p1);
		
		
		
		/*========================================================================*/
		/*============== Tests sur les Méthode de AgentRepository ================*/
		/*========================================================================*/
		// définir les adressePersonne pour agents à ajouter
		AdressePersonne adresseP4 = new AdressePersonne("rue_P4", "codePostal_P4", "ville_P4");
		AdressePersonne adresseP5 = new AdressePersonne("rue_P5", "codePostal_P5", "ville_P5");
		adressePRepository.save(adresseP4);
		adressePRepository.save(adresseP5);
		
		// définir les agents à ajouter   ## Pb avec l'adresse (Fetch) donc on test à null ##
		Agent agent = new Agent("Laurène Lacordaire", "LLacordaire@gmail.com", "123456", true, "Laurène_Lacordaire.png", null, null, null);
		Agent agent1 = new Agent("nom", "ODodier@gmail.com", "123456", true, "Orianne_Dodier.png", null, null, null);
				
		// Encodage
		agent.setMotDePasse(encoder.encode(agent.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles1 = new HashSet<>();
		Role agentRole = roleRepository.findByName(ERole.ROLE_AGENT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles1.add(agentRole);
		agent.setRoles(roles1);
		agentRepository.save(agent);
		
		// Encodage
		agent1.setMotDePasse(encoder.encode(agent1.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles2 = new HashSet<>();
		Role agentRole1 = roleRepository.findByName(ERole.ROLE_AGENT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles2.add(agentRole1);
		agent1.setRoles(roles2);
		agentRepository.save(agent1);
				
		/*____________________________ liste des agents ___________________________*/
		List<Agent> listeAgents = agentRepository.findAll();
			
		System.out.println("Liste des agents dans la bdd : ");
		for (Agent a : listeAgents) {
			System.out.println("\t > " + a.getIdentifiant() + " : " + a.getNom());
		}
		
				
		/*____________________________ modif d'un agent ____________*/
		Agent ag = agentRepository.getAgentById(5);
		System.out.println("MODIF AGENT :\n\t > " + ag.getIdentifiant() + " : " + ag.getNom() + ", " + ag.getAdresseP());
		
		ag.setNom("Orianne Dodier");
		System.out.println("\t > " + ag.getIdentifiant() + " : " + ag.getNom() + ", " + ag.getAdresseP());
		// Encodage
		ag.setMotDePasse(encoder.encode(ag.getMotDePasse()));
		agentRepository.save(ag);
		
		
		/*____________________________ méthodes non crud sur agent ____________*/
		List<Agent> liste_ag = agentRepository.getAgentByNom("nomAgent");
		for (Agent a : liste_ag) {
			System.out.println("GET BY NOM\n\t > " + a.getIdentifiant() + " : " + a.getNom() + ", " + a.getAdresseP());
		}
		
		liste_ag = agentRepository.getAgentByStatut(true);
		for (Agent a : liste_ag) {
			System.out.println("GET BY STATUT\n\t > " + a.getIdentifiant() + " : " + a.getNom() + ", " + a.getAdresseP() + ", " + a.isStatut());
		}
		
				
		/*____________________________ suppression d'un agent ____________*/
		//suppression de l'entité par son id
//		agentRepository.deleteById(4);
				
		//suppression de l'entité
//		agentRepository.delete(ag);
		
		
		
		/*========================================================================*/
		/*========== Tests sur les Méthode de AdministrateurRepository ===========*/
		/*========================================================================*/
		// définir les adressePersonne pour aministrateurs à ajouter
		AdressePersonne adresseP6 = new AdressePersonne("rue_P6", "codePostal_P6", "ville_P6");
		AdressePersonne adresseP7 = new AdressePersonne("rue_P7", "codePostal_P7", "ville_P7");
		adressePRepository.save(adresseP6);
		adressePRepository.save(adresseP7);
		
		// définir les aministrateurs à ajouter   ## Pb avec l'adresse (Fetch) donc on test à null ##
		Administrateur administrateur = new Administrateur("Mathieu Acalet", "MAcalet@gmail.com", "123456", true, null);
		Administrateur administrateur1 = new Administrateur("nomAdmin", "NMazzelier@gmail.com", "123456", true, null);
				
		// Encodage
		administrateur.setMotDePasse(encoder.encode(administrateur.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles5 = new HashSet<>();
		Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles5.add(adminRole);
		administrateur.setRoles(roles5);
		administrateurRepository.save(administrateur);
		
		// Encodage
		administrateur1.setMotDePasse(encoder.encode(administrateur1.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles6 = new HashSet<>();
		Role adminRole1 = roleRepository.findByName(ERole.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles6.add(adminRole1);
		administrateur1.setRoles(roles6);
		administrateurRepository.save(administrateur1);
				
		/*____________________________ liste des aministrateurs ___________________________*/
		List<Administrateur> listeAdministrateurs = administrateurRepository.findAll();
			
		System.out.println("Liste des administrateurs dans la bdd : ");
		for (Administrateur a : listeAdministrateurs) {
			System.out.println("\t > " + a.getIdentifiant() + " : " + a.getNom());
		}
		
				
		/*____________________________ modif d'un aministrateur ____________*/
		Administrateur admin = administrateurRepository.getAdministrateurById(7);
		System.out.println("MODIF ADMINISTRATEUR :\n\t > " + admin.getIdentifiant() + " : " + admin.getNom() + ", " + admin.getAdresseP());
		
		admin.setNom("Nicolas Mazzelier");
		System.out.println("\t > " + admin.getIdentifiant() + " : " + admin.getNom() + ", " + admin.getAdresseP());
		// Encodage
		admin.setMotDePasse(encoder.encode(admin.getMotDePasse()));
		administrateurRepository.save(admin);
		
		
		/*____________________________ méthodes non crud sur aministrateur ____________*/
		List<Administrateur> liste_admin = administrateurRepository.getAdministrateurByNom("nomAdmin");
		for (Administrateur a : liste_admin) {
			System.out.println("GET BY NOM\n\t > " + a.getIdentifiant() + " : " + a.getNom() + ", " + a.getAdresseP());
		}
		
		liste_admin = administrateurRepository.getAdministrateurByStatut(true);
		for (Administrateur a : liste_admin) {
			System.out.println("GET BY STATUT\n\t > " + a.getIdentifiant() + " : " + a.getNom() + ", " + a.getAdresseP() + ", " + a.isStatut());
		}
		
				
		/*____________________________ suppression d'un aministrateur ____________*/
		//suppression de l'entité par son id
//		administrateurRepository.deleteById(6);
				
		//suppression de l'entité
//		administrateurRepository.delete(admin);
		
		
		
		/*========================================================================*/
		/*========== Tests sur les Méthode de PersonneRepository ===========*/
		/*========================================================================*/
		// définir les adressePersonne pour personnes à ajouter
		AdressePersonne adresseP8 = new AdressePersonne("rue_P8", "codePostal_P8", "ville_P8");
		AdressePersonne adresseP9 = new AdressePersonne("rue_P9", "codePostal_P9", "ville_P9");
		adressePRepository.save(adresseP8);
		adressePRepository.save(adresseP9);
		
		// définir les personnes à ajouter   ## Pb avec l'adresse (Fetch) donc on test à null ##
		Personne personne = new Personne("nomPersonne", "email", "motDePasse", true, null);
		Personne personne1 = new Personne("nomPersonne1", "email1", "motDePasse1", true, null);
				
		personneRepository.save(personne);
		personneRepository.save(personne1);
				
		/*____________________________ liste des personnes ___________________________*/
		List<Personne> listePersonnes = personneRepository.findAll();
			
		System.out.println("Liste des personnes dans la bdd : ");
		for (Personne p : listePersonnes) {
			System.out.println("\t > " + p.getIdentifiant() + " : " + p.getNom());
		}
		
				
		/*____________________________ modif d'un personne ____________*/
		Personne person = personneRepository.getPersonneById(9);
		System.out.println("MODIF PERSONNE :\n\t > " + person.getIdentifiant() + " : " + person.getNom() + ", " + person.getAdresseP());
		
		person.setNom("nomPersonne_modifié");
		System.out.println("\t > " + person.getIdentifiant() + " : " + person.getNom() + ", " + person.getAdresseP());
		personneRepository.save(person);
		
		
		/*____________________________ méthodes non crud sur personne ____________*/
		List<Personne> liste_personne = personneRepository.getPersonneByNom("nomPersonne");
		for (Personne p : liste_personne) {
			System.out.println("GET BY NOM\n\t > " + p.getIdentifiant() + " : " + p.getNom() + ", " + p.getAdresseP());
		}
		
		liste_personne = personneRepository.getPersonneByStatut(true);
		for (Personne p : liste_personne) {
			System.out.println("GET BY STATUT\n\t > " + p.getIdentifiant() + " : " + p.getNom() + ", " + p.getAdresseP() + ", " + p.isStatut());
		}
		
				
		/*____________________________ suppression d'un aministrateur ____________*/
		//suppression de l'entité par son id
		personneRepository.deleteById(8);
				
		//suppression de l'entité
		personneRepository.delete(person);
		
		
		
		/*========================================================================*/
		/*========== Tests sur les Méthode de LocataireRepository ===========*/
		/*========================================================================*/
		// définir les adressePersonne pour locataires à ajouter
		AdressePersonne adresseP10 = new AdressePersonne("rue_P10", "codePostal_P10", "ville_P10");
		AdressePersonne adresseP11 = new AdressePersonne("rue_P11", "codePostal_P11", "ville_P11");
		adressePRepository.save(adresseP10);
		adressePRepository.save(adresseP11);
		
		// définir les locataires à ajouter   ## Pb avec l'adresse (Fetch) donc on test à null ##
		Locataire locataire = new Locataire("Zaccharie Camilleri", "ZCamilleri@gmail.com", "123", true, null, null);
		Locataire locataire1 = new Locataire("nomLocataire1", "CResten@gmail.com", "123", true, null, null);
		
		// Encodage
		locataire.setMotDePasse(encoder.encode(locataire.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles7 = new HashSet<>();
		Role locRole = roleRepository.findByName(ERole.ROLE_LOC)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles7.add(locRole);
		locataire.setRoles(roles7);
		locataireRepository.save(locataire);
		
		// Encodage
		locataire1.setMotDePasse(encoder.encode(locataire1.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles8 = new HashSet<>();
		Role locRole1 = roleRepository.findByName(ERole.ROLE_LOC)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles8.add(locRole1);
		locataire1.setRoles(roles8);
		locataireRepository.save(locataire1);
				
		/*____________________________ liste des locataires ___________________________*/
		List<Locataire> listeLocataires = locataireRepository.findAll();
			
		System.out.println("Liste des locataires dans la bdd : ");
		for (Locataire l : listeLocataires) {
			System.out.println("\t > " + l.getIdentifiant() + " : " + l.getNom());
		}
		
				
		/*____________________________ modif d'un locataire ____________*/
		Locataire locatair = locataireRepository.getLocataireById(11);
		System.out.println("MODIF LOCATAIRE :\n\t > " + locatair.getIdentifiant() + " : " + locatair.getNom() + ", " + locatair.getAdresseP());
		
		locatair.setNom("Camille Resten");
		System.out.println("\t > " + locatair.getIdentifiant() + " : " + locatair.getNom() + ", " + locatair.getAdresseP());
		// Encodage
		locatair.setMotDePasse(encoder.encode(locatair.getMotDePasse()));
		locataireRepository.save(locatair);
		
		
		/*____________________________ méthodes non crud sur locataire ____________*/
		List<Locataire> liste_locataire = locataireRepository.getLocataireByNom("nomLocataire");
		for (Locataire l : liste_locataire) {
			System.out.println("GET BY NOM\n\t > " + l.getIdentifiant() + " : " + l.getNom() + ", " + l.getAdresseP());
		}
		
		liste_locataire = locataireRepository.getLocataireByStatut(true);
		for (Locataire l : liste_locataire) {
			System.out.println("GET BY STATUT\n\t > " + l.getIdentifiant() + " : " + l.getNom() + ", " + l.getAdresseP() + ", " + l.isStatut());
		}
		
				
		/*____________________________ suppression d'un locataire ____________*/
		//suppression de l'entité par son id
		locataireRepository.deleteById(10);
				
		//suppression de l'entité
		locataireRepository.delete(locatair);
		
		
		
		/*========================================================================*/
		/*========== Tests sur les Méthode de BienRepository ===========*/
		/*========================================================================*/
		// définir les adressePersonne pour locataires à ajouter
		AdresseBien adresseP12 = new AdresseBien("rue_P12", "codePostal_P12", "ville_P12");
		AdresseBien adresseP13 = new AdresseBien("rue_P13", "codePostal_P13", "ville_P13");
		adresseBRepository.save(adresseP12);
		adresseBRepository.save(adresseP13);
		
		// définir les biens à ajouter   ## Pb avec l'adresse (Fetch) donc on test à null ##
		Bien bien = new Bien(true, "offre2", 25000.00, "standard", null, "dateSoumission", "dateDisposition", null, null);
		Bien bien1 = new Bien(true, "offre3", 40000.00, "standard", null, "dateSoumission", "dateDisposition", null, null);
				
		bienRepository.save(bien);
		bienRepository.save(bien1);
				
		/*____________________________ liste des biens ___________________________*/
		List<Bien> listeBiens = bienRepository.findAll();
			
		System.out.println("Liste des biens dans la bdd : ");
		for (Bien b : listeBiens) {
			System.out.println("\t > " + b.getId_bien() + " : Offre :" + b.getOffre() + ", " + b.getPrix() + "€ , [Adresse] : " + b.getAdresseBien() + " | Disponibilité (statut) : " + b.isStatut());
		}
		
				
		/*____________________________ modif d'un bien ____________*/
		Bien bienn = bienRepository.getBienById(4);
		System.out.println("MODIF BIEN :\n\t > " + bienn.getId_bien() + " : tOffre :" + bienn.getOffre() + ", " + bienn.getPrix() + "€ , [Adresse] : " + bienn.getAdresseBien() + " | Disponibilité (statut) : " + bienn.isStatut());
		
		bienn.setPrix(37000.00);
		System.out.println("\t > " + bienn.getId_bien() + " : Offre :" + bienn.getOffre() + ", " + bienn.getPrix() + "€ , [Adresse] : " + bienn.getAdresseBien() + " | Disponibilité (statut) : " + bienn.isStatut());
		bienRepository.save(bienn);
		
		
		/*____________________________ méthodes non crud sur bien ____________*/
		List<Bien> liste_bien = bienRepository.getBienByDateDisposition("dateDisposition");
		for (Bien b : liste_bien) {
			System.out.println("GET BY DateDisposition :\n\t > " + b.getId_bien() + " : Offre :" + b.getOffre() + ", " + b.getPrix() + "€ , [Adresse] : " + b.getAdresseBien() + " | Disponibilité (statut) : " + b.isStatut());
		}
		
		liste_bien = bienRepository.getBienByDateSoumission("dateSoumission");
		for (Bien b : liste_bien) {
			System.out.println("GET BY DateSoumission :\n\t > " + b.getId_bien() + " : Offre :" + b.getOffre() + ", " + b.getPrix() + "€ , [Adresse] : " + b.getAdresseBien() + " | Disponibilité (statut) : " + b.isStatut());
		}
		
		liste_bien = bienRepository.getBienByOffre("offre2");
		for (Bien b : liste_bien) {
			System.out.println("GET BY Offre :\n\t > " + b.getId_bien() + " : Offre :" + b.getOffre() + ", " + b.getPrix() + "€ , [Adresse] : " + b.getAdresseBien() + " | Disponibilité (statut) : " + b.isStatut());
		}
		
		liste_bien = bienRepository.getBienByStandard("standard");
		for (Bien b : liste_bien) {
			System.out.println("GET BY Standard :\n\t > " + b.getId_bien() + " : Offre :" + b.getOffre() + ", " + b.getPrix() + "€ , [Adresse] : " + b.getAdresseBien() + " | Disponibilité (statut) : " + b.isStatut());
		}
		
		liste_bien = bienRepository.getBienByStatut(true);
		for (Bien b : liste_bien) {
			System.out.println("GET BY Statut :\n\t > " + b.getId_bien() + " : Offre :" + b.getOffre() + ", " + b.getPrix() + "€ , [Adresse] : " + b.getAdresseBien() + " | Disponibilité (statut) : " + b.isStatut());
		}
		
				
		/*____________________________ suppression d'un bien ____________*/
		//suppression de l'entité par son id
//		bienRepository.deleteById(3);
				
		//suppression de l'entité
//		bienRepository.delete(bienn);
		
		
		
		/*========================================================================*/
		/*=========== Tests sur les Méthode de ContratRepository ============*/
		/*========================================================================*/
		//définir les params
		bien = new Bien(true, "offre", 50000.00, "standard", null, "dateSoumission", "dateDisposition", null, null);
		agent = new Agent("nom", "email", "motDePasse", true, null);
		proprietaire = new Proprietaire("nom", "email", "motDePasse", true, null, null, "tel_prive", "tel_travail");
		Client client = new Client("nom", "email", "motDePasse", true, "Andre_Fernandes.png", null, null, null);
		
		// définir les contrats à ajouter  ## Pb avec l'adresse (Fetch) donc on test à null ##
		Contrat contrat = new Contrat("date", null, null, null, null);
		
		contratRepository.save(contrat);
				
		/*____________________________ liste des contrats ___________________________*/
		List<Contrat> listeContrats = contratRepository.findAll();
			
		System.out.println("Liste des contrats dans la bdd : ");
		for (Contrat c : listeContrats) {
			System.out.println("\t > " + c.getIdContrat() + " : " + c.getDate() );
		}
		
				
		/*____________________________ modif d'un contrat ____________*/
		Contrat c1 = contratRepository.getContratById(1);
//		System.out.println("MODIF CONTRAT :\n\t > " + c1.getIdContrat() + " :\t[bien] : " + c1.getBien() + " [agent] : " + c1.getAgent() + " [proprio] : " + c1.getProprietaire() + " [client] : " + c1.getClient());
		System.out.println("\t > " + c1.getIdContrat() + " : " + c1.getDate() );
		
		c1.setDate("dateModifiée");
//		System.out.println("\t > " + c1.getIdContrat() + " :\t[bien] : " + c1.getBien() + " [agent] : " + c1.getAgent() + " [proprio] : " + c1.getProprietaire() + " [client] : " + c1.getClient());
		System.out.println("\t > " + c1.getIdContrat() + " : " + c1.getDate() );
		contratRepository.save(c1);
		
		
		/*____________________________ méthodes non crud sur contrat ____________*/
		
		
		
				
		/*____________________________ suppression d'un contrat ____________*/
		//suppression de l'entité par son id
//		contratRepository.deleteById(2);
				
		//suppression de l'entité
//		contratRepository.delete(p1);
		

	}//end method run 


}//end class
