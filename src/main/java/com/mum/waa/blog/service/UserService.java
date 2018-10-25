package com.mum.waa.blog.service;

import java.util.Optional;

import com.mum.waa.blog.model.User;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);
}
