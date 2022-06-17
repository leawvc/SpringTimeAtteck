package com.sparta.spring0617.ControllerPackage;

import com.sparta.spring0617.UserService.UserService;
import com.sparta.spring0617.domain.User;
import com.sparta.spring0617.domain.UserRepository;
import com.sparta.spring0617.domain.UserRequestDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Builder
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;


    @PostMapping("/api/users")
    public User createMemo(@RequestBody UserRequestDto requestDto) {
        User user = new User(requestDto);
        return userRepository.save(user);
    }

    @GetMapping("/api/read/{id}")
    public List<User> getUsers(@PathVariable String id) {
        return userRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/update/{id}")
    public Long updateUSer(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        userService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/delete/{id}")
    public Long deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return id;
    }

    @PostMapping("/join")
    public Long join(@RequestBody Map<String, String> user) {
        return userRepository.save(User.builder()
                .email(user.get("email"))
                .password(User.passwordEncoder.encode(user.get("password")))
    }
}