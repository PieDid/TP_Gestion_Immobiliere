package com.intiformation.gestionimmo.lanceur;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

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

import com.intiformation.gestionimmo.domain.*;
import com.intiformation.gestionimmo.repository.*;


@SpringBootApplication
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class, 
								   DataSourceTransactionManagerAutoConfiguration.class, 
								   HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.intiformation.gestionimmo"})
//@ComponentScan({"com.intiformation.gestionimmo"})
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//@EntityScan(basePackages = {"com.intiformation.gestionimmo.entity"}) 
@EnableJpaRepositories("com.intiformation.gestionimmo.repository")
//////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Application implements CommandLineRunner{

	@Autowired
	private Environment appEnvironment; // pour pointer le fichier application.properties
	
	//déclaration + injection de couche DAO
	@Autowired
	private ClientRepository clientRepository;
	
	/**
	 * Methode main : lance l'application
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext conteneurIoCSpring = SpringApplication.run(Application.class, args);
		System.out.println("... Lancement de l'application ...");
	}
	
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
		/*============== Méthode de bases de la DAO (UserRepository) =============*/
		/*========================================================================*/
		/*____________________________ ajout d'une adressePersonne & adresseBien ___________________________*/
		// définir l'adressePersonne à ajouter
		AdressePersonne adresseP = new AdressePersonne("rue_P", "codePostal_P", "ville_P");
		
		// définir l'adresseBien à ajouter
		AdresseBien adresseB = new AdresseBien("rue_B", "codePostal_B", "ville_B");
		
		
		
		/*____________________________ ajout d'une visite ___________________________*/
		// définir la visite à ajouter
//		Visite visite1 = new Visite("rue_P", "codePostal_P", "ville_P");
		
		
		
		/*____________________________ ajout d'un Client ___________________________*/
		// définir le Client à ajouter
		Client client1 = new Client("nom", "email", "motDePasse", true, adresseP, null, null);

		
		//ajout du client via la méthode save()
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
		
		clientRepository.save(clientUp);
		
		
		/*_________________________ suppression d'un client ________________________*/
		/**
		 * 		> pour la suppression, on peut utiliser 2 méthodes :
		 * 			
		 * 			-> deleteById
		 * 			
		 * 			-> delete 
		 */
		
		//suppression de l'entité par son id
//		userRepository.deleteById(1);
		
		//suppression de l'entité
//		userRepository.delete(userUp);
		
		
		
		/*========================================================================*/
		/*============ Méthode de requêtes de la DAO (UserRepository) ============*/
		/*========================================================================*/
		/*______________________ récup des users via le nom ______________________*/
		System.out.println("Liste des Users by name (méthode de requête)");
		
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
		clientRepository.deleteById(1);
		
		//suppression de l'entité
//		userRepository.delete(userUp);
		
		
		/*__________________ récup des clients via le nom et id ____________________*/
//		System.out.println("Liste des Clients by nom et id (méthode de requête)");
//		
//		for (Client u : clientRepository.findByNomAndIdentifiant("Slainie Bélair", 2)) {
//			System.out.println("\t > " + u.getIdentifiant() + " : " + u.getNom());
//		}System.out.println();

		
		/*__________________ récup des users via le nom ou id ____________________*/
//		System.out.println("Liste des Users by name ou id (méthode de requête)");
//		
//		for (User u : userRepository.findByNameOrId("Slainie Bélair", 1)) {
//			System.out.println("\t > " + u.getId() + " : " + u.getName());
//		}
//		for (User u : userRepository.findByNameOrId("blabla", 2)) {
//			System.out.println("\t > " + u.getId() + " : " + u.getName());
//		}
//		System.out.println();
		
		
		
		/*========================================================================*/
		/*=========== Requêtes avec @Query de la DAO (UserRepository) ============*/
		/*========================================================================*/
		/*_______________________ récup d'un user via l' id ______________________*/
//		System.out.println("Get user by id (requête @Query)");
//		
//		User u = userRepository.searchUserById(2);
//		System.out.println("\t > " + u.getId() + " : " + u.getName());
		
		
		/*_______________________ récup d'un user via l' id ______________________*/
//		System.out.println("Get user by name (requête @Query)");
//		
//		u = userRepository.rechercherUserByNom("Slainie Bélair");
//		System.out.println("\t > " + u.getId() + " : " + u.getName());
		
		
		
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * creation du bean de la dataSource
	 * @return la datasource de type javax.sql.DataSource
	 * @return
	 */
	@Bean(name="dataSourceBean")
	public DataSource getDataSource() {
		
		// utilisation de l'implémentation de la DS de Spring DriverManagerDataSource
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// config de la datasource avec les props de application.properties
		dataSource.setDriverClassName(appEnvironment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(appEnvironment.getProperty("spring.datasource.url"));
		dataSource.setUsername(appEnvironment.getProperty("spring.datasource.username"));
		dataSource.setPassword(appEnvironment.getProperty("spring.datasource.password"));
		
		System.out.println("## bean de la datasource : " + dataSource);
		
		// renvoi de la datasource
		return dataSource;
		
	} // end getDataSource()
	
	/**
	 * création du bean de la sessionFactory. <br/>
	 * Injection du bean de la datasource dans la sessionFactory
	 * @param pDataSource : la dataSource à injecter
	 * @return : une sessionFactory d'hibernate org.hibernate.SessionFactory
	 * @throws IOException 
	 */
	@Autowired // injection du bean de la dataSource dans le param pDataSource
	@Bean(name="entityManagerFactory")
	public SessionFactory getSessionFactory(DataSource pDataSource) throws IOException {
		
		// 1. definition des propriétés d'hibernate de la sessionFactory
		//-> récup des propriétés du fichier application.properties
		Properties properties = new Properties();
		//properties.put(<prop natives d'hibernate>,<valeurs définies dans application.properties>) 		
		properties.put("hibernate.dialect", appEnvironment.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", appEnvironment.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.hbm2ddl.auto", appEnvironment.getProperty("spring.jpa.hibernate.ddl-auto"));
		
		// 2. définition de la sessionFactory : utilisation de l'implémentation de Spring 'LocalSessionFactoryBean'
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		
		// 3. config de la session factory
		
		// 3.1. packages contenant les classes entités
		sessionFactoryBean.setPackagesToScan(new String[] {"com.intiformation.gestionimmo.domain"});
		
		// 3.2. injection de la datasource
		sessionFactoryBean.setDataSource(pDataSource);
		
		// 3.3. définition des propriétés hibernate
		sessionFactoryBean.setHibernateProperties(properties);
		
		// 3.4. validation de la config globale du bean de la sessionFactory
		sessionFactoryBean.afterPropertiesSet();
		
		// 3.5. récup de l'objet de la sessionFactory
		SessionFactory sessionFactory = sessionFactoryBean.getObject();
		
		System.out.println("## ------> session Factory : " + sessionFactory);
		
		return sessionFactory;
		
	} // end getSessionFactory()
	
	/**
	 * création du bean du gestionnaire des transactions. <br/>
	 * injection du bean de la session Factory
	 * @return
	 */
	@Autowired // pour injecter le bean de la sessionFactory dans le paramètre pSessionFactory
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory pSessionFactory) {
		
		// création du bean du tx manager
		HibernateTransactionManager txManager = new HibernateTransactionManager(pSessionFactory);
		
		System.out.println("## ------> tx manager : " +txManager);
		
		// renvoi du tx manager
		return txManager;
		
	} // end getTransactionManager()

}
