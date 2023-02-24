package com.example.demo.controllers;

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

    @RequestMapping(value = "api/users/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(913L);
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("narva@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;
        //return "Vayomer Elohim yeji-or vayeji-or.";// dijo D-os: Haya luz, y hubo luz.
    } // end prueba

    @RequestMapping(value ="api/edituser")
    public Usuario editUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("narva@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;
        //return "Vayomer Elohim yeji-or vayeji-or.";// dijo D-os: Haya luz, y hubo luz.
    } // end prueba


    @RequestMapping(value ="api/del_user/{id}", method = RequestMethod.DELETE)
    public void delUsuario(@PathVariable Long id) {
        usuarioDaoImpl.delete(id);
    }


    @RequestMapping(value = "api/finduser")
    public Usuario findUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("narva@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;
        //return "Vayomer Elohim yeji-or vayeji-or.";// dijo D-os: Haya luz, y hubo luz.
    }

    //@RequestMapping(value = "api/users", method = RequestMethod.GET)
    @GetMapping(value = "api/users")
    public List<Usuario> getUsuarios() {
        return usuarioDaoImpl.getUsuarios();
    }


    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    //RequestBody es para que el objeto Json que se recibe se convierta en un objeto de java
    public void registrarusuario(@RequestBody Usuario usuario) {
        usuarioDaoImpl.regUsuario(usuario);
    }

       /* @RequestMapping(value = "users")
        public List<Usuario> getUsuarios () {
            List<Usuario> usuarios = new ArrayList<Usuario>();
            Usuario usuario = new Usuario();
            usuario.setId(913);
            usuario.setNombre("Alexander");
            usuario.setApellido("Narváez");
            usuario.setEmail("narva@gmail.com");
            usuario.setTelefono("123456789");
            Usuario usuario2 = new Usuario();
            usuario2.setId(144);
            usuario2.setNombre("Juan");
            usuario2.setApellido("Perez");
            usuario2.setEmail("narva@gmail.com");
            usuario2.setTelefono("123456789");
            Usuario usuario3 = new Usuario();
            usuario3.setId(153);
            usuario3.setNombre("Pedro");
            usuario3.setApellido("Jonas");
            usuario3.setEmail("narva@gmail.com");
            usuario3.setTelefono("123456789");
            usuarios.add(usuario);
            usuarios.add(usuario2);
            usuarios.add(usuario3);
            return usuarios;
            //return "Vayomer Elohim yeji-or vayeji-or.";// dijo D-os: Haya luz, y hubo luz.
        } // end prueba*/
}

