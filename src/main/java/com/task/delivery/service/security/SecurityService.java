package com.task.delivery.service.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
