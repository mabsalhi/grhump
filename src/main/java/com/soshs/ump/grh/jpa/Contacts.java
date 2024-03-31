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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author mabs
 */
@Entity
@Table(name = "contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c"),
    @NamedQuery(name = "Contacts.findByIdContacts", query = "SELECT c FROM Contacts c WHERE c.idContacts = :idContacts"),
    @NamedQuery(name = "Contacts.findByTypeContact", query = "SELECT c FROM Contacts c WHERE c.typeContact = :typeContact"),
    @NamedQuery(name = "Contacts.findByDetails", query = "SELECT c FROM Contacts c WHERE c.details = :details")})
public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contacts")
    private Integer idContacts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type_contact")
    private String typeContact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "details")
    private String details;
    @JoinColumn(name = "person", referencedColumnName = "id_person")
    @ManyToOne(optional = false)
    private Person person;

    public Contacts() {
    }

    public Contacts(Integer idContacts) {
        this.idContacts = idContacts;
    }

    public Contacts(Integer idContacts, String typeContact, String details) {
        this.idContacts = idContacts;
        this.typeContact = typeContact;
        this.details = details;
    }

    public Integer getIdContacts() {
        return idContacts;
    }

    public void setIdContacts(Integer idContacts) {
        this.idContacts = idContacts;
    }

    public String getTypeContact() {
        return typeContact;
    }

    public void setTypeContact(String typeContact) {
        this.typeContact = typeContact;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
        hash += (idContacts != null ? idContacts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.idContacts == null && other.idContacts != null) || (this.idContacts != null && !this.idContacts.equals(other.idContacts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soshs.ump.grh.jpa.Contacts[ idContacts=" + idContacts + " ]";
    }
    
}
