package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema1";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";
    private static final String CONTEXT_CLASS = "thread";

    private static Connection connection;
    private static SessionFactory sessionFactory;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(User.class)
                    .setProperty(Environment.URL, URL)
                    .setProperty(Environment.USER, USER)
                    .setProperty(Environment.PASS, PASSWORD)
                    .setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, CONTEXT_CLASS);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
