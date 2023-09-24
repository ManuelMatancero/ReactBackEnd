package com.matancita.cardatabase.web;

import com.matancita.cardatabase.dao.CarDao;
import com.matancita.cardatabase.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author manue
 */
@RestController
public class CarController {
    @Autowired
    CarDao carRepository;
    
    @RequestMapping("/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }
    
}
