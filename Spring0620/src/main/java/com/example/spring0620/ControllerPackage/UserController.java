package com.example.spring0620.ControllerPackage;

import com.example.spring0620.domain.UserRepository;
import com.example.spring0620.domain.UserRequestDto;
import com.example.spring0620.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/users/{id}")
    public Long updateUSer(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        userService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/users/{id}")
    public Long deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
