package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

@Repository
public class CarDaoImpl implements CarDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Car car) {
        sessionFactory.getCurrentSession().saveOrUpdate(car);
    }

    @Override
    public Car get(long id) {
        return sessionFactory.getCurrentSession().load(Car.class, id);
    }

    @Override
    public User getUserByModelAndSeries(String model, int series) {
        User user = null;
        try{
            Car car = sessionFactory.getCurrentSession().createQuery(
                    "SELECT car FROM Car car WHERE car.model = :model AND car.series = :series", Car.class)
                    .setParameter("model", model)
                    .setParameter("series", series).getSingleResult();
            user = car.getUser();
        } catch (PersistenceException e){
            System.out.println("Сar not found");
        }
        return user;
    }
}
