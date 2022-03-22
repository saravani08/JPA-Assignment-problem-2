package Gradle_demo;
import javax.persistence.EntityManager;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Address;
import com.Customer;

public class Library {
    public boolean someLibraryMethod() {
        return true;
    }
    public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ItemPU");
		EntityManager entitymanager = emf.createEntityManager();
		Address add = new Address();
		add.setCustomerAddress("405,park street");
		
		
		Customer cust = new Customer();
	    cust.setCustomerName("saravani");
	    cust.setCustomerEmail("abc@gmail.com");
	    cust.setCustomerAddress(add);
		
		entitymanager.getTransaction().begin();
		entitymanager.persist(cust);
		entitymanager.flush();
		entitymanager.getTransaction().commit();
		
		Customer customer1 = entitymanager.find(Customer.class, "saravani");
		/System.out.println(customer1.getCustomerName());
		System.out.println(customer1.getCustomerEmail());
		System.out.println(customer1.getCustomerAddress());
		
		
	}
}
