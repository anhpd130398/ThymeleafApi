package demo.requestApi.repository;

import demo.requestApi.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository  extends JpaRepository<Car,Integer> {

    @Query(nativeQuery = true,value = "select * from cars")
    List<Car> getListByCars();

    @Query(nativeQuery = true,value = "select * from cars c where c.id= :carId")
    Car finByCarId(@Param("carId") int carId);


}
