/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matancita.cardatabase.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author manue
 */
public class EncoderPass {
    
    public static void main(String[] args) {
        
        String encodedPass = encodePass("user");
        System.out.println("encodedPass = " + encodedPass);
        
    }
     public static String encodePass(String pass){      
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String passEncoded = encoder.encode(pass);
                return passEncoded;
            }
}
