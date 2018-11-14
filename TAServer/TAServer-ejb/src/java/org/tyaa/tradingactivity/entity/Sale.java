/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Юрий
 */
@Entity
@Table(name = "Sale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s"),
    @NamedQuery(name = "Sale.findById", query = "SELECT s FROM Sale s WHERE s.id = :id"),
    @NamedQuery(name = "Sale.findBySecurityName", query = "SELECT s FROM Sale s WHERE s.securityName = :securityName"),
    @NamedQuery(name = "Sale.findByQuantity", query = "SELECT s FROM Sale s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "Sale.findByPrice", query = "SELECT s FROM Sale s WHERE s.price = :price")})
public class Sale implements Serializable
{

    private static final long serialVersionUID = 20120731125400L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "security_name")
    private String securityName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category categoryId;
    @JoinColumn(name = "broker_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Broker brokerId;

    public Sale()
    {
    }

    public Sale(Integer id)
    {
        this.id = id;
    }

    public Sale(Integer id, String securityName, int quantity, int price)
    {
        this.id = id;
        this.securityName = securityName;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getSecurityName()
    {
        return securityName;
    }

    public void setSecurityName(String securityName)
    {
        this.securityName = securityName;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public Category getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Category categoryId)
    {
        this.categoryId = categoryId;
    }

    public Broker getBrokerId()
    {
        return brokerId;
    }

    public void setBrokerId(Broker brokerId)
    {
        this.brokerId = brokerId;
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
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "org.tyaa.tradingactivity.entity.Sale[ id=" + id + " ]";
    }
    
}
