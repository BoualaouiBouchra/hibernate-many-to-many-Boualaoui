package com.java;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name="chauffeur")
public class Chauffeur {
	@Override
	public String toString() {
		return "Chauffeur [Id=" + Id + ", nom=" + nom + ", prenom=" + prenom + ", chaufList=" + chaufList + "]";
	}
	public Chauffeur(String nom, String prenom, Set<Voiture> chaufList) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.chaufList = chaufList;
	}
	public Chauffeur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "nom",length=50)
    private String nom;
	@Column(name = "prenom",length=50)
    private String prenom;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Voiture> chaufList = new HashSet<Voiture>();
	 @JoinTable(
			
			            name = "chauffeur_voiture", 
			            joinColumns = { @JoinColumn(name = "id_C") }, 
			            inverseJoinColumns = {@JoinColumn(name = "id_V")})
	  
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Set<Voiture> getChaufList() {
		return chaufList;
	}
	public void setChaufList(Set<Voiture> chaufList) {
		this.chaufList = chaufList;
	}
	
}
