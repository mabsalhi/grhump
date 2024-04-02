/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soshs.ump.grh.jpa;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mabs
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdPerson", query = "SELECT p FROM Person p WHERE p.idPerson = :idPerson"),
    @NamedQuery(name = "Person.findByNom", query = "SELECT p FROM Person p WHERE p.nom = :nom"),
    @NamedQuery(name = "Person.findByPrenom", query = "SELECT p FROM Person p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Person.findByDateNaissance", query = "SELECT p FROM Person p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Person.findByCin", query = "SELECT p FROM Person p WHERE p.cin = :cin"),
    @NamedQuery(name = "Person.findByPpr", query = "SELECT p FROM Person p WHERE p.ppr = :ppr"),
    @NamedQuery(name = "Person.findByPosteBudgetaire", query = "SELECT p FROM Person p WHERE p.posteBudgetaire = :posteBudgetaire"),
    @NamedQuery(name = "Person.findByLieuNaissance", query = "SELECT p FROM Person p WHERE p.lieuNaissance = :lieuNaissance"),
    @NamedQuery(name = "Person.findBySex", query = "SELECT p FROM Person p WHERE p.sex = :sex"),
    @NamedQuery(name = "Person.findByNomAr", query = "SELECT p FROM Person p WHERE p.nomAr = :nomAr"),
    @NamedQuery(name = "Person.findByPrenomAr", query = "SELECT p FROM Person p WHERE p.prenomAr = :prenomAr"),
    @NamedQuery(name = "Person.findByLieuNaissanceAr", query = "SELECT p FROM Person p WHERE p.lieuNaissanceAr = :lieuNaissanceAr"),
    @NamedQuery(name = "Person.findByNationalite", query = "SELECT p FROM Person p WHERE p.nationalite = :nationalite")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_person")
    private Integer idPerson;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cin")
    private String cin;
    @Column(name = "ppr")
    private Long ppr;
    @Column(name = "poste_budgetaire")
    private Long posteBudgetaire;
    @Size(max = 50)
    @Column(name = "lieu_naissance")
    private String lieuNaissance;
    @Column(name = "sex")
    private Character sex;
    @Size(max = 100)
    @Column(name = "nom_ar")
    private String nomAr;
    @Size(max = 150)
    @Column(name = "prenom_ar")
    private String prenomAr;
    @Size(max = 150)
    @Column(name = "lieu_naissance_ar")
    private String lieuNaissanceAr;
    @Size(max = 50)
    @Column(name = "nationalite")
    private String nationalite;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Qualification> qualificationList;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Afectation> afectationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Contacts> contactsList;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Situation> situationList;

    public Person() {
    }

    public Person(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Person(Integer idPerson, String nom, String prenom, Date dateNaissance, String cin) {
        this.idPerson = idPerson;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Long getPpr() {
        return ppr;
    }

    public void setPpr(Long ppr) {
        this.ppr = ppr;
    }

    public Long getPosteBudgetaire() {
        return posteBudgetaire;
    }

    public void setPosteBudgetaire(Long posteBudgetaire) {
        this.posteBudgetaire = posteBudgetaire;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getNomAr() {
        return nomAr;
    }

    public void setNomAr(String nomAr) {
        this.nomAr = nomAr;
    }

    public String getPrenomAr() {
        return prenomAr;
    }

    public void setPrenomAr(String prenomAr) {
        this.prenomAr = prenomAr;
    }

    public String getLieuNaissanceAr() {
        return lieuNaissanceAr;
    }

    public void setLieuNaissanceAr(String lieuNaissanceAr) {
        this.lieuNaissanceAr = lieuNaissanceAr;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    @XmlTransient
    public List<Qualification> getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }

    @XmlTransient
    public List<Afectation> getAfectationList() {
        return afectationList;
    }

    public void setAfectationList(List<Afectation> afectationList) {
        this.afectationList = afectationList;
    }

    @XmlTransient
    public List<Contacts> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<Contacts> contactsList) {
        this.contactsList = contactsList;
    }

    @XmlTransient
    public List<Situation> getSituationList() {
        return situationList;
    }

    public void setSituationList(List<Situation> situationList) {
        this.situationList = situationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soshs.ump.grh.jpa.Person[ idPerson=" + idPerson + " ]";
    }
    
}
