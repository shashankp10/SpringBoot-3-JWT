package com.example.security.full.security.users.service;

import com.example.security.full.security.users.Requests.UsersRequest;
import com.example.security.full.security.users.model.Users;
import com.example.security.full.security.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public List<Users> GetAllUsers() {
        return usersRepository.findAll();
    }

    public Users AddUser(UsersRequest user) {
        Users newUser = new Users();
        newUser.setName(user.getName());
        newUser.setEnrollment(user.getEnrollment());
        newUser.setBranch(user.getBranch());
        newUser.setSemester(user.getSemester());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        newUser.setRoles(user.getRoles());
        return usersRepository.save(newUser);
    }
}
