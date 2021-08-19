//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.form;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

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

    public void saveValues(List<String> details) {
        iterator = details.iterator();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Employee employee = new Employee();
        employee.setFirstName(iterator.next());
        employee.setLastName(iterator.next());
        employee.setEmail(iterator.next());
        employee.setGender(iterator.next());
        employee.setJobDescription(iterator.next());
        employee.setPassword(iterator.next());

        session.save(employee);
        transaction.commit();
        session.close();
    }
}
