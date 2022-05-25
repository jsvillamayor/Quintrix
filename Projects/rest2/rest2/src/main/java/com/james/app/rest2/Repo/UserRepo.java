package com.james.app.rest2.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.james.app.rest2.Models.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
