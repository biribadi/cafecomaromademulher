package br.com.entelgy.security.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.entelgy.security.transfer.JwtUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenValidator {
	@Value("${jwt.secret}")
	private String secret;

	public JwtUserDto parseToken(String token) {
		JwtUserDto u = null;
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			u = new JwtUserDto();
			u.setUsername(body.getSubject());
			u.setId(Long.parseLong((String) body.get("userId")));
			u.setRole((String) body.get("role"));
		} catch (JwtException e) {
			e.printStackTrace();
		}
		return u;
	}
}
