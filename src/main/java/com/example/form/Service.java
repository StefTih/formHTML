//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.form;

import java.util.Iterator;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Service {
    private ServiceRegistry registry;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private Iterator<String> iterator;

    public Service() {
        registry = (new StandardServiceRegistryBuilder()).configure("META-INF/persistence.cfg.xml").build();
        sessionFactory = (new MetadataSources(registry)).buildMetadata().buildSessionFactory();
    }

    public void saveValues(HttpServletRequest details) {
//        iterator = details.iterator();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Employee employee = new Employee();
        employee.setFirstName(details.getParameter("firstName"));
        employee.setLastName(details.getParameter("lastName"));
        employee.setEmail(details.getParameter("email"));
        employee.setGender(details.getParameter("gender"));
        employee.setJobDescription(details.getParameter("jobDescription"));
        employee.setPassword(details.getParameter("password"));

        session.save(employee);
        transaction.commit();
        session.close();
    }
}
