package com.sparta.spring0617.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(nullable = false)
    private String password;

    public User(int age, int gender, String name, String email, String password) {
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(UserRequestDto requestDto) {
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.password = requestDto.getPassword();
    }

    public static Object builder() {
    }

    public interface passwordEncoder {
        static String encode(CharSequence rawPassword);
        boolean matches(CharSequence rawPassword, String encodedPassword);
        default boolean upgradeEncoding(String encodedPassword) { return false; };
    }

    public void update(UserRequestDto requestDto) {
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.password = requestDto.getPassword();
    }
}
