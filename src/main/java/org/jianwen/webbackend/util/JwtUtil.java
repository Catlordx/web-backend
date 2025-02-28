package org.jianwen.webbackend.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static final String secretKey = "mySecretKey123";
    private static long EXPIRATION_TIME = 3600000;


    /**
     * 生成JWT令牌
     */
    public static String generateToken(String username, String role) {

        return JWT.create()
                .withSubject(username)
                .withClaim("role", role)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(secretKey));
    }

    /**
     * 验证JWT令牌并获取用户名和角色
     */
    public static DecodedJWT validateTokenAndGetDetails(String token) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256((secretKey));
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }

    /**
     * 从令牌中获取用户名
     */
    public static String getUsernameFromToken(String token) throws JWTVerificationException {
        return validateTokenAndGetDetails(token).getSubject();
    }

    /**
     * 从令牌中获取角色
     */
    public static String getRoleFromToken(String token) throws JWTVerificationException {
        return validateTokenAndGetDetails(token).getClaim("role").asString();
    }

    /**
     * 检查JWT令牌是否有效
     */
    public static boolean isTokenValid(String token) {
        try {
            validateTokenAndGetDetails(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }
}
