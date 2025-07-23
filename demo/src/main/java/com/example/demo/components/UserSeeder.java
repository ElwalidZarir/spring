/* package com.example.demo.components;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

import jakarta.annotation.PostConstruct;

@Component
public class UserSeeder {

    @PostConstruct
    public void seed() {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();

        Session session = factory.openSession();

        try {
            User user = new User("Alissa", "alissa@xmple.com");
            session.beginTransaction();
            session.persist(user); 
            session.getTransaction().commit();
            System.out.println("User saved!");
        } finally {
            factory.close();
        }
    }
}
 */