package com.green.eduuser.controller;

import com.green.eduuser.dto.UserDto;
import com.green.eduuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userNo}")
    public ResponseEntity<UserDto> getUserByuserNo(@PathVariable("userNo") String userNo) {
        UserDto userDto = userService.getUserByUserNo(userNo);
        return ResponseEntity.ok(userDto);
    }

}
