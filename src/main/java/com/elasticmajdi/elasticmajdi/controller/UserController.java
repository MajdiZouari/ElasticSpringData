package com.elasticmajdi.elasticmajdi.controller;

import java.util.List;
import java.util.UUID;

import com.elasticmajdi.elasticmajdi.dto.UserDto;
import com.elasticmajdi.elasticmajdi.model.UserModel;
import com.elasticmajdi.elasticmajdi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userModel) {
        UserDto createdUserModel = userService.addUser(userModel);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> deleteUserAll() {
        userService.deleteUserAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{id}/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") UUID userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @GetMapping("/users/get-by-name/{name}")
    public ResponseEntity<List<UserDto>> findUserByName(@PathVariable("name") String userName) {
        return ResponseEntity.ok(userService.findUserByName(userName));
    }
}
