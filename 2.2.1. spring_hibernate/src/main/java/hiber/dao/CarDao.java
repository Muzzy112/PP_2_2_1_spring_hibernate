package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

public interface CarDao {
    void save(Car car);
    Car get(long id);
    User getUserByModelAndSeries(String model, int series);
}
