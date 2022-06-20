package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDao dao;

    @Override
    public void add(Car car) {
        dao.add(car);
    }

    @Override
    public Car get(long id) {
        return dao.get(id);
    }

    @Override
    public User getUserByCarModelAndSeries(String model, int series) {
        return dao.getUserByModelAndSeries(model, series);
    }
}
