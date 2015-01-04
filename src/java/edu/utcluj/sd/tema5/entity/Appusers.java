/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcluj.sd.tema5.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eniko
 */
@Entity
@Table(name = "appusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appusers.findAll", query = "SELECT a FROM Appusers a"),
    @NamedQuery(name = "Appusers.findById", query = "SELECT a FROM Appusers a WHERE a.id = :id"),
    @NamedQuery(name = "Appusers.findByName", query = "SELECT a FROM Appusers a WHERE a.name = :name"),
    @NamedQuery(name = "Appusers.findByUsername", query = "SELECT a FROM Appusers a WHERE a.username = :username"),
    @NamedQuery(name = "Appusers.findByPassword", query = "SELECT a FROM Appusers a WHERE a.password = :password"),
    @NamedQuery(name = "Appusers.findByAddress", query = "SELECT a FROM Appusers a WHERE a.address = :address"),
    @NamedQuery(name = "Appusers.findByType", query = "SELECT a FROM Appusers a WHERE a.type = :type")})
public class Appusers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "type")
    private String type;

    public Appusers() {
    }

    public Appusers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Appusers)) {
            return false;
        }
        Appusers other = (Appusers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utcluj.sd.tema5.entity.Appusers[ id=" + id + " ]";
    }
    
}
