package br.com.entelgy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.entelgy.models.UserSnacks;
import br.com.entelgy.repository.UserRepository;
import br.com.entelgy.secutiry.JwtUserFactory;

@Service("userDetailsService")
public class UsuarioServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserSnacks user = userRepository.findByEmail(email);
		if (user == null ){
			throw new UsernameNotFoundException("user not found");
		}
		return JwtUserFactory.create(user);
	}

}
