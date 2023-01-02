package com.stackroute.UserService.repository;

import com.stackroute.UserService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
List<User> findByLastName(String lastName);//public abstract
}
