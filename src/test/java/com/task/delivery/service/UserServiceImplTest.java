package com.task.delivery.service;

import com.task.delivery.model.User;
import com.task.delivery.repository.UserRepository;
import com.task.delivery.validator.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import java.text.ParseException;
import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Spy
    UserValidator userValidator;

    @Spy
    ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Mock
    UserServiceImpl converter;

    User user = new User();

    public void getUser(Long id, String username, String password, String passwordConfirm)  {
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setPasswordConfirm(passwordConfirm);
     //   user.setRoles(roles);

    }

    @Test
    public void testSmoke()  {
        getUser(1L,"tt", "aa", "bb");
        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getUsername()).isEqualTo("tt");
        assertThat(user.getPassword()).isEqualTo("aa");
        assertThat(user.getPasswordConfirm()).isEqualTo("bb");
    }

}