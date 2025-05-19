package org.croissant;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buyers")
public class Buyer extends User {
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Food> cart = new ArrayList<>();

    public Buyer() {}

    public Buyer(String name, String number, String email, String password, String role, String address) {
        super(name, number, email, password, role);
        this.address = address;
    }

}