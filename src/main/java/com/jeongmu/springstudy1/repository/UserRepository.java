package com.jeongmu.springstudy1.repository;

import com.jeongmu.springstudy1.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {






    // findBy까지 보고 select로 판별, Account, account를 매칭
    // select * from user where account = ? << test03, test04

/*
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);
    // select * from user where account = ? and email = ?
    Optional<User> findByAccountAndEmail(String account, String email);
*/



}
