package fr.solution.air.controllers;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solution.air.exceptions.NotFoundException;
import fr.solution.air.models.User;
import fr.solution.air.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;

	@PostMapping("")
	public ResponseEntity<User> save(@Valid @RequestBody User user) {
		us.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<User> findById(@PathVariable long id) {

		User user = new User();
		try {
			user = us.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new NotFoundException("Invalid id : " + id);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
