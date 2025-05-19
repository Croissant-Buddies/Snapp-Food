package org.croissant;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.*;


    @Entity
    @Table(name = "foods")
    public class Food {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String photo;
        private String bio;
        private String price; // Consider changing to BigDecimal
        private boolean isAvailable;
        private String category;
        private String keyWords;

        @ManyToOne
        @JoinColumn(name = "buyer_id")
        private Buyer buyer;

        public Food() {}

    public Food(String name, String photo, String bio, String price, boolean isAvailable, String category, String keyWords) {
        this.name = name;
        this.photo = photo;
        this.bio = bio;
        this.price = price;
        this.isAvailable = isAvailable;
        this.category = category;
        this.keyWords = keyWords;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}

