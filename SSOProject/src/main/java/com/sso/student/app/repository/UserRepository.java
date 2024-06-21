package com.sso.student.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sso.student.app.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
