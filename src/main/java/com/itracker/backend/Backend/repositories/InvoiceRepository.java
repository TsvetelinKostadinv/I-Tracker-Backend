/*
 * 25/03/2020 15:48:40
 * InvoiceRepository.java created by Tsvetelin
 */
package com.itracker.backend.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itracker.backend.Backend.entities.invoice.InvoiceEntity;

/**
 * @author Tsvetelin
 *
 */
@Repository
public interface InvoiceRepository extends JpaRepository< InvoiceEntity , Long >
{
    
}
