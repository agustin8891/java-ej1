package com.ejercicioUno.ejercicioUno.services;

        import com.ejercicioUno.ejercicioUno.models.User;

        import java.util.List;

public interface UserService {

    List<User> getUsers();

    void eliminar(Long id);

    void registrar(User usuario);

}
