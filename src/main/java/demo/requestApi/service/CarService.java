package demo.requestApi.service;

import demo.requestApi.entities.Car;
import demo.requestApi.entities.pay.BaseResponse;
import demo.requestApi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<Car> getAllListCars(){
        return carRepository.getListByCars();
    }

    public BaseResponse saveCar(Car car){
        List<Car> carList = carRepository.findAll();
        if (carList.size()>0){
            return new BaseResponse("not success!","");
        }else {
            Car car1 = new Car();
            car1.setCarName(car.getCarName());
            car1 = carRepository.save(car1);
            return new BaseResponse("success!!",car1);
        }
    }
}
