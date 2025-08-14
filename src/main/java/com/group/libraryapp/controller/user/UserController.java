package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        String sql = "INSERT INTO user(name,age) VALUES (?,?)"; //문자열 변수로 저장 ?부분에 유동적으로 들어감!!
        jdbcTemplate.update(sql, request.getName(), request.getAge()); // 2,3번째 인자들이 ?,?에 들어감!!
    }


    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        String sql = "SELECT * FROM user"; // 커멘드 + o로 maprow 오버라이딩해주기!!
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age); // db에서 가져온 정보를 userresopnse로 바꿔서 적용

        });
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        String readsql = "SELECT * FROM user WHERE id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readsql,(rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }
        String sql = "UPdate user SET name = ? WHERE id =?";
        jdbcTemplate.update(sql, request.getName(), request.getId());

    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        String readsql = "SELECT * FROM user WHERE name = ?";
        boolean isUserNotExist = jdbcTemplate.query(readsql,(rs, rowNum) -> 0, name).isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }
        String sql = "DELETE FROM user WHERE name =?";
        jdbcTemplate.update(sql, name);

    }

}
