package com.alkemy.api.services;
import com.alkemy.api.models.UserModel;
import com.alkemy.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserModel save(UserModel user){
        return repository.save(user);
    }

    
}
