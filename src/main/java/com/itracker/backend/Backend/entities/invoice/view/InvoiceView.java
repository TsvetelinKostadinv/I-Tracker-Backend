/*
 * 25/03/2020 18:26:20
 * InvoiceView.java created by Tsvetelin
 */
package com.itracker.backend.Backend.entities.invoice.view;


import java.sql.Date;
import java.util.LinkedList;

import com.itracker.backend.Backend.entities.invoice.InvoiceEntity;
import com.itracker.backend.Backend.entities.payment.Payment;
import com.itracker.backend.Backend.util.timeutil.Time;

import lombok.Data;


/**
 * @author Tsvetelin
 *
 */
@Data
public class InvoiceView
{
    
    public final String                number;
    
    public final Date                  creationDate;
    
    public final String                fromCompany;
    
    public final String                toCompany;
    
    public final String                goodsDescription;
    
    public final Double                amountToPay;
    
    public final LinkedList< Payment > payments;
    
    public InvoiceView()
    {
        super();
        this.number = "Number";
        this.creationDate = Time.nowSQL();
        this.fromCompany = "From";
        this.toCompany = "To";
        this.goodsDescription = "Goods";
        this.amountToPay = 0.0;
        this.payments = new LinkedList< Payment >();
    }
    
    /**
     * @param number
     * @param creationDate
     * @param fromCompany
     * @param toCompany
     * @param goodsDescription
     * @param amountToPay
     * @param payments
     */
    public InvoiceView (
        InvoiceEntity entity
    )
    {
        super();
        this.number = entity.getNumber();
        this.creationDate = entity.getCreationDate();
        this.fromCompany = entity.getFromCompany();
        this.toCompany = entity.getToCompany();
        this.goodsDescription = entity.getGoodsDescription();
        this.amountToPay = entity.getAmountToPay();
        this.payments = entity.getPayments();
    }

    /**
     * @return
     */
    public InvoiceEntity toEntity ()
    {
        return new InvoiceEntity(
            0l ,
            number ,
            creationDate ,
            fromCompany ,
            toCompany ,
            goodsDescription ,
            amountToPay
        );
    }
    
    public Double paid ()
    {
        return this.payments.stream().mapToDouble( x -> x.amount ).sum();
    }
    
    public Double amountToPay ()
    {
        return this.amountToPay;
    }
    
    public Double rest ()
    {
        return this.amountToPay() - this.paid();
    }
    
    public boolean checkPaid ()
    {
        return this.amountToPay.compareTo( this.paid() ) != 1;
    }
    
    public boolean checkOverPaid ()
    {
        return this.amountToPay.compareTo( this.paid() ) == -1;
    }
    
}
