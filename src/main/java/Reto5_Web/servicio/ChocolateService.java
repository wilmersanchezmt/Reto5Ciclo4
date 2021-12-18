/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5_Web.servicio;

import Reto5_Web.modelo.Chocolate;
import Reto5_Web.repositorio.ChocolateRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ChocolateService {
     @Autowired
    private ChocolateRepositorio chocolateRepository;

    public List<Chocolate> getAll() {
        return chocolateRepository.getAll();
    }

   public Optional<Chocolate> getClothe(String reference) {
        return chocolateRepository.getClothe(reference);
    }

    public Chocolate create(Chocolate chocolate) {
        if (chocolate.getReference() == null) {
            return chocolate;
        } else {
            return chocolateRepository.create(chocolate);
        }
    }

    public Chocolate update(Chocolate chocolate) {

        if (chocolate.getReference() != null) {
            Optional<Chocolate> accesoryDb = chocolateRepository.getClothe(chocolate.getReference());
            if (!accesoryDb.isEmpty()) {

                if (chocolate.getCategory() != null) {
                    accesoryDb.get().setCategory(chocolate.getCategory());
                }
                
                if (chocolate.getDescription() != null) {
                    accesoryDb.get().setDescription(chocolate.getDescription());
                }
                if (chocolate.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(chocolate.getPrice());
                }
                if (chocolate.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(chocolate.getQuantity());
                }
                if (chocolate.getPhotography() != null) {
                    accesoryDb.get().setPhotography(chocolate.getPhotography());
                }
                accesoryDb.get().setAvailability(chocolate.isAvailability());
                chocolateRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return chocolate;
            }
        } else {
            return chocolate;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            chocolateRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
     //Reto 5
        public List<Chocolate> gadgetsByPrice(double price) {
            return chocolateRepository.gadgetsByPrice(price);
    }

    //Reto 5
        public List<Chocolate> findByDescriptionLike(String description) {
             return chocolateRepository.findByDescriptionLike(description);
    }
    
}
