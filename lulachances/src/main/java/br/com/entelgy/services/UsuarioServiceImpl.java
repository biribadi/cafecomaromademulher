package br.com.entelgy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.entelgy.models.UserSnacks;
import br.com.entelgy.repository.UserRepository;

public class UsuarioServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<UserSnacks> users = userRepository.findAllUserByEmail(email);
		if (users == null || users.isEmpty()){
			throw new UsernameNotFoundException("user not found");
		}
		return users.get(0);
	}

}
