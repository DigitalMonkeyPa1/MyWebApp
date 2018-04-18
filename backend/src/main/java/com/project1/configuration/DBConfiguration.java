package com.project1.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.project1.models.Authorities;
import com.project1.models.BillingAddress;
import com.project1.models.Cart;
import com.project1.models.Category;
import com.project1.models.Customer;
import com.project1.models.Product;
import com.project1.models.ShippingAddress;
import com.project1.models.User;

@Configuration
@EnableTransactionManagement
public class DBConfiguration
{
	public DBConfiguration()
	{
		System.out.println("Creating DBConfiguration");
	}
	
	//OptionalValidatorFactoryBean ovfb;
	
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		System.out.println("Creating DataSource");
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/_h2_db/project1/project1_db");//("jdbc:h2:tcp://localhost/~/_h2_db/project2");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("sa");
	    return dataSource;
	}
	/*
	 * <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBuilder">
	 * <property name="dataSource" ref="dataSource">
	 */
	@Bean //SessionFactory - factory of session objects
	public SessionFactory sessionFactory()
	{
		System.out.println("Creating SessionFactory");
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		//An array of Class objects of all the entities
		//Map all entities to relational table
		Class classes[]=new Class[]{Product.class, Category.class, Customer.class, User.class, Authorities.class, BillingAddress.class, ShippingAddress.class, Cart.class};
		//localsesionfactorybuilder -> sessionfactory -> map all entities with relation table
	    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	
	@Bean
	public HibernateTransactionManager hibTransManagement()
	{
		System.out.println("Creating HibernateTransactionManager");
		return new HibernateTransactionManager(sessionFactory());
	}
	
}
