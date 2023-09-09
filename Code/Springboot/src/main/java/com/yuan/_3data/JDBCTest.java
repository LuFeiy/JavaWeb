package com.yuan._3data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JDBCTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void test_01(){
        Integer cnt = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM t_user", Integer.class);
        System.out.println("cnt:"+cnt);
        assertEquals(1, cnt);
    }
}
