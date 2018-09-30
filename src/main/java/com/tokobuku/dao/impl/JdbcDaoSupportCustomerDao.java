package com.tokobuku.dao.impl;

import com.tokobuku.dao.CustomerDao;
import com.tokobuku.dao.mapper.CustomerRowMapper;
import com.tokobuku.model.Customer;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class JdbcDaoSupportCustomerDao extends JdbcDaoSupport implements CustomerDao {

    public void insert(Customer customer) {
        String sql = "INSERT INTO CUSTOMER " +
                "(cust_id, full_name, address, email) " +
                "VALUES " +
                "(?, ?, ?, ?)";
        if (getJdbcTemplate() != null) {
            getJdbcTemplate().update(sql, customer.getCustId(), customer.getFullName(), customer.getFullName(), customer.getEmail());
        } else {
            throw new RuntimeException("getJdbcTemplate null");
        }
    }

    public Customer findByCustomerId(int custId) {
        String sql = "SELECT * FROM CUSTOMER " +
                "WHERE " +
                "cust_id = ?";
        if (getJdbcTemplate() != null) {
            return getJdbcTemplate().queryForObject(sql, new Object[]{custId}, new CustomerRowMapper());
        } else {
            return null;
        }
    }

    public void update(Customer customer) {
        String sql = "UPDATE CUSTOMER " +
                "SET " +
                "full_name = ?, address = ?, email = ? " +
                "WHERE cust_id = ?";
        if (getJdbcTemplate() != null) {
            getJdbcTemplate().update(sql, customer.getFullName(), customer.getAddress(), customer.getEmail(), customer.getCustId());
        } else {
            throw new RuntimeException("getJdbcTemplate null");
        }
    }

    public void deleteByCustomerId(int custId) {
        String sql = "DELETE FROM CUSTOMER WHERE cust_id = ?";
        if (getJdbcTemplate() != null) {
            getJdbcTemplate().update(sql, custId);
        } else {
            throw new RuntimeException("getJdbcTemplate null");
        }
    }

    public List<Customer> findAllCustomer() {
        String sql = "SELECT * FROM CUSTOMER";
        List<Customer> customers = new ArrayList<Customer>();
        if (getJdbcTemplate() != null) {
            customers = getJdbcTemplate().query(sql, new CustomerRowMapper());
        }
        return customers;
    }
}
