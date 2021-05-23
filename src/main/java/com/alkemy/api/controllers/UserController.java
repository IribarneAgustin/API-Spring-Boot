package com.alkemy.api.controllers;
import com.alkemy.api.models.UserModel;
import com.alkemy.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService service;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@PostMapping("/auth/register")
	public UserModel save(@ModelAttribute UserModel user,@RequestParam("password") String password) {
		user.setPassword(bCryptPasswordEncoder.encode(password));
		return service.save(user);
	}
    

}