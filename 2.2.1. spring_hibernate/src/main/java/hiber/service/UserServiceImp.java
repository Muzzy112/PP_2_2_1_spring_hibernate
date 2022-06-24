package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private CarService carService;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
      saveOrUpdateUserCar(user);
   }

   @Transactional
   @Override
   public User get(long id) {
      return userDao.get(id);
   }

   @Transactional
   @Override
   public void update(User user) {
      userDao.update(user);
      saveOrUpdateUserCar(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   private void saveOrUpdateUserCar(User user){
      Car userCar = user.getCar();
      if(userCar != null){
         userCar.setUser(user);
         carService.save(userCar);
      }
   }

}
