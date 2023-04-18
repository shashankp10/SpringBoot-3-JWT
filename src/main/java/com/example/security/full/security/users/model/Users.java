package com.example.security.full.security.users.model;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class Users {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "enrollment")
    private String enrollment;
    @Column(name = "semester", nullable = false)
    private int semester;
    @Column(name = "branch", nullable = false)
    private String branch;
    @Column(name = "roles", nullable = false)
    private String roles;
    @ToString.Exclude
    @Column(name = "password", nullable = false, columnDefinition = "text")
    private String password;


}
