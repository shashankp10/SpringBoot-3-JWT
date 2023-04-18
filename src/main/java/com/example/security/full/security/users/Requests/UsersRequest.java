package com.example.security.full.security.users.Requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersRequest {
	
    private String name;
    private String enrollment;
    private String branch;
    private int semester;
    private String password;
    private String roles;
    
}
