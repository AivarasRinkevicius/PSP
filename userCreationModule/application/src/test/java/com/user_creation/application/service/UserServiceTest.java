package com.user_creation.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.user_creation.application.interfaces.Validator;
import com.user_creation.application.model.User;
import com.user_creation.application.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xmlunit.validation.ValidationResult;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ValidatorFactory validatorFactory;

    @Mock
    private Validator validator;

    @InjectMocks
    UserService userService;

    @Test
    void testFindById() {
        User user = new User("Jonas", "Jonaitis", "+37063914578", "jonaitis@gmail.com", "Vilnius, traku gatve 34", "Jomnas124?");

        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));

        User userFound = userService.findById(1L);
        verify(userRepository).findById(Mockito.anyLong());
        assertNotNull(userFound);
    }

    @Test
    void testFindAll() {

        User user = new User("Jonas", "Jonaitis", "+37063914578", "jonaitis@gmail.com", "Vilnius, traku gatve 34", "Jomnas124?");

        List<User> users = new ArrayList<>();
        users.add(user);

        when(userRepository.findAll()).thenReturn(users);

        List<User> found = userService.findAll();

        verify(userRepository).findAll();

        assertEquals(1, found.size());
    }

    @Test
    void testValidateBadUser() {

        when(validatorFactory.getValidator(Mockito.anyString())).thenReturn(validator);
        User user = new User("Jonas", "Jonaitis", "+370639", "jonaitisgmail.com", "Vilnius, traku gatve 34", "Jomnas124");

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            userService.validate(user);
        });

        Assertions.assertEquals("blogas email!\nblogas slaptazodis!\nblogas telefono numeris!\n", thrown.getMessage());

    }

    @Test
    void testValidateValidUser() {

        when(validatorFactory.getValidator(Mockito.anyString())).thenReturn(validator);

        User user = new User("Jonas", "Jonaitis", "+370639", "jonaitisgmail.com", "Vilnius, traku gatve 34", "Jomnas124");

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            userService.validate(user);
        });

        Assertions.assertEquals("blogas email!\nblogas slaptazodis!\nblogas telefono numeris!\n", thrown.getMessage());

    }

    @Test
    void testUpdate() throws Exception {

        when(validatorFactory.getValidator(Mockito.anyString())).thenReturn(validator);
        when(validator.validate(Mockito.anyString())).thenReturn(Boolean.TRUE);

        User user = new User("Jonas", "Jonaitis", "+37063914578", "jonaitis@gmail.com", "Vilnius, traku gatve 34", "Jomnas124?");

        userService.update(user);
        verify(userRepository).save(Mockito.any(User.class));

    }

    @Test
    void testDeleteById() {

        userService.deleteById(1);

        verify(userRepository).deleteById(Mockito.anyLong());
        verify(userRepository).deleteById(1L);
    }

    @Test
    void testAdd() throws Exception {

        when(validatorFactory.getValidator(Mockito.anyString())).thenReturn(validator);
        when(validator.validate(Mockito.anyString())).thenReturn(Boolean.TRUE);

        User user = new User("Jonas", "Jonaitis", "863914578", "jonaitis@gmail.com", "Vilnius, traku gatve 34", "Jomnas124?");

        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User added = userService.add(user);
        verify(userRepository).save(Mockito.any(User.class));
        assertNotNull(added);
    }
}