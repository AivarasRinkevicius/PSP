package com.user_creation.application.jpa;

import com.user_creation.application.model.User;
import com.user_creation.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        userRepository.save(new User("Jonas","Jonaitis", "+370612347847", "jonasjon@gmail.com", "verkiu g. 12, Vilnius", "Jonaitis12-"));
    }
}
