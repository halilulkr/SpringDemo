package com.example.SpringDemo.repositories;

import com.example.SpringDemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

}
