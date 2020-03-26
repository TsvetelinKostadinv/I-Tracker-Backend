/*
 * 25/03/2020 15:33:31
 * Payment.java created by Tsvetelin
 */
package com.itracker.backend.Backend.entities.payment;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Embeddable;

import com.itracker.backend.Backend.util.timeutil.Time;

import lombok.Data;


/**
 * @author Tsvetelin
 *
 */
@Data
@Embeddable
public class Payment implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public final Date paymentDate;
    public final Double amount;
    
    /**
     * @param paymentDate
     * @param amount
     */
    public Payment ( Date paymentDate , Double amount )
    {
        super();
        this.paymentDate = paymentDate;
        this.amount = amount;
    }
    
    /**
     * @param paymentDate
     * @param amount
     */
    public Payment ()
    {
        super();
        this.paymentDate = Time.nowSQL();
        this.amount = 0.0;
    }
    
}
