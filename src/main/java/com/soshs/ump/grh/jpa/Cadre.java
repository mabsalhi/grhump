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
@Table(name = "cadre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadre.findAll", query = "SELECT c FROM Cadre c"),
    @NamedQuery(name = "Cadre.findByIdCadre", query = "SELECT c FROM Cadre c WHERE c.idCadre = :idCadre"),
    @NamedQuery(name = "Cadre.findByIntitule", query = "SELECT c FROM Cadre c WHERE c.intitule = :intitule"),
    @NamedQuery(name = "Cadre.findByDescription", query = "SELECT c FROM Cadre c WHERE c.description = :description"),
    @NamedQuery(name = "Cadre.findByEchelle", query = "SELECT c FROM Cadre c WHERE c.echelle = :echelle"),
    @NamedQuery(name = "Cadre.findByIndice", query = "SELECT c FROM Cadre c WHERE c.indice = :indice")})
public class Cadre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cadre")
    private Integer idCadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "intitule")
    private String intitule;
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    @Column(name = "echelle")
    private Integer echelle;
    @Column(name = "indice")
    private Integer indice;
    @OneToMany(mappedBy = "parent")
    private List<Cadre> cadreList;
    @JoinColumn(name = "parent", referencedColumnName = "id_cadre")
    @ManyToOne
    private Cadre parent;
    @OneToMany(mappedBy = "cadre")
    private List<Situation> situationList;

    public Cadre() {
    }

    public Cadre(Integer idCadre) {
        this.idCadre = idCadre;
    }

    public Cadre(Integer idCadre, String intitule) {
        this.idCadre = idCadre;
        this.intitule = intitule;
    }

    public Integer getIdCadre() {
        return idCadre;
    }

    public void setIdCadre(Integer idCadre) {
        this.idCadre = idCadre;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEchelle() {
        return echelle;
    }

    public void setEchelle(Integer echelle) {
        this.echelle = echelle;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    @XmlTransient
    public List<Cadre> getCadreList() {
        return cadreList;
    }

    public void setCadreList(List<Cadre> cadreList) {
        this.cadreList = cadreList;
    }

    public Cadre getParent() {
        return parent;
    }

    public void setParent(Cadre parent) {
        this.parent = parent;
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
        hash += (idCadre != null ? idCadre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadre)) {
            return false;
        }
        Cadre other = (Cadre) object;
        if ((this.idCadre == null && other.idCadre != null) || (this.idCadre != null && !this.idCadre.equals(other.idCadre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soshs.ump.grh.jpa.Cadre[ idCadre=" + idCadre + " ]";
    }
    
}
