/*
 * 25/03/2020 14:03:25
 * InvoiceEntity.java created by Tsvetelin
 */
package com.itracker.backend.Backend.entities.invoice;


import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.itracker.backend.Backend.entities.payment.Payment;
import com.itracker.backend.Backend.util.currencies.SupportedCurrencies;
import com.itracker.backend.Backend.util.timeutil.Time;

import lombok.Data;


/**
 * @author Tsvetelin
 *
 */
@Data
@Entity ( name = "Invoice" )
@Table ( name = "invoices" )
public class InvoiceEntity implements Serializable
{
    
    private static final long     serialVersionUID = 1L;
    
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private Long                  id;
    
    @Column
    private String                number;
    
    @Column
    private Date                  creationDate;
    
    @Column
    private String                fromCompany;
    
    @Column
    private String                toCompany;
    
    @Column
    private String                goodsDescription;
    
    @Column
    private Double                amountToPay;
    
    @Column
    private SupportedCurrencies   currency;
    
    @Column
    private LinkedList< Payment > payments;
    
    /**
     * DEFAULT CONSTRUCTOR WITH DEFAULT DATA
     */
    public InvoiceEntity ()
    {
        super();
        this.number = "NOT_SPECIFIED";
        this.creationDate = Time.nowSQL();
        this.fromCompany = "NO_FROM_SPECIFIED";
        this.toCompany = "NO_TO_COMPANY_SPECIFIED";
        this.goodsDescription = "NO_GOOD_SPECIFIED";
        this.amountToPay = 0.0;
        this.currency = SupportedCurrencies.BGN;
        this.payments = new LinkedList<>();
    }
    
    /**
     * @param id
     * @param number
     * @param creationDate
     * @param fromCompany
     * @param toCompany
     * @param goodsDescription
     * @param amountToPay
     */
    public InvoiceEntity (
        Long id ,
        String number ,
        Date creationDate ,
        String fromCompany ,
        String toCompany ,
        String goodsDescription ,
        Double amountToPay ,
        SupportedCurrencies currency
    )
    {
        super();
        this.id = id;
        this.number = number;
        this.creationDate = creationDate;
        this.fromCompany = fromCompany;
        this.toCompany = toCompany;
        this.goodsDescription = goodsDescription;
        this.amountToPay = amountToPay;
        this.currency = currency;
        this.payments = new LinkedList<>();
    }
    
    public InvoiceEntity addPayment ( Payment payment )
    {
        if ( this.payments == null )
        {
            this.payments = new LinkedList< Payment >();
        }
        this.payments.add( payment );
        return this;
    }
    
    /**
     * @return the id
     */
    public Long getId ()
    {
        return id;
    }
    
    /**
     * @param id
     *            the id to set
     */
    public void setId ( Long id )
    {
        this.id = id;
    }
    
    /**
     * @return the number
     */
    public String getNumber ()
    {
        return number;
    }
    
    /**
     * @param number
     *            the number to set
     */
    public void setNumber ( String number )
    {
        this.number = number;
    }
    
    /**
     * @return the creationDate
     */
    public Date getCreationDate ()
    {
        return creationDate;
    }
    
    /**
     * @param creationDate
     *            the creationDate to set
     */
    public void setCreationDate ( Date creationDate )
    {
        this.creationDate = creationDate;
    }
    
    /**
     * @return the fromCompany
     */
    public String getFromCompany ()
    {
        return fromCompany;
    }
    
    /**
     * @param fromCompany
     *            the fromCompany to set
     */
    public void setFromCompany ( String fromCompany )
    {
        this.fromCompany = fromCompany;
    }
    
    /**
     * @return the toCompany
     */
    public String getToCompany ()
    {
        return toCompany;
    }
    
    /**
     * @param toCompany
     *            the toCompany to set
     */
    public void setToCompany ( String toCompany )
    {
        this.toCompany = toCompany;
    }
    
    /**
     * @return the goodsDescription
     */
    public String getGoodsDescription ()
    {
        return goodsDescription;
    }
    
    /**
     * @param goodsDescription
     *            the goodsDescription to set
     */
    public void setGoodsDescription ( String goodsDescription )
    {
        this.goodsDescription = goodsDescription;
    }
    
    /**
     * @return the amountToPay
     */
    public Double getAmountToPay ()
    {
        return amountToPay;
    }
    
    /**
     * @param amountToPay
     *            the amountToPay to set
     */
    public void setAmountToPay ( Double amountToPay )
    {
        this.amountToPay = amountToPay;
    }
    
    /**
     * @return the currency
     */
    public SupportedCurrencies getCurrency ()
    {
        return currency;
    }
    
    /**
     * @param currency
     *            the currency to set
     */
    public void setCurrency ( SupportedCurrencies currency )
    {
        this.currency = currency;
    }
    
    /**
     * @return the payments
     */
    public LinkedList< Payment > getPayments ()
    {
        return payments;
    }
    
    /**
     * @param payments
     *            the payments to set
     */
    public void setPayments ( LinkedList< Payment > payments )
    {
        this.payments = payments;
    }
}
