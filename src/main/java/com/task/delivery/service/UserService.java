package com.task.delivery.service;

import com.task.delivery.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
