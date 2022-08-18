package com.poshyweb.workeshop.dto;

import com.poshyweb.workeshop.domain.entity.User;

import java.io.Serializable;
import java.util.Objects;

public class UserDto implements Serializable {
    static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;

    public UserDto() {
    }

    public UserDto(User obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(nome, userDto.nome) && Objects.equals(email, userDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
