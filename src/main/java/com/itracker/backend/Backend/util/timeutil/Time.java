/*
 * 25/03/2020 16:29:38
 * Time.java created by Tsvetelin
 */
package com.itracker.backend.Backend.util.timeutil;

/**
 * @author Tsvetelin
 *
 */
public interface Time
{
    
    public static java.sql.Date nowSQL ()
    {
        return new java.sql.Date( now().getTime() );
    }
    
    public static java.util.Date now ()
    {
        return new java.util.Date();
    }
}
