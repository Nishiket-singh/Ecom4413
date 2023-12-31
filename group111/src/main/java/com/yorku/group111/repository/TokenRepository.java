package com.yorku.group111.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yorku.group111.model.AuthenticationToken;
import com.yorku.group111.model.User;




@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUser(User user);
    
    AuthenticationToken findByToken(String token);
}
