package com.cg.service;

import com.cg.model.Customer;
import com.cg.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IOUCustomer {
    public List<Customer> SelectMenu();

    public List<Customer> SeleCart();


    public void AddCustomer(Customer customer) throws SQLException;


    public Customer Showcustmer(int id);


    public boolean EditCustomer(Customer Customer);


    public boolean deleteCustomer(int id);

}
