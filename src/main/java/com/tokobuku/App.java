package com.tokobuku;

import com.tokobuku.dao.CustomerDao;
import com.tokobuku.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Main.xml");
        /*CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
        customerDao.insert(new Customer(1, "Yudi Setiawan", "Jalan Klambir 5", "kolonel.yudisetiawan@gmail.com"));
        customerDao.insert(new Customer(2, "Dian Ika Wahyuni", "Jalan Marelan pasar 3", "dianika.wahyuni@gmail.com"));
        customerDao.insert(new Customer(3, "Arie Dwi Nugraha", "Jalan Setia Budi", "aridwinugraha@gmail.com"));

        Customer customerLocal = customerDao.findByCustomerId(1);
        System.out.println(customerLocal);

        customerLocal.setFullName("Valentino Rossi");
        customerDao.update(customerLocal);
        System.out.println(customerLocal);

        customerDao.deleteByCustomerId(2);
        System.out.println("Customer ID 2 has been deleted");*/

        CustomerDao customerDaoSupport = (CustomerDao) context.getBean("customerDaoSupport");
        customerDaoSupport.insert(new Customer(1, "Yudi Setiawan", "Jalan Klambir 5", "kolonel.yudisetiawan@gmail.com"));
        customerDaoSupport.insert(new Customer(2, "Dian Ika Wahyuni", "Jalan Marelan pasar 3", "dianika.wahyuni@gmail.com"));
        customerDaoSupport.insert(new Customer(3, "Arie Dwi Nugraha", "Jalan Setia Budi", "aridwinugraha@gmail.com"));
        System.out.println("data awal: " + customerDaoSupport.findAllCustomer());

        Customer customerLocal = customerDaoSupport.findByCustomerId(1);
        System.out.println(customerLocal);

        customerLocal.setFullName("Valentino Rossi");
        customerDaoSupport.update(customerLocal);
        System.out.println(customerLocal);
        System.out.println("data edit: " + customerDaoSupport.findAllCustomer());

        customerDaoSupport.deleteByCustomerId(2);
        System.out.println("Customer ID 2 has been deleted");
        System.out.println("data hapus: " + customerDaoSupport.findAllCustomer());

    }
}
