package br.com.entelgy.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMalformedException extends AuthenticationException {
  
	private static final long serialVersionUID = 6458535543427482648L;

	public JwtTokenMalformedException(String msg) {
        super(msg);
    }
}