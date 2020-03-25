/*
 * 25/03/2020 15:49:42
 * InvoiceController.java created by Tsvetelin
 */
package com.itracker.backend.Backend.controllers;


import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itracker.backend.Backend.entities.invoice.InvoiceEntity;
import com.itracker.backend.Backend.entities.invoice.view.InvoiceView;
import com.itracker.backend.Backend.entities.payment.Payment;
import com.itracker.backend.Backend.repositories.InvoiceRepository;
import com.itracker.backend.Backend.util.timeutil.Time;


/**
 * @author Tsvetelin
 *
 */
@RestController ( )
public class InvoiceController
{
    
    @Autowired
    InvoiceRepository repo;
    
    @GetMapping ( "/test" )
    public InvoiceEntity index ()
    {
        final InvoiceEntity res =
            new InvoiceEntity( 3l , "202929386" , new Date( 0 ) , "Benzinostaciq" , "CIG Trans" , "disel" , 5000.0 );
        
        res.addPayment( new Payment( Time.nowSQL() , 2500.0 ) );
        res.addPayment( new Payment( Time.nowSQL() , 2500.0 ) );
        
        return res;
    }
    
    @PostMapping ( "/create" )
    public ResponseEntity< InvoiceEntity > create ( @RequestBody InvoiceView view )
    {
        return new ResponseEntity< InvoiceEntity >( repo.save( view.toEntity() ) , HttpStatus.OK );
    }
    
    @GetMapping ( "/all" )
    public List< InvoiceView > all (  )
    {
        return repo.findAll().stream().map( InvoiceView::new ).collect( Collectors.toList() );
    }
    
}
