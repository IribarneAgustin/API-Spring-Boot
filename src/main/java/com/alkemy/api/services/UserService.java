package com.alkemy.api.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alkemy.api.email.Mailer;
import com.alkemy.api.models.UserModel;
import com.alkemy.api.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    private Mailer mailer;

    public UserModel save(UserModel user) {

        UserModel newUser = repository.save(user);
        
        if (newUser != null) {
            mailer = new Mailer();
            mailer.sendEmail(newUser);
        }

        return newUser;
    }



}
