package com.matancita.cardatabase;

import com.matancita.cardatabase.dao.CarDao;
import com.matancita.cardatabase.domain.Car;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author manue
 */
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CarRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private CarDao carService;
    
    @Test
    public void saveCar(){
        
        Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);
        
        entityManager.persistAndFlush(car);
        assertThat(car.getId()).isNotNull();
    }
    
    @Test
    public void deleteCars(){
        entityManager.persistAndFlush(new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000));
        entityManager.persistAndFlush(new Car("Tesla", "Model Y", "Blue", "ABC-4321", 2020, 29000));
        
        carService.deleteAll();
        
        assertThat(carService.findAll()).isEmpty();
    }
    
}
