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
@Table(name = "entite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entite.findAll", query = "SELECT e FROM Entite e"),
    @NamedQuery(name = "Entite.findById", query = "SELECT e FROM Entite e WHERE e.id = :id"),
    @NamedQuery(name = "Entite.findByIntitule", query = "SELECT e FROM Entite e WHERE e.intitule = :intitule"),
    @NamedQuery(name = "Entite.findByType", query = "SELECT e FROM Entite e WHERE e.type = :type")})
public class Entite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 250)
    @Column(name = "intitule")
    private String intitule;
    @Size(max = 2147483647)
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "entite")
    private List<Afectation> afectationList;

    public Entite() {
    }

    public Entite(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<Afectation> getAfectationList() {
        return afectationList;
    }

    public void setAfectationList(List<Afectation> afectationList) {
        this.afectationList = afectationList;
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
        if (!(object instanceof Entite)) {
            return false;
        }
        Entite other = (Entite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soshs.ump.grh.jpa.Entite[ id=" + id + " ]";
    }
    
}
