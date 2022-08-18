package com.poshyweb.workeshop.conroller;

import com.poshyweb.workeshop.domain.entity.User;
import com.poshyweb.workeshop.dto.UserDto;
import com.poshyweb.workeshop.server.UserServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(User.class);

    @Autowired
    private UserServer server;

    @PostMapping(value = "/create")
    public ResponseEntity<User> create(@RequestBody @Validated User user) {
        try {
            logger.info("Cadastrado no sistema !");
            return ResponseEntity.status(HttpStatus.OK).body(server.create(user));
        } catch (Exception e) {
            logger.info("Não foi cadastrado no sistema !");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> all = server.findAll();
        List<UserDto> userDtoList = all.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(userDtoList);
    }
}
