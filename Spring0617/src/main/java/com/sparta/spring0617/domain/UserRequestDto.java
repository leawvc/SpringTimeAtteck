package com.sparta.spring0617.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRequestDto {

    private int age;
    private int gender;
    private String name;
    private String email;
    private String password;
}
