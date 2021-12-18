/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5_Web.repositorio;

import Reto5_Web.modelo.Chocolate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto5_Web.interfaces.InterfaceChocolate;

/**
 *
 * @author USUARIO
 */
@Repository
public class ChocolateRepositorio {
    @Autowired
    private InterfaceChocolate repository;

    public List<Chocolate> getAll() {
        return repository.findAll();
    }

    public Optional<Chocolate> getClothe(String reference) {
        return repository.findById(reference);
    }
    public Chocolate create(Chocolate chocolate) {
        return repository.save(chocolate);
    }

    public void update(Chocolate chocolate) {
        repository.save(chocolate);
    }
    
    public void delete(Chocolate chocolate) {
        repository.delete(chocolate);
    }
     //Reto 5
    public List<Chocolate> gadgetsByPrice(double precio) {
        return repository.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Chocolate> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
