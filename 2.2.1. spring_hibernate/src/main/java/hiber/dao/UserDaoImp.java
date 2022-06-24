package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void update(User user) {
      if (user.getId() != 0){
         sessionFactory.getCurrentSession().update(user);
      }
   }

   @Override
   public User get(long id) {
      //return sessionFactory.getCurrentSession().load(User.class, id);
      return sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
              .setParameter("id", id).getSingleResult();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
