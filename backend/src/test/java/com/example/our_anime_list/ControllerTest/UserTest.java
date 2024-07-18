package com.example.our_anime_list.ControllerTest;

import com.example.our_anime_list.controller.UserController;
import com.example.our_anime_list.entity.AuthRequest;
import com.example.our_anime_list.entity.User;
import com.example.our_anime_list.service.JwtService;
import com.example.our_anime_list.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class UserTest {
    @Autowired
    UserController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void test_returns_user_when_username_exists() {
        UserService userService = mock(UserService.class);
        UserController userController = new UserController();
        ReflectionTestUtils.setField(userController, "userService", userService);

        String username = "existingUser";
        User expectedUser = new User();
        expectedUser.setUsername(username);

        when(userService.getByUsername(username)).thenReturn(expectedUser);

        User actualUser = userController.getUserByUsername(username);

        assertNotNull(actualUser);
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
    }

    @Test
    public void test_returns_null_when_username_does_not_exist() {
        UserService userService = mock(UserService.class);
        UserController userController = new UserController();
        ReflectionTestUtils.setField(userController, "userService", userService);

        String username = "nonExistingUser";

        when(userService.getByUsername(username)).thenReturn(null);

        User actualUser = userController.getUserByUsername(username);

        assertNull(actualUser);
    }

}
