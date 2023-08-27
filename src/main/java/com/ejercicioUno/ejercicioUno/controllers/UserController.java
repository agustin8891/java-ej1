package com.ejercicioUno.ejercicioUno.controllers;


import com.ejercicioUno.ejercicioUno.models.User;
import com.ejercicioUno.ejercicioUno.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        userService.eliminar(id);
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody User user) {
        userService.registrar(user);
    }
}