package com.xianglesong.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xianglesong.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

//    @Autowired
//    DataSource dataSource;

//    @Autowired
//    JdbcTemplate jdbcTemplate;

//    @Autowired
//    StringRedisTemplate redisTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Value("${msg}")
    private String msg;

    // http://localhost:8080/getUsers?username=test&password=pwd
    @RequestMapping("/test1")
    public String test1(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//        System.out.println(dataSource);
//        List<UserInfo> users = new ArrayList<>();
//    dataSource.getConnection();
//        String sql = "select count(*) from user_info";
//        int count = jdbcTemplate.queryForObject(sql, Integer.class);
//        System.out.println("数据总数：" + count);
        System.currentTimeMillis();
        return String.valueOf("count");
    }

    @RequestMapping("/say/{name}")
    public String test2(@PathVariable String name) throws SQLException {
//        System.out.println(dataSource);
        System.out.println("hhh: " + name);
        System.out.println("hhh2: " + name);
        System.out.println("msg: " + msg);
//        redisTemplate.opsForValue().set("k", name);
//        log.info();
        //        List<UserInfo> users = new ArrayList<>();
//    dataSource.getConnection();
//        String sql = "select count(*) from user_info";
//        int count = jdbcTemplate.queryForObject(sql, Integer.class);
//        System.out.println("数据总数：" + count);
        System.currentTimeMillis();
        ResponseEntity<String> result =  restTemplate.getForEntity("http://"+msg+"", String.class);
        System.out.println("result: "+  result.getBody().toString());
        return "hello " + name + " : " + msg +   " result: " + result.getBody().toString();
    }
}
