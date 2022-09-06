package demo.requestApi.controller;

import demo.requestApi.entities.Car;
import demo.requestApi.repository.CarRepository;
import demo.requestApi.service.CarService;
import demo.requestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.MalformedParameterizedTypeException;


@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    CarRepository carRepository;

//
//    @PostMapping("/login")
//    public BaseResponse loginResponse(@RequestBody RequestLogin requestLogin){
//       return userService.loginUser(requestLogin);
//    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/car-list")
    public String getList(Model model) {
        model.addAttribute("cars", carService.getAllListCars());
        return "car-list";
    }

    @GetMapping("/addCarList")
    public ModelAndView addCar() {
        ModelAndView modelAndView = new ModelAndView("/add-car-list");
        Car newCar = new Car();
        modelAndView.addObject("car", newCar);
        return modelAndView;
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute Car car) {
        carRepository.save(car);
        return "redirect:/car-list";
    }

    @GetMapping("/updateCar")
    public String editCar(@RequestParam int carId, Model model) {
        Car car = carRepository.finByCarId(carId);
        model.addAttribute("car", car);
        return "update-car";
    }

    @PostMapping("/editCar")
    public String editCar(@RequestParam int id, @ModelAttribute Car car, Model model) {
        Car cars = new Car();
        if (id != 0) {
            cars.setId(id);
            cars.setCarName(car.getCarName());
            cars= carRepository.save(cars);
        }
        model.addAttribute("car", cars);
        return "redirect:/car-list";
    }

    @GetMapping("/deleteByCar")
    public String deleteByCar(@RequestParam int carId) {
        carRepository.deleteById(carId);
        return "redirect:/car-list";
    }

}
