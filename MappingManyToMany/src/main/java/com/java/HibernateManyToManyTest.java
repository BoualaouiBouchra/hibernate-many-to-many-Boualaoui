package com.java;

import java.util.*;
import javax.persistence.*;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateManyToManyTest {
	 public static void main(String arg[]) {
		 
		 
		 StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure().build();
		 SessionFactory sessionfactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
		 Session session= sessionfactory.openSession();
	
		 String[] marque = { "marque1", "marqu2" };
	        String[] ch = { "nom1 prenom1", "nom2 prenom2" };
	       
	        Set<Voiture> voitures = new HashSet<Voiture>();
	        Set< Chauffeur> Chauffeurs = new HashSet< Chauffeur>();
	        for (String mrq :marque) {
	        	voitures.add(new Voiture(mrq));
	        }

	        for (String chf :ch) {
	        	Chauffeurs.add(new Chauffeur(chf.split(" ")[0],chf.split(" ")[1]));
	        }
	        for ( Chauffeur chf  :Chauffeurs) {
	        	chf.setChaufList(voitures);
	        	session.persist(chf);
	        }

	        
	        
		      session.close();
	 }
	 }