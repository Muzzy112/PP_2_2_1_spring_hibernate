package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void update(User user);
   User get(long id);
   List<User> listUsers();
}
