package fr.solution.air.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.solution.air.models.User;
import fr.solution.air.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;

	public void save(User u) {
		ur.save(u);
	}

	public Optional<User> findById(long id) {
		return ur.findById(id);
	}

	public Collection<User> findAll() {
		return ur.findAll();
	}

	public Optional<User> findByUsername(String un) {
		return ur.findByUsername(un);
	}
}