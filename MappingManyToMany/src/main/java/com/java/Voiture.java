package com.java;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
@Table(name="voiture")
public class Voiture {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "marque",length=50)
    private String marque;
	 @ManyToMany(mappedBy="voiture",cascade=CascadeType.ALL)
	    private Set<Chauffeur> chaufList = new HashSet<Chauffeur>();
   
	 public Voiture(String marque, Set<Chauffeur> chaufList) {
		super();
		this.marque = marque;
		this.chaufList = chaufList;
	}
	
	@Override
	public String toString() {
		return "Voiture [Id=" + Id + ", marque=" + marque + ", chaufList=" + chaufList + "]";
	}
	public Voiture(String a) {
		 marque=a;
	 }
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public Set<Chauffeur> getChaufList() {
		return chaufList;
	}
	public void setChaufList(Set<Chauffeur> chaufList) {
		this.chaufList = chaufList;
	}
	
}
