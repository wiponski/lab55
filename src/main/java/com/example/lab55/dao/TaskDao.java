package com.example.lab55.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class TaskDao extends BaseDao{
    public TaskDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }
}
