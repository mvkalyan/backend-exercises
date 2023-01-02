package com.project.userauthentication.repository;

import com.project.userauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findUserByUserEmail(String userEmail);
}
