/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matancita.cardatabase.dao;

import com.matancita.cardatabase.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manue
 */
public interface UserDao extends CrudRepository<User, Long> {
    
    User findByUsername(String username);
    
}
