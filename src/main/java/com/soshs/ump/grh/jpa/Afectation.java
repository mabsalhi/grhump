/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soshs.ump.grh.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mabs
 */
@Entity
@Table(name = "afectation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Afectation.findAll", query = "SELECT a FROM Afectation a"),
    @NamedQuery(name = "Afectation.findById", query = "SELECT a FROM Afectation a WHERE a.id = :id"),
    @NamedQuery(name = "Afectation.findByDateAffectation", query = "SELECT a FROM Afectation a WHERE a.dateAffectation = :dateAffectation"),
    @NamedQuery(name = "Afectation.findByMission", query = "SELECT a FROM Afectation a WHERE a.mission = :mission")})
public class Afectation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateAffectation;
    @Size(max = 2147483647)
    @Column(name = "mission")
    private String mission;
    @JoinColumn(name = "entite", referencedColumnName = "id")
    @ManyToOne
    private Entite entite;
    @JoinColumn(name = "person", referencedColumnName = "id_person")
    @ManyToOne
    private Person person;

    public Afectation() {
    }

    public Afectation(Integer id) {
        this.id = id;
    }

    public Afectation(Integer id, Date dateAffectation) {
        this.id = id;
        this.dateAffectation = dateAffectation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(Date dateAffectation) {
        this.dateAffectation = dateAffectation;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Afectation)) {
            return false;
        }
        Afectation other = (Afectation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soshs.ump.grh.jpa.Afectation[ id=" + id + " ]";
    }
    
}
