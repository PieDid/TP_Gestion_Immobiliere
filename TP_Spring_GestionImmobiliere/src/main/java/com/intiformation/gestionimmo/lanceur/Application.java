package com.intiformation.gestionimmo.lanceur;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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


@SpringBootApplication
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class, 
								   DataSourceTransactionManagerAutoConfiguration.class, 
								   HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.intiformation.gestionimmo"})
public class Application {

	@Autowired
	private Environment appEnvironment; // pour pointer le fichier application.properties
	
	/**
	 * Methode main : lance l'application
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext conteneurIoCSpring = SpringApplication.run(Application.class, args);
		System.out.println("... Lancement de l'application ...");
	}
	
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
	@Bean(name="sessionFactoryBean")
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
	@Bean(name="transactionManagerBean")
	public HibernateTransactionManager getTransactionManager(SessionFactory pSessionFactory) {
		
		// création du bean du tx manager
		HibernateTransactionManager txManager = new HibernateTransactionManager(pSessionFactory);
		
		System.out.println("## ------> tx manager : " +txManager);
		
		// renvoi du tx manager
		return txManager;
		
	} // end getTransactionManager()

}
