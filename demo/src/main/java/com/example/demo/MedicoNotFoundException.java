package com.example.demo;

public class MedicoNotFoundException extends RuntimeException {

    MedicoNotFoundException(Long id) {
        super("Could not find medic " + id);
    }
}