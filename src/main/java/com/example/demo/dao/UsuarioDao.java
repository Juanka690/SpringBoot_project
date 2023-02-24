package com.example.demo.dao;
import com.example.demo.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    void delete(Long id) ;

    List<Usuario>getUsuarios();

    void regUsuario(Usuario usuario);

}
