package com.tokobuku.dao.mapper;

import com.tokobuku.model.Customer;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements org.springframework.jdbc.core.RowMapper<com.tokobuku.model.Customer> {
    @Nullable
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer = new Customer(
                resultSet.getInt("cust_id"),
                resultSet.getString("full_name"),
                resultSet.getString("address"),
                resultSet.getString("email")
        );
        return customer;
    }
}
