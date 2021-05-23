package com.alkemy.api.repositories;
import com.alkemy.api.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<UserModel,Integer>{

    public abstract UserModel getByUsername(String username);
}
