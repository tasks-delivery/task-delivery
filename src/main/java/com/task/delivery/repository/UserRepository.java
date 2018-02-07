package com.task.delivery.repository;

import com.task.delivery.model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    public List<User> findByPassword(String password);

    public List<User> findById(Integer id);

}
