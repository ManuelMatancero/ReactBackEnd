/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matancita.cardatabase.dao;

import com.matancita.cardatabase.domain.Owner;
import org.springframework.data.repository.CrudRepository;


public interface OwnerDao extends CrudRepository<Owner, Long> {
    
}
