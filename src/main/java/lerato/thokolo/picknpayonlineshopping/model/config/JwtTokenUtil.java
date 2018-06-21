/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lerato.thokolo.picknpayonlineshopping.model.role.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.mobile.device.Device;

/**
 *
 * @author User
 */
@Component
public class JwtTokenUtil implements Serializable{
    
     private static final long serialVersionUID = -3301605591108950415L;
     
     
    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_AUDIENCE = "audience";
    static final String CLAIM_KEY_CREATED = "created";
    static final String CLAIM_KEY_USERID = "userID";
    static final String CLAIM_KEY_ROLES = "userRoles";

    private static final String AUDIENCE_UNKNOWN = "unknown";
    private static final String AUDIENCE_WEB = "web";
    private static final String AUDIENCE_MOBILE = "mobile";
    private static final String AUDIENCE_TABLET = "tablet";
    
    
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;
    
    public String getUsernameFromToken(String token) {
        
        String username = "";
        
        try {
            final Claims claims = getClaimsFromToken(token);
            
            username = claims.getSubject();
            
        } catch (Exception e) {
            
            username = null;
        }
        
        return username;
    }
    
    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }
    
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }
    
    public String getAudienceFromToken(String token) {
        String audience;
        try {
            final Claims claims = getClaimsFromToken(token);
            audience = (String) claims.get(CLAIM_KEY_AUDIENCE);
        } catch (Exception e) {
            audience = null;
        }
        return audience;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            claims = null;
        }
        return claims;
    }
    
     private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }
     
    private Boolean isTokenExpired(String token) {
        
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    
    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }
    
    
    private String generateAudience(Device device) {
        String audience = AUDIENCE_UNKNOWN;
        if (device.isNormal()) {
            audience = AUDIENCE_WEB;
        } else if (device.isTablet()) {
            audience = AUDIENCE_TABLET;
        } else if (device.isMobile()) {
            audience = AUDIENCE_MOBILE;
        }
        return audience;
    }
    
    
    private Boolean ignoreTokenExpiration(String token) {
        String audience = getAudienceFromToken(token);
        return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
    }
    
    public CustomUserDetails parseToken(String token){
    
         try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            CustomUserDetails customUser = new CustomUserDetails();
            
            customUser.setUserID((int) body.get(CLAIM_KEY_USERID));
            customUser.setUserName(body.getSubject());
            customUser.setRoles((Set<Role>) body.get(CLAIM_KEY_ROLES));
            customUser.setFullNames((String) body.get("fullNames"));
            customUser.setEmail((String) body.get("email"));

            return customUser;

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }
    
    
    public String generateToken(CustomUserDetails customUserDetails/*, Device device*/) {
        
        Map<String, Object> claims = new HashMap<>();
        
        //claims.put(CLAIM_KEY_AUDIENCE, generateAudience(device));
        claims.put(CLAIM_KEY_USERID, customUserDetails.getUserID());
        claims.put(CLAIM_KEY_USERNAME, customUserDetails.getUsername());
        claims.put(CLAIM_KEY_ROLES, customUserDetails.getAuthorities());
        claims.put("email", customUserDetails.getEmail());
        claims.put("fullNames", customUserDetails.getFullNames());
        claims.put(CLAIM_KEY_CREATED, new Date());
        
        return generateToken(claims);
    }

    
     String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }
    
    public Boolean validateToken(String token, CustomUserDetails customUserDetails) {
        CustomUserDetails customUser = customUserDetails;
        final String username = getUsernameFromToken(token);
        final Date created = getCreatedDateFromToken(token);
        //final Date expiration = getExpirationDateFromToken(token);
        return (
                username.equals(customUser.getUsername())
                        && !isTokenExpired(token)
                        && !isCreatedBeforeLastPasswordReset(created, customUser.getLastPasswordResetDate()));
    }

}
