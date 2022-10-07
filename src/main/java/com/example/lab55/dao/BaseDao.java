package com.example.lab55.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class BaseDao {
    protected final JdbcTemplate jdbcTemplate;

    public final void execute(String sql){
        jdbcTemplate.execute(sql);
    }
}
