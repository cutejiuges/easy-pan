package com.easy_pan.common.utils;

import com.easy_pan.common.enums.JwtTokenTypeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.Getter;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 处理生成jwtToken和token解析的工具类
 */
public class JwtUtil {
    // 使用固定密钥：使用固定的字符串生成 HMAC 密钥
    private static final String secretKey = "easy_pan:CUTEJIUGE_secretkeyrJ6:aC4]cN6;sL3.pY5]zH6,yY2.zQ9/xB8$";
    private static final SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    private static final AeadAlgorithm signatureAlgorithm = Jwts.ENC.A256CBC_HS512;
    @Getter
    private static final long accessExpirationTime = 1000L * 60 * 60 * 2; //accessToken设置2h过期时间
    @Getter
    private static final long refreshExpirationTime = 1000L * 60 * 60 * 24 * 2; // refreshToken设置2d过期时间

    /**
     * 根据传入的用户身份信息生成jwtToken字符串
     * @param claims 用于保存用户身份信息的map
     * @return jwt字符串
     */
    public static String generateJwtToken(Map<String, Object> claims, int tokenType) {
        String subject = tokenType == JwtTokenTypeEnum.AccessToken.getCode() ?
                JwtTokenTypeEnum.AccessToken.getMsg() : JwtTokenTypeEnum.RefreshToken.getMsg();
        long expirationTime = tokenType == JwtTokenTypeEnum.AccessToken.getCode() ?
                accessExpirationTime : refreshExpirationTime;
        return Jwts.builder()
                .issuer("easy-pan")
                .subject(subject)
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .id(UUID.randomUUID().toString())
                .encryptWith(key, signatureAlgorithm)
                .compact();
    }

    /**
     * 根据得到的jwtToken解析出来用户身份信息
     * @param token 待解析的jwtToken
     * @return 用户身份信息map
     */
    public static Claims parseJwtToken(String token) {
        return Jwts.parser()
                .decryptWith(key)
                .build()
                .parseEncryptedClaims(token)
                .getPayload();
    }

    public static boolean invalidJwtToken(String token, int tokenType) {
        Claims claims;
        try {
            claims = parseJwtToken(token);
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        } catch (MalformedJwtException | SignatureException | UnsupportedJwtException e) {
            return true;
        }
        String expectedSubject = tokenType == JwtTokenTypeEnum.AccessToken.getCode() ?
                JwtTokenTypeEnum.AccessToken.getMsg() : JwtTokenTypeEnum.RefreshToken.getMsg();
        String expectedIssuer = "easy-pan";
        String actuallySubject = claims.getSubject(), actuallyIssuer = claims.getIssuer();
        return !actuallySubject.equals(expectedSubject) || !actuallyIssuer.equals(expectedIssuer);
    }

    public static boolean expiredJwtToken(String token) {
        Claims claims;
        try {
            claims = parseJwtToken(token);
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        }
        Date expiration = claims.getExpiration();
        Date now = new Date();
        return expiration.before(now);
    }
}
