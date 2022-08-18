package com.poshyweb.workeshop.server;

import com.poshyweb.workeshop.domain.entity.User;
import com.poshyweb.workeshop.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServer {
    private Logger logger = LoggerFactory.getLogger(UserServer.class);
    @Autowired
    private UserRepository repository;

    public User create(User user) {
        if (user.getNome().equals("") && user.getEmail().equals("") && user.getSenha().equals("")) {
            logger.info("Cara Salvou mais nao era pra salvar");
            return null;
        }else {
            logger.info("Cara Salvou !");
            return repository.save(user);
        }
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
