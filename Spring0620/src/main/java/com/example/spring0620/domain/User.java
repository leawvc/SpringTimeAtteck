package com.example.spring0620.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class User extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private int gender;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    public User(int age, int gender, String name, String email) {
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.email = email;
    }

    public User(UserRequestDto requestDto) {
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
    }

    public void update(UserRequestDto requestDto) {
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
    }
}