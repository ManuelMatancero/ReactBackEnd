package com.matancita.cardatabase;

import com.matancita.cardatabase.dao.CarDao;
import com.matancita.cardatabase.dao.OwnerDao;
import com.matancita.cardatabase.dao.UserDao;
import com.matancita.cardatabase.domain.Car;
import com.matancita.cardatabase.domain.Owner;
import com.matancita.cardatabase.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CardatabaseApplication extends SpringBootServletInitializer {
    @Autowired
    CarDao carService;
    @Autowired
    OwnerDao ownerService;
    @Autowired
    UserDao userService;
    
        @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application ){
        return application.sources(CardatabaseApplication.class);
    }

	public static void main(String[] args) throws Exception  {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
        @Bean
        CommandLineRunner runner(){
            return args -> {
                
                
                //Save demo data
                Owner owner1 = new Owner("Manuel", "Sarante");
                Owner owner2 = new Owner("Nicole", "Sarante");
                ownerService.save(owner1);
                ownerService.save(owner2);
                
                
                //Save demo data to database
                carService.save(new Car("Ford", "Mustang", "Red", "ADF-1122",
                2017, 59000, owner1));
                carService.save(new Car("Nissan", "Leaf", "Red", "ADF-15656",
                2014, 29000, owner2));
                carService.save(new Car("Toyota", "Tacoma", "Black", "ADF-4533",
                2010, 25000, owner2));
                
                //save demo user
                userService.save(new User("user",
                       "$2a$10$hdW6nDMUqI3cYqD2GyfwKuDvQcsqJmYJ6nXPEg1W3cdev1ngquCqu",
               "USER"));
            };
            
           
        }
         public static String encodePass(String pass){      
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String passEncoded = encoder.encode(pass);
                return passEncoded;
            }

}
