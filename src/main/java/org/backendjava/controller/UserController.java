package org.backendjava.controller;

import jakarta.annotation.PostConstruct;
import org.backendjava.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/")
    public String getMessagem() {
        return "Spring boot is working!";
    }


    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;
    }
    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Fernando");
        userDTO.setCpf("123");
        userDTO.setEndereco("Rua a");
        userDTO.setEmail("fernando@email.com");
        userDTO.setTelefone("123-3333");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Eduardo");
        userDTO2.setCpf("1234");
        userDTO2.setEndereco("Rua b");
        userDTO2.setEmail("eduardo@email.com");
        userDTO2.setTelefone("12345-3333");
        userDTO2.setDataCadastro(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Mariana");
        userDTO3.setCpf("12345");
        userDTO3.setEndereco("Rua c");
        userDTO3.setEmail("mariana@email.com");
        userDTO3.setTelefone("2222-3333");
        userDTO3.setDataCadastro(new Date());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);

    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf) {
        for (UserDTO userFilter : usuarios) {
            if (userFilter.getCpf().equals(cpf)){
                return userFilter;
            }
        }
        return null;
    }

    @PostMapping("/newUser")
    public UserDTO inserir(@RequestBody UserDTO userDTO){
        userDTO.setDataCadastro(new Date());
        usuarios.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/user/{cpf}")
    public boolean remover(@PathVariable String cpf) {
        for (UserDTO userFilter : usuarios) {
            if (userFilter.getCpf().equals(cpf)) {
                usuarios.remove(userFilter);
                return true;
            }
        }
        return false;
    }



}
