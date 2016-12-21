package br.com.entelgy.secutiry;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.entelgy.models.Role;
import br.com.entelgy.models.UserSnacks;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UserSnacks user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRoles()),
                user.getActive(),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole()))
                .collect(Collectors.toList());
    }
}
