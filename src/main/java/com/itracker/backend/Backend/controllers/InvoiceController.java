/*
 * 25/03/2020 15:49:42
 * InvoiceController.java created by Tsvetelin
 */
package com.itracker.backend.Backend.controllers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itracker.backend.Backend.entities.invoice.InvoiceEntity;
import com.itracker.backend.Backend.entities.invoice.view.InvoiceView;
import com.itracker.backend.Backend.repositories.InvoiceRepository;


/**
 * @author Tsvetelin
 *
 */
@RestController ( )
public class InvoiceController
{
    
    private final InvoiceRepository repo;
    
    @Autowired
    public InvoiceController ( InvoiceRepository repo )
    {
        this.repo = repo;
    }
    
    @PostMapping ( "/create" )
    public ResponseEntity< InvoiceEntity > create (
        @RequestBody InvoiceView view
    )
    {
        return new ResponseEntity< InvoiceEntity >(
            repo.save( view.toEntity() ) ,
            HttpStatus.OK
        );
    }
    
    @GetMapping ( "/get/{id}" )
    public ResponseEntity< InvoiceEntity > getById (
        @PathVariable ( value = "id" ) Long id
    )
    {
        return repo
            .findById( id )
            .map(
                x -> new ResponseEntity< InvoiceEntity >(
                    x ,
                    HttpStatus.OK
                )
            )
            .orElse( new ResponseEntity< InvoiceEntity >( HttpStatus.NOT_FOUND ) );
    }
    
    @DeleteMapping ( "/delete/{id}" )
    public ResponseEntity< InvoiceEntity > deleteById (
        @PathVariable ( value = "id" ) Long id
    )
    {
        repo.deleteById( id );
        return new ResponseEntity< InvoiceEntity >( HttpStatus.OK );
    }
    
    @PostMapping ( "/update/{id}" )
    public ResponseEntity< InvoiceEntity > update (
        @PathVariable ( value = "id" ) Long id ,
        @RequestBody InvoiceView view
    )
    {
        repo.deleteById( id );
        final InvoiceEntity ent = view.toEntity();
        ent.setId( id );
        return new ResponseEntity< InvoiceEntity >(
            repo.save( ent ) ,
            HttpStatus.OK
        );
    }
    
    @GetMapping ( "/all" )
    public List< InvoiceEntity > all ()
    {
        return repo.findAll();
    }
    
    @GetMapping ( "/all/view" )
    public List< InvoiceView > allViews ()
    {
        return repo
            .findAll()
            .stream()
            .map( InvoiceView::new )
            .collect( Collectors.toList() );
    }
    
    @GetMapping ( "/first" )
    public List< InvoiceEntity > first ( @PathVariable Long number )
    {
        return repo
            .findAll()
            .stream()
            .limit( number )
            .collect( Collectors.toList() );
    }
    
    @GetMapping ( "/first/view" )
    public List< InvoiceView > firstViews ( @PathVariable Long number )
    {
        return repo
            .findAll()
            .stream()
            .limit( number )
            .map( InvoiceView::new )
            .collect( Collectors.toList() );
    }
    
    @GetMapping ( "/first" )
    public List< InvoiceEntity > first (
        @NonNull @PathVariable Long after ,
        @NonNull @PathVariable Long number
    )
    {
        return repo
            .findAll()
            .stream()
            .skip( after )
            .limit( number )
            .collect( Collectors.toList() );
    }
    
    @GetMapping ( "/first/view" )
    public List< InvoiceView > firstViews (
        @NonNull @PathVariable Long after ,
        @NonNull @PathVariable Long number
    )
    {
        return repo
            .findAll()
            .stream()
            .skip( after )
            .limit( number )
            .map( InvoiceView::new )
            .collect( Collectors.toList() );
    }
    
}
