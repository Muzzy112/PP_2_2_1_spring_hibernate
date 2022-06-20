package hiber.service;

import hiber.model.Car;
import hiber.model.User;

public interface CarService {
    void add(Car car);
    Car get(long id);
    User getUserByCarModelAndSeries(String model, int series);
}
