package com.matancita.cardatabase.dao;

import com.matancita.cardatabase.domain.Car;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarDao extends CrudRepository<Car, Long> {
    
    //Fetch cars by brand
    List<Car> findByBrand(@Param("brand") String brand);
    
    //Fetch cars by colors
    List<Car> findByColor(@Param("color") String color);
    
}
