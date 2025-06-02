package com.easy_pan.common.utils;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class JwtUtilTest {

    @Test
    void parseJwtToken() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("nickName", "zhangsan");
        map.put("totalSpace", 500);
        map.put("usedSpace", 100);
        String token = JwtUtil.generateJwtToken(map, 0);
        System.out.println(token);
        Claims claims = JwtUtil.parseJwtToken(token);
        System.out.println(claims);
    }

    @Test
    void testParseJwtToken() {
        String token = "123456";
        Claims claims = JwtUtil.parseJwtToken(token);
        System.out.println(claims);
    }
}