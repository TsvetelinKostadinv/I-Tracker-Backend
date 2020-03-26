/*
 * 25/03/2020 18:26:20
 * InvoiceView.java created by Tsvetelin
 */
package com.itracker.backend.Backend.entities.invoice.view;


import com.itracker.backend.Backend.entities.invoice.InvoiceEntity;
import lombok.Data;


/**
 * @author Tsvetelin
 *
 */
@Data
public class InvoiceView
{
    
    public final InvoiceEntity entity;
    
    public InvoiceView ()
    {
        super();
        this.entity = new InvoiceEntity();
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
        this.entity = entity;
    }
    
    /**
     * @return
     */
    public InvoiceEntity toEntity ()
    {
        return this.entity;
    }
    
    public Double paid ()
    {
        return this.entity.getPayments().stream().mapToDouble( x -> x.amount ).sum();
    }
    
    public Double amountToPay ()
    {
        return this.entity.getAmountToPay();
    }
    
    public Double rest ()
    {
        return this.amountToPay() - this.paid();
    }
    
    public boolean checkPaid ()
    {
        return this.entity.getAmountToPay().compareTo( this.paid() ) != 1;
    }
    
    public boolean checkOverPaid ()
    {
        return this.entity.getAmountToPay().compareTo( this.paid() ) == -1;
    }
    
}
