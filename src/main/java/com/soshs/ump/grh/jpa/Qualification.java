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
@Table(name = "qualification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qualification.findAll", query = "SELECT q FROM Qualification q"),
    @NamedQuery(name = "Qualification.findByIdQualification", query = "SELECT q FROM Qualification q WHERE q.idQualification = :idQualification"),
    @NamedQuery(name = "Qualification.findByType", query = "SELECT q FROM Qualification q WHERE q.type = :type"),
    @NamedQuery(name = "Qualification.findByDateObtention", query = "SELECT q FROM Qualification q WHERE q.dateObtention = :dateObtention"),
    @NamedQuery(name = "Qualification.findByPartieDelivrante", query = "SELECT q FROM Qualification q WHERE q.partieDelivrante = :partieDelivrante"),
    @NamedQuery(name = "Qualification.findBySp\u00e9cialit\u00e9", query = "SELECT q FROM Qualification q WHERE q.sp\u00e9cialit\u00e9 = :sp\u00e9cialit\u00e9")})
public class Qualification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_qualification")
    private Integer idQualification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateObtention")
    @Temporal(TemporalType.DATE)
    private Date dateObtention;
    @Size(max = 250)
    @Column(name = "partie_delivrante")
    private String partieDelivrante;
    @Size(max = 250)
    @Column(name = "sp\u00e9cialit\u00e9")
    private String spécialité;
    @JoinColumn(name = "diplome", referencedColumnName = "id")
    @ManyToOne
    private Diplome diplome;
    @JoinColumn(name = "person", referencedColumnName = "id_person")
    @ManyToOne
    private Person person;

    public Qualification() {
    }

    public Qualification(Integer idQualification) {
        this.idQualification = idQualification;
    }

    public Qualification(Integer idQualification, String type, Date dateObtention) {
        this.idQualification = idQualification;
        this.type = type;
        this.dateObtention = dateObtention;
    }

    public Integer getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(Integer idQualification) {
        this.idQualification = idQualification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(Date dateObtention) {
        this.dateObtention = dateObtention;
    }

    public String getPartieDelivrante() {
        return partieDelivrante;
    }

    public void setPartieDelivrante(String partieDelivrante) {
        this.partieDelivrante = partieDelivrante;
    }

    public String getSpécialité() {
        return spécialité;
    }

    public void setSpécialité(String spécialité) {
        this.spécialité = spécialité;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
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
        hash += (idQualification != null ? idQualification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qualification)) {
            return false;
        }
        Qualification other = (Qualification) object;
        if ((this.idQualification == null && other.idQualification != null) || (this.idQualification != null && !this.idQualification.equals(other.idQualification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soshs.ump.grh.jpa.Qualification[ idQualification=" + idQualification + " ]";
    }
    
}
