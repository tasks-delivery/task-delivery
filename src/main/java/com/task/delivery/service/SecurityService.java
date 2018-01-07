package com.task.delivery.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
