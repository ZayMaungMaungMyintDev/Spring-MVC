package com.next.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.next.domain.Customer;
import com.next.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	List<Customer> listOfCustomers = new ArrayList<Customer>();

	public CustomerRepositoryImpl() {
		
		Customer customer1 = new Customer("C0001", "Mg Zay", "Yangon", 20);
		
		Customer customer2 = new Customer("C0002", "Mg Kyaw", "Mandalay", 30);
		
		Customer customer3 = new Customer("C0003", "Ma Khin", "Bahan", 27);
		
		Customer customer4 = new Customer("C0004", "Ma Aye", "YanKin", 26);
		
		Customer customer5 = new Customer("C0005", "Mg Tun", "TaungNgu", 32);
		
		listOfCustomers.add(customer1);
		listOfCustomers.add(customer2);
		listOfCustomers.add(customer3);
		listOfCustomers.add(customer4);
		listOfCustomers.add(customer5);
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}

}
