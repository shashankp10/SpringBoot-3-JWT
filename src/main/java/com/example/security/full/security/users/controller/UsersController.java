package com.example.security.full.security.users.controller;

import com.example.security.full.security.users.Requests.UsersRequest;
import com.example.security.full.security.users.model.Users;
import com.example.security.full.security.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/all")
    public List<Users> GetUsers() {
        return usersService.GetAllUsers();
    }

    @PreAuthorize(value = "hasRole('ROLE_USER')")
    @PostMapping("/")
    public Users GetUsers(@RequestBody UsersRequest user) {
        return usersService.AddUser(user);
    }

    @GetMapping("/print")
    public String dummpy() {
    	return "Secured end-point required token";
    }
}
