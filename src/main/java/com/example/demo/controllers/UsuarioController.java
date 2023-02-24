package com.example.demo.controllers;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UsuarioDao;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(value = "/usuario/")
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDaoImpl;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value ="api/del_user/{id}", method = RequestMethod.DELETE)
    public void delUsuario(@PathVariable Long id) {
        usuarioDaoImpl.delete(id);
    }

    @GetMapping(value = "api/users")
    public List<Usuario> getUsuarios() {
        return userDao.getUsuarios();
    }

    @PostMapping(value = "api/findByEmail")
    public Usuario findByEmail(@RequestBody String email) {
        return userDao.findByEmail(email);
    }

    @PostMapping(value = "api/saveUsuario")
    public void registrarUsuario(@RequestBody Usuario usuario) {
        userDao.registrarUsuario(usuario);
    }
    @DeleteMapping(value = "api/deleteUsuario/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        userDao.delete(id);
    }


}

