/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.openfoodfact.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Categorie categorie;
    @ManyToMany
    private List<Marque> marque;
    private String nom;
    @ManyToOne
    private Nutriscore nutriscore;
    @ManyToMany
    private List<Ingredient> ingredients;
    private int energie;
    private Float graisse;
    private Float sucres;
    private Float fibres;
    private Float protéines;
    private Float sel;
    private Float vitA;
    private Float vitD;
    private Float vitE;
    private Float vitK;
    private Float vitC;
    private Float vitB1;
    private Float vitB2;
    private Float vitPP;
    private Float vitB6;
    private Float vitB9;
    private Float vitB12;
    private Float calcium;
    private Float magnesium;
    private Float iron;
    private Float fer;
    private Float betaCarotene;
    private Boolean huilePalme;
    @ManyToMany
    private List<Additif> additifs;
    @ManyToMany
    private List<Allergene> allergenes;
    
    
}
