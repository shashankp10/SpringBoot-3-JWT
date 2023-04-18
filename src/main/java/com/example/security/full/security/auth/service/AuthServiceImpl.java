package com.example.security.full.security.auth.service;

import com.example.security.full.security.users.Requests.UsersRequest;
import com.example.security.full.security.users.model.Users;
import com.example.security.full.security.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UsersRepository usersRepository;

    public Optional<Users> AddUser(UsersRequest user) {
    	
        Users newUser = new Users();
        newUser.setName(user.getName());
        newUser.setEnrollment(user.getEnrollment());
        newUser.setBranch(user.getBranch());
        newUser.setSemester(user.getSemester());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        newUser.setRoles("ROLE_USER");
        return Optional.of(usersRepository.save(newUser));
        
    }
}
