package com.maktab.Q2;

import com.maktab.App;
import com.maktab.Q2.model.address.Address;
import com.maktab.Q2.model.employee.Employee;
import com.maktab.Q2.model.phonenumber.PhoneNumber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HiberMain {
    public static void main(String[] args) {
        Reflections reflections = new Reflections(App.class.getPackage().getName());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);

        Configuration configure = new Configuration().configure();

        for (Class<?> aClass : classes) {
            configure.addAnnotatedClass(aClass);
        }

        try (
                SessionFactory factory = configure.buildSessionFactory();
                Session session = factory.openSession();

        ) {
            Employee employee1 = new Employee("1111","emp1",1000D );
            Employee employee2 = new Employee("2222","emp2",2000D );

            Address address11 = new Address("post11","Add11","Tehran");
            Address address12 = new Address("post12","Add12","Tehran");

            PhoneNumber phoneNumber1 = new PhoneNumber("1111","2222");
            PhoneNumber phoneNumber2 = new PhoneNumber("1112","22220");

            phoneNumber1.setAddress(address11);
            phoneNumber2.setAddress(address12);

            address11.setEmployee(employee1);
            address12.setEmployee(employee2);

            session.beginTransaction();

            session.persist(phoneNumber1);
            session.persist(phoneNumber2);

//            String query = "select max(s.employee.salary),s.city From Address s ";
//            List<Object[]> a = new ArrayList<>();
//            a = session.createQuery(query).list();
//            for(Object[] s:a) {
//                for (int i = 0; i < s.length; i++) {
//                    System.out.println(s[i].toString());
//                }
//            }

//            ArrayList<Object> employees = new ArrayList<>();
//            employees.add(session.createQuery("from Employee e where e.salary = " +
//                    "(select max(b.salary) from Employee b)").list());
//            System.out.println(employees);
//
//            String query2 = "select s.employee from Address s where s.postalCode = 'post11'";
//            List<Employee> b = session.createQuery(query2).list();
//            System.out.println(b.toString());
//

            session.getTransaction().commit();
            session.close();
        }
    }
}
