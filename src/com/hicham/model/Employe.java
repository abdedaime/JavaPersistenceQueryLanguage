package com.hicham.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employe")
public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Nom", length = 25)
	private String name;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "dt_fk")
	private Departement departement;

	@Temporal(TemporalType.DATE)
	@Column(name = "Date_embauche")
	private Date dateEmbauche;
	@Column(scale=2,name="salaire")
	private double sal;

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public Employe() {
		super();
	}

	public Employe(String name, Departement departement, Date dateEmbauche) {
		super();
		this.name = name;
		this.departement = departement;
		this.dateEmbauche = dateEmbauche;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
