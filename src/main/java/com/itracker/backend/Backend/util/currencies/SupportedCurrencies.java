/*
 * 26/03/2020 17:48:11
 * SupportedCurrencies.java created by Tsvetelin
 */
package com.itracker.backend.Backend.util.currencies;


/**
 * @author Tsvetelin
 *
 */
public enum SupportedCurrencies
{
    BGN("BGN"),
    EUR("EUR"),
    DOLLAR("USD");
    
    public final String abbreviation;
    
    SupportedCurrencies( String abbreviation )
    {
        this.abbreviation = abbreviation.toUpperCase();
    }
}
