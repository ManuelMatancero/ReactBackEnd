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
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application ){
        return application.sources(CardatabaseApplication.class);
    }
    
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
     
            

}
