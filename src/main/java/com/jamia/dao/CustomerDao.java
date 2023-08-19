package com.jamia.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jamia.bean.Customer;

import java.util.List;

@Repository
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll() {
        String query = "SELECT * FROM customer1";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Customer customer = new Customer();
            customer.setCustomerID(rs.getInt("id"));
            customer.setCustomerName(rs.getString("name"));
            customer.setCustomerAddress(rs.getString("address"));
            // Set more fields as per your requirements
            return customer;
        });
    }

    @SuppressWarnings("deprecation")
	public Customer GetCustomerById(int id) {
        String query = "SELECT * FROM customer1 WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) -> {
            Customer customer = new Customer();
            customer.setCustomerID(rs.getInt("id"));
            customer.setCustomerName(rs.getString("name"));
            customer.setCustomerAddress(rs.getString("Address"));
            // Set more fields as per your requirements
            return customer;
        });
    }

    public void create(Customer customer) {
        String query = "INSERT INTO customer1 (id, name, address) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, customer.getCustomerID(),customer.getCustomerName(), customer.getCustomerAddress());
    }

    public void update( Customer customer) {
        String query = "UPDATE customer1 SET name = ?,address = ? WHERE id = ?";
        jdbcTemplate.update(query, customer.getCustomerID(), customer.getCustomerName(), customer.getCustomerAddress());
    }

    public void delete(int id) {
        String query = "DELETE FROM customer1 WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}