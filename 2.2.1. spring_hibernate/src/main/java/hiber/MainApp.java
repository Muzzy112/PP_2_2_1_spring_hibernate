package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      // Юзеры с машинами:
      userService.add(new User("AAA", "BBB", "AA@mail.gov", new Car("qwerty", 404)));
      userService.add(new User("QQQ","WWW","QQ@mail.gov", new Car("ytrewq", 500)));

      // Юзер без машины получил машину
      User firstU = userService.get(1);
      firstU.setCar(new Car("RedCar", 200));
      userService.update(firstU);

      System.out.println();

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      User u = carService.getUserByCarModelAndSeries("RedCar", 200);
      System.out.println();
      System.out.println(u.getFirstName());

      context.close();
   }
}
