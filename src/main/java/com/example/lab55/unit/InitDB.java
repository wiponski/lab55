package com.example.lab55.unit;

import com.example.lab55.dao.UserDao;
import com.example.lab55.entity.User;
import com.example.lab55.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@AllArgsConstructor
@Configuration
public class InitDB {
    private final UserDao userDao;
    private final UserService userService;
    // private final TaskDao taskDao;

    private void createUserTable() throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS authorities; "
                + "DROP TABLE IF EXISTS users";
        String createTableQuery = "CREATE TABLE users ("
                + "id bigserial PRIMARY KEY not null,"
                + "username TEXT, "
                + "email TEXT UNIQUE, "
                + "password TEXT "
                + ")";
        String createTableAuthorities = "CREATE TABLE authorities ("
                + "user_id INT not null,"
                + "authority varchar not null, "
                + "email TEXT UNIQUE, "
                + "CONSTRAINT user_di_FK FOREIGN KEY(user_id) REFERENCES users (id)"
                + ")";
        String userEntryQuery = "INSERT INTO users (username, email, password) "
                + "VALUES ( 'Brain', 'brain@test', 'pass')";
        userDao.execute(dropTableQuery);
        userDao.execute(createTableQuery);
        userDao.execute(createTableAuthorities);
        userDao.execute(userEntryQuery);
    }

    @Bean
    public CommandLineRunner fillUser() {
        return (args) -> {
            createUserTable();
            userDao.createUser(User.builder().username("Asan").email("asan@test").password("123").build());
            userDao.createUser(User.builder().username("Hasan").email("hasan@test").password("321").build());
            userDao.createUser(User.builder().username("Susan").email("sasan@test").password("555").build());


//          User user1 = new User();
//          user1.setUsername("Olga");
//        user1.setEmail("test@test");
//        user1.setPassword(encoder.encode("test"));
//        userDao.createUser(user1);

        };
    }
}
