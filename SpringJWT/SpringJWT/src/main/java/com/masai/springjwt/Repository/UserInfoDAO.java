package com.masai.springjwt.Repository;

import com.masai.springjwt.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoDAO extends JpaRepository<UserInfo,Integer> {
    public UserInfo findByEmail(String email);
}
