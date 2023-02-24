package com.example.demo.dao;

import jakarta.persistence.Query;
import com.example.demo.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        try {
            String hql = "FROM Usuario";
            Query query = entityManager.createQuery(hql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error: ",e );
        }
    }
    @Override
    public void regUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void delete(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);

    }
}
