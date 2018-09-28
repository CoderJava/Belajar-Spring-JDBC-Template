package com.tokobuku.dao.impl;

import com.tokobuku.dao.CustomerDao;
import com.tokobuku.dao.mapper.CustomerRowMapper;
import com.tokobuku.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class CustomerDaoImpl implements CustomerDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void insert(Customer customer) {
        JdbcTemplate jdbcTemplate;
        String sql = "INSERT INTO CUSTOMER " +
                "(cust_id, full_name, address, email)" +
                "VALUES " +
                "(?, ?, ?, ?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, customer.getCustId(),
                customer.getFullName(),
                customer.getAddress(),
                customer.getEmail());
    }

    public Customer findByCustomerId(int custId) {
        JdbcTemplate jdbcTemplate;
        String sql = "SELECT * FROM CUSTOMER WHERE cust_id = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject(sql, new Object[]{
                custId
        }, new CustomerRowMapper());
    }

    public void update(Customer customer) {
        JdbcTemplate jdbcTemplate;
        String sql = "UPDATE CUSTOMER " +
                "SET " +
                "full_name = ?, address = ?, email = ?" +
                "WHERE cust_id = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, customer.getFullName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getCustId());
    }

    public void deleteByCustomerId(int custId) {
        JdbcTemplate jdbcTemplate;
        String sql = "DELETE FROM CUSTOMER WHERE cust_id = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, custId);
    }
}
