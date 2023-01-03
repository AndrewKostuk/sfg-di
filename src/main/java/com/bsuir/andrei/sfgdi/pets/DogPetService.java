package com.bsuir.andrei.sfgdi.pets;

public class DogPetService implements PetService {
    @Override
    public String getPetType() {
        return "Dogs are the best!";
    }
}
