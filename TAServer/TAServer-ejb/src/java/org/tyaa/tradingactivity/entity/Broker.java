/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Юрий
 */
@Entity
@Table(name = "Broker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Broker.findAll", query = "SELECT b FROM Broker b"),
    @NamedQuery(name = "Broker.findById", query = "SELECT b FROM Broker b WHERE b.id = :id"),
    @NamedQuery(name = "Broker.findByName", query = "SELECT b FROM Broker b WHERE b.name = :name"),
    @NamedQuery(name = "Broker.findByLogin", query = "SELECT b FROM Broker b WHERE b.login = :login"),
    @NamedQuery(name = "Broker.findByPassword", query = "SELECT b FROM Broker b WHERE b.password = :password")})
public class Broker implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brokerId")
    private Collection<Sale> saleCollection;

    public Broker()
    {
    }

    public Broker(Integer id)
    {
        this.id = id;
    }

    public Broker(Integer id, String name, String login, String password)
    {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @XmlTransient
    public Collection<Sale> getSaleCollection()
    {
        return saleCollection;
    }

    public void setSaleCollection(Collection<Sale> saleCollection)
    {
        this.saleCollection = saleCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Broker)) {
            return false;
        }
        Broker other = (Broker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "org.tyaa.tradingactivity.entity.Broker[ id=" + id + " ]";
    }
    
}
