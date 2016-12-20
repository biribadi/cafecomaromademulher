package br.com.entelgy.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException {
  
	private static final long serialVersionUID = -5099408170608635929L;

	public JwtTokenMissingException(String msg) {
        super(msg);
    }
}