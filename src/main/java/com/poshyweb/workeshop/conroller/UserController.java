package com.poshyweb.workeshop.conroller;

import com.poshyweb.workeshop.domain.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {


    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Louca", "maria@gmail.com", "123456");
        User pedro = new User("2", "pedro Louco", "pedro@gmail.com", "12345");
        List<User> list = new ArrayList<>(Arrays.asList(maria, pedro));
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
