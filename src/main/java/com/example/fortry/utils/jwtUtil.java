package com.example.fortry.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import java.security.Key;
import java.util.Date;
/*jwt由三部分组成：Header.Payload.Signature
* 其中Signature由Header，Payload和密钥组成，所以只要密钥不同
* 后面的Signature就会不同
* 这样就起到保护作用
* */
public class jwtUtil {
    private static final Key key = Keys.hmacShaKeyFor("mySecretKey123456789012345678901234123456478979879".getBytes());
//    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 8600000L;

    public static String generateToken(String username) {
        return Jwts
                .builder()//拿一个建造器，相当于空模板
                .setSubject(username)//
                .setIssuedAt(new Date())//设置生效开始的时间
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))//设置过期时间
                .signWith(key)//用密钥签名，防篡改
                .compact();//打包压缩
    }

    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key).build()//用同样的签名，初始化解析器
                .parseClaimsJws(token)//自动校验前面是否有效
                .getBody();//获取json数据
        return claims.getSubject();//获取字符串并返回
    }

    public static Boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);//注意jwt和jws有区别，前者是不带签名的，后者是带上的，不带签名就会对不上所以要用
            return true;
        } catch (ExpiredJwtException e) {
            return false;
        }
    }
}
