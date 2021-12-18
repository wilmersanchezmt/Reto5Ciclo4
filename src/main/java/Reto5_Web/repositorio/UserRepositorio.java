/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5_Web.repositorio;

import Reto5_Web.interfaces.InterfaceUser;
import Reto5_Web.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase User repositorio
 * @author Wilmer Andres Sanchez
 */
@Repository
public class UserRepositorio {
    @Autowired
    /**
      * Mmetodo privado inyeccion de dependecia interface user
      */
    private InterfaceUser userRepository;
    /**
      * metodo publico para obtiene la lista de usuarios
      * @return la lista de usuarios
      */
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }
    /**
        * metodo para obtener un usuario por id
        * @param id 
        * @return el usuario
        */
    public Optional<User> getUser(int idi) {
        return userRepository.findById(idi);
    }
    /**
     * memtodo para crear un usuario
     * @param user 
     * @return el usuario creado
     */
    public User create(User user) {
        return userRepository.save(user);
    }
    /**
     * metodo para actualizar un usuario
     * @param user 
     */
    public void update(User user) {
        userRepository.save(user);
    }
    /**
     * metodo para eliminar un usuario
     * @param user 
     */
    public void delete(User user) {
        userRepository.delete(user);
    }
    /**
     * Metodo para verificar si existe un correo
     * @param email
     * @return el email del usuario
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    /**
     * Metodo para que un usuario se autentique
     * @param email
     * @param password
     * @return el correo y la contraseña
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    /**
      * Metodo par obetener el id maximo
      * @return el usuario con el id maximo
      */
    public Optional<User> lastUserId(){
        return userRepository.findTopByOrderByIdDesc();
    }
    /**
      * Metodo para el mes de cumpleaños de un usuario
      * @param monthBirthtDay
      * @return el mes del cumpleaños
      */
    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepository.findByMonthBirthtDay(monthBirthtDay);
    }
    /**
     * fin de la clase
     */
}
