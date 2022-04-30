package com.dev.backend.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Role role;


    @Column
    private String userGithub;

    @Column
    private String userDesc;

    @Column
    private String userImg;

    @Builder
    private User(String lastName, String firstName, String password,
                 String email, String phoneNumber, Role role,
                 String userGithub, String userDesc, String userImg) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.userGithub = userGithub;
        this.userDesc = userDesc;
        this.userImg = userImg;
    }


}
