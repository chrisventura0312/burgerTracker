package com.codingdojo.burgerTracker.models;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="burgers")
public class Burger {
    //=================== Annotations ===================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message="Name must be between 2 and 30 characters")
    private String name;

    @NotNull
    @Size(min = 2, max = 30, message="Restaurant must be between 2 and 30 characters")
    private String restaurant;

    @NotNull
    @Min(value = 1, message="Rating must be between 1 and 5")
    @Max(value = 5, message="Rating must be between 1 and 5")
    private Integer rating;

    @NotNull
    @Size(min = 10, max = 200, message="Notes must be between 10 and 200 characters")
    private String notes;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    //=================== Constructors ===================
    public Burger() {
    }
    //=================== Getters ===================
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public Integer getRating() {
        return rating;
    }

    public String getNotes() {
        return notes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    //=================== Setters ===================
    public void setName(String name) {
        this.name = name;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setRating(Integer rating) {
        if (rating == null || rating.toString().isEmpty()) {
            this.rating = null;
        } else {
            this.rating = rating;
        }
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //=================== PrePersist/PreUpdate ===================
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    //=================== Methods ===================
    public void updateBurger(String name, String restaurant, Integer rating, String notes) {
        this.name = name;
        this.restaurant = restaurant;
        this.rating = rating;
        this.notes = notes;
    }

    public void deleteBurger() {
        this.name = null;
        this.restaurant = null;
        this.rating = null;
        this.notes = null;
    }




}
