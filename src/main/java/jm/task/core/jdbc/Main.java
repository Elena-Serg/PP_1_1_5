package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Fedor", "Sumkin", (byte) 70);
        userService.saveUser("Harry", "Potter", (byte) 11);
        userService.saveUser("Petr", "Petrov", (byte) 16);
        userService.saveUser("Ivan", "Ivanov", (byte) 20);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
