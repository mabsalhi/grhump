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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author mabs
 */
@Entity
@Table(name = "diplome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diplome.findAll", query = "SELECT d FROM Diplome d"),
    @NamedQuery(name = "Diplome.findById", query = "SELECT d FROM Diplome d WHERE d.id = :id"),
    @NamedQuery(name = "Diplome.findByIntitul\u00e9", query = "SELECT d FROM Diplome d WHERE d.intitul\u00e9 = :intitul\u00e9"),
    @NamedQuery(name = "Diplome.findByType", query = "SELECT d FROM Diplome d WHERE d.type = :type"),
    @NamedQuery(name = "Diplome.findByNiveau", query = "SELECT d FROM Diplome d WHERE d.niveau = :niveau")})
public class Diplome implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "intitul\u00e9")
    private String intitulé;
    @Size(max = 150)
    @Column(name = "type")
    private String type;
    @Column(name = "niveau")
    private Integer niveau;
    @OneToMany(mappedBy = "diplome")
    private List<Qualification> qualificationList;

    public Diplome() {
    }

    public Diplome(Integer id) {
        this.id = id;
    }

    public Diplome(Integer id, String intitulé) {
        this.id = id;
        this.intitulé = intitulé;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitulé() {
        return intitulé;
    }

    public void setIntitulé(String intitulé) {
        this.intitulé = intitulé;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    @XmlTransient
    public List<Qualification> getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
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
        if (!(object instanceof Diplome)) {
            return false;
        }
        Diplome other = (Diplome) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soshs.ump.grh.jpa.Diplome[ id=" + id + " ]";
    }
    
}
