package fr.solution.air.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.solution.air.models.User;
import fr.solution.air.services.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService us;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User u = us.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(
						"Username " + username + "not found"));
		return new MyUserDetails(u);
	}

}