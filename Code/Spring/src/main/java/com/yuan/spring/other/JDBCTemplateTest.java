package com.yuan.spring.other;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate(){
        String sql = "insert into t_emp values(null,?,?,?)";
        jdbcTemplate.update(sql, "张三", 23, "男");
    }
}
