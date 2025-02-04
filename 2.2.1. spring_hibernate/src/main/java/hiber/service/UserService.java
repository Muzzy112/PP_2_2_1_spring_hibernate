package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User get(long id);
    void update(User user);
    List<User> listUsers();
}
