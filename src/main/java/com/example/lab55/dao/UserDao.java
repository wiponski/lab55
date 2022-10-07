package com.example.lab55.dao;

import com.example.lab55.dto.UserDto;
import com.example.lab55.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
public class UserDao extends BaseDao {

    private final PasswordEncoder passwordEncoder;

    public UserDao(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
        super(jdbcTemplate);
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(User user) {
        String sql = "insert into users (username, email, password) " +
                "values(  ?, ?, ?)";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, passwordEncoder.encode(user.getPassword()));
            return ps;
        });
        // jdbcTemplate.update(sql, user.getEmail(), user.getUsername(), user.getPassword());
    }

    public void deleteAll() {
        String sql = "DELETE FROM users;";
        jdbcTemplate.update(sql);
    }


    public List<User> getAllUsers() {
        String query = "select * from users";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class)); //.execute для Import-U-D
    }

    public Optional<User> findByUsername(String email) {
        String sql = "select * from users where username =?";
        return Optional.of(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), email));
    }


}
