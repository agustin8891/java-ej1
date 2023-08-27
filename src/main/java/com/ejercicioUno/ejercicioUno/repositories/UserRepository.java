package com.ejercicioUno.ejercicioUno.repositories;


        import com.ejercicioUno.ejercicioUno.models.User;
        import com.ejercicioUno.ejercicioUno.services.UserService;
        import jakarta.persistence.EntityManager;
        import jakarta.persistence.PersistenceContext;
        import org.springframework.transaction.annotation.Transactional;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
@Transactional
public class UserRepository implements UserService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        List<User> resultado = entityManager.createQuery(query).getResultList();
        return resultado;
    }

    @Override
    public void eliminar(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void registrar(User user) {
        entityManager.merge(user);
    }
}

