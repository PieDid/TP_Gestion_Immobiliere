package com.intiformation.gestionimmo.lanceur;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.intiformation.gestionimmo.domain.Appartement;
import com.intiformation.gestionimmo.domain.Habitation;
import com.intiformation.gestionimmo.domain.Maison;
import com.intiformation.gestionimmo.domain.Studio;
import com.intiformation.gestionimmo.repository.AppartementRepository;
import com.intiformation.gestionimmo.repository.HabitationRepository;
import com.intiformation.gestionimmo.repository.MaisonRepository;
import com.intiformation.gestionimmo.repository.StudioRepository;


@SpringBootApplication
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class, 
								   DataSourceTransactionManagerAutoConfiguration.class, 
								   HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.intiformation.gestionimmo"})
@EnableJpaRepositories("com.intiformation.gestionimmo.repository")
public class AppAdresse implements CommandLineRunner {

	@Autowired
	private Environment appEnv;
	
	@Autowired
	private HabitationRepository hrep;
	
	@Autowired
	private StudioRepository srep;
	
	@Autowired
	private MaisonRepository mrep;
	
	@Autowired
	private AppartementRepository arep;
	
	
	public static void main(String[] args) {
		ApplicationContext conteneurIoCSpring = SpringApplication.run(AppAdresse.class, args);
		System.out.println("Habitation Starts.");		
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run.");
		
		
	// Ajout d'entrepot	
		
		Habitation hab1 = new Habitation(true, "offre1", 320000.00, "Disponible", null, "09/12/2019", "26/12/2019", 44000, null, null, 96);
		Habitation hab2 = new Habitation(true, "offre2", 250000.00, "Disponible", null, "30/12/2019", "01/10/2020", 65000, null, null, 45);
		Habitation hab3 = new Habitation(true, "offre3", 320000.00, "Disponible", null, "09/12/2019", "26/12/2019", 44000, null, null, 96);
		
		Appartement app1 = new Appartement(true, "offre1", 45000.00, "Disponible", null, "09/12/2019", "26/12/2019", 30000, null, null, 96);
		Appartement app2 = new Appartement(true, "offre2", 15900.00, "Disponible", null, "09/12/2019", "26/12/2019", 90000, null, null, 25);
		Appartement app3 = new Appartement(true, "offre3", 45000.00, "Disponible", null, "09/12/2019", "26/12/2019", 30000, null, null, 96);
		
		Maison mai1 = new Maison(true, "offre4", 999999.00, "Disponible", null, "09/12/2019", "26/12/2019", 99999, null, null, 251);
		Maison mai2 = new Maison(true, "offre3", 111111.00, "Disponible", null, "09/12/2019", "26/12/2019", 50000, null, null, 151);
		Maison mai3 = new Maison(true, "offre4", 999999.00, "Disponible", null, "09/12/2019", "26/12/2019", 99999, null, null, 251);
		
		Studio stu1 = new Studio(true, "offre1", 15000.00, "Disponible", null, "09/12/2019", "26/12/2019", 24000, null, null, 12);
		Studio stu2 = new Studio(true, "offre1", 15000.00, "Disponible", null, "30/12/2019", "26/12/2019", 24000, null, null, 12);
		Studio stu3 = new Studio(true, "offre1", 15000.00, "Disponible", null, "09/12/2019", "26/12/2019", 24000, null, null, 12);

		hrep.save(hab1);
		hrep.save(hab2);
		hrep.save(hab3);
		
		arep.save(app1);
		arep.save(app2);
		arep.save(app3);
		
		mrep.save(mai1);
		mrep.save(mai2);
		mrep.save(mai3);
		
		srep.save(stu1);
		srep.save(stu2);
		srep.save(stu3);
		
		
	// Liste des habitations
		
		List<Habitation> listH = hrep.findAll();
	
		System.out.println("Liste des habitations : ");
		for (Habitation a : listH) {
		System.out.println("\t > Id " + a.getId_bien() + " ; Prix : "  + a.getPrix() + " ; Superficie : " + a.getSuperficie());
	
		}
		
		List<Appartement> listA = arep.findAll();
		
		System.out.println("Liste des appartements : ");
		for (Appartement a : listA) {
		System.out.println("\t > Id " + a.getId_bien() + " ; Prix : "  + a.getPrix() + " ; Superficie : " + a.getSuperficie());
	
		}
		
		List<Maison> listM = mrep.findAll();
		
		System.out.println("Liste des maisons : ");
		for (Maison a : listM) {
		System.out.println("\t > Id " + a.getId_bien() + " ; Prix : "  + a.getPrix() + " ; Superficie : " + a.getSuperficie());
	
		}
		
		List<Studio> listS = srep.findAll();
		
		System.out.println("Liste des studio : ");
		for (Studio a : listS) {
		System.out.println("\t > Id " + a.getId_bien() + " ; Prix : "  + a.getPrix() + " ; Superficie : " + a.getSuperficie());
	
		}
		
		
		
	// Modification d'une habitation
		
		Habitation hUp = hrep.getHabitationById(1);
		hUp.setPrix(999999999);
		hrep.save(hUp); 
		
		Appartement aUp = arep.getAppartementById(4);
		aUp.setPrix(999999999);
		arep.save(aUp); 
		
		Maison mUp = mrep.getMaisonById(7);
		mUp.setPrix(999999999);
		mrep.save(mUp); 
		
		Studio sUp = srep.getStudioById(10);
		sUp.setPrix(999999999);
		srep.save(sUp); 
		
		

	// Get Habitation by Id
		
		System.out.println("Habitation 1 : ");
		
		Habitation h1 = null;
		
		Optional<Habitation> hOp = hrep.findById(1);
		
		if(hOp.isPresent()) {
			h1 = hOp.get();
			System.out.println("\t > Id " + h1.getId_bien() + " ; Prix : "  + h1.getPrix() + " ; Superficie : " + h1.getSuperficie());
			
		}

		
		System.out.println("Appartement 1 : ");
		
		Appartement a1 = null;
		
		Optional<Appartement> aOp = arep.findById(4);
		
		if(aOp.isPresent()) {
			a1 = aOp.get();
			System.out.println("\t > Id " + a1.getId_bien() + " ; Prix : "  + a1.getPrix() + " ; Superficie : " + a1.getSuperficie());
			
		}
		
		System.out.println("Maison 1 : ");
		
		Maison m1 = null;
		
		Optional<Maison> mOp = mrep.findById(7);
		
		if(mOp.isPresent()) {
			m1 = mOp.get();
			System.out.println("\t > Id " + m1.getId_bien() + " ; Prix : "  + m1.getPrix() + " ; Superficie : " + m1.getSuperficie());
			
		}
		
		System.out.println("Studio 10 : ");
		
		Studio s1 = null;
		
		Optional<Studio> sOp = srep.findById(10);
		
		if(sOp.isPresent()) {
			s1 = sOp.get();
			System.out.println("\t > Id " + s1.getId_bien() + " ; Prix : "  + s1.getPrix() + " ; Superficie : " + s1.getSuperficie());
			
		} 
		
	// Suppression
		
		//hrep.deleteById(3);


		
	// Get by Prixmax
		
		
		List<Habitation> listPrixH = hrep.getHabitationByPrixMax(400000);
		
		System.out.println("Liste des entrepots à moins de 400000 € : ");
		for (Habitation e : listPrixH) {
			System.out.println("\t > Id " + e.getId_bien() + " ; Prix : "  + e.getPrix() + " ; Superficie : " + e.getSuperficie());
			
		}
		
		List<Appartement> listPrixA = arep.getAppartementByPrixMax(400000);
		
		System.out.println("Liste des entrepots à moins de 400000 € : ");
		for (Appartement e : listPrixA) {
			System.out.println("\t > Id " + e.getId_bien() + " ; Prix : "  + e.getPrix() + " ; Superficie : " + e.getSuperficie());
			
		}
		
		List<Maison> listPrixM = mrep.getMaisonByPrixMax(400000);
		
		System.out.println("Liste des entrepots à moins de 400000 € : ");
		for (Maison e : listPrixM) {
			System.out.println("\t > Id " + e.getId_bien() + " ; Prix : "  + e.getPrix() + " ; Superficie : " + e.getSuperficie());
			
		}
		
		List<Studio> listPrixS = srep.getStudioByPrixMax(400000);
		
		System.out.println("Liste des entrepots à moins de 400000 € : ");
		for (Habitation e : listPrixS) {
			System.out.println("\t > Id " + e.getId_bien() + " ; Prix : "  + e.getPrix() + " ; Superficie : " + e.getSuperficie());
			
		}
		
		
	// Get by Superficie
		
		List<Habitation> listSuperH = hrep.getHabitationBySuperficie(50);
		
		System.out.println("Liste des habitations de plus de 50 m² : ");
		for (Habitation e : listSuperH) {
		System.out.println("\t > Id " + e.getId_bien() + " ; Prix : "  + e.getPrix() + " ; Superficie : " + e.getSuperficie());
			
		}
		
	// Get by Dispo
		
		
		List<Habitation> listDispoH = hrep.getHabitationByStandard("disponible");
		
		System.out.println("Liste des habitations disponible : ");
		for (Habitation e : listDispoH) {
		System.out.println("\t > Id " + e.getId_bien() + " ; Prix : "  + e.getPrix() + " ; Superficie : " + e.getSuperficie());
			
		}
		
		
		
		}//end main
		
		
		
	
	@Bean(name="dataSourceBean")
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(appEnv.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(appEnv.getProperty("spring.datasource.url"));
		dataSource.setUsername(appEnv.getProperty("spring.datasource.username"));
		dataSource.setPassword(appEnv.getProperty("spring.datasource.password"));
		
		System.out.println("## bean de la datasource : " + dataSource);
		
		return dataSource;
		
	}
	
	@Autowired 
	@Bean(name="entityManagerFactory")
	public SessionFactory getSessionFactory(DataSource pDataSource) throws IOException {
		

		Properties properties = new Properties();
		properties.put("hibernate.dialect", appEnv.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", appEnv.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.hbm2ddl.auto", appEnv.getProperty("spring.jpa.hibernate.ddl-auto"));
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

		sessionFactoryBean.setPackagesToScan(new String[] {"com.intiformation.gestionimmo.domain"});

		sessionFactoryBean.setDataSource(pDataSource);

		sessionFactoryBean.setHibernateProperties(properties);

		sessionFactoryBean.afterPropertiesSet();

		SessionFactory sessionFactory = sessionFactoryBean.getObject();
		
		System.out.println("## ------> session Factory : " + sessionFactory);
		
		return sessionFactory;
		
	} 
	
	@Autowired 
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory pSessionFactory) {

		HibernateTransactionManager txManager = new HibernateTransactionManager(pSessionFactory);
		
		System.out.println("## ------> tx manager : " +txManager);

		return txManager;
		
	}

}