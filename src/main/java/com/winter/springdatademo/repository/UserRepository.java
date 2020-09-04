package com.winter.springdatademo.repository;

import com.winter.springdatademo.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaSpecificationExecutor<User>, CrudRepository<User,Long> {

    public List<User> findByName(String name);
}
