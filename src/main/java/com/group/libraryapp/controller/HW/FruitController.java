package com.group.libraryapp.controller.HW;

import com.group.libraryapp.dto.HW.request.FruitRequest;
import com.group.libraryapp.dto.HW.request.FruitIdRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;


@RestController
public class FruitController {
    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitRequest request){
        String sql = "insert into fruit(name,price,warehousing_date) values (?,?,?)";

        Date sqlDate = Date.valueOf(request.getWarehousingDate());
        // jdbc가 요구하는 형식으로 교체 해줌. LocalDate -> java.sql.Date

        jdbcTemplate.update(sql, request.getName(),request.getPrice(),sqlDate);
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitIdRequest request){
        String sql = "update fruit SET is_sold= TRUE WHERE id=?";
        jdbcTemplate.update(sql,request.getId());

    }
}


