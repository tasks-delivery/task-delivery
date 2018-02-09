package com.task.delivery.service.user;

import com.task.delivery.model.User;
import com.task.delivery.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Mock
    UserServiceImpl converter;

    @Test
    public void createNewUser()  {
        User user = new User(1L,"test", "test","test");
        assertThat(user.getUsername()).isEqualTo("test");
        assertThat(user.getPassword()).isEqualTo("test");
        assertThat(user.getPasswordConfirm()).isEqualTo("test");
    }

}