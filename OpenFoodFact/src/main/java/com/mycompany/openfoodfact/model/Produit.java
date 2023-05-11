/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.openfoodfact.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToMany
    private List<Marque> marques = new ArrayList<>();

    private String nom;

    @Enumerated(EnumType.STRING)
    private Nutriscore nutriscore;

    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    private Float energie;
    private Float graisse;
    private Float sucres;
    private Float fibres;
    private Float proteines;
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
    private List<Additif> additifs = new ArrayList<>();

    @ManyToMany
    private List<Allergene> allergenes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Marque> getMarque() {
        return marques;
    }

    public void setMarque(List<Marque> marques) {
        this.marques = marques;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Nutriscore getNutriscore() {
        return nutriscore;
    }

    public void setNutriscore(Nutriscore nutriscore) {
        this.nutriscore = nutriscore;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Float getEnergie() {
        return energie;
    }

    public void setEnergie(Float energie) {
        this.energie = energie;
    }

    public Float getGraisse() {
        return graisse;
    }

    public void setGraisse(Float graisse) {
        this.graisse = graisse;
    }

    public Float getSucres() {
        return sucres;
    }

    public void setSucres(Float sucres) {
        this.sucres = sucres;
    }

    public Float getFibres() {
        return fibres;
    }

    public void setFibres(Float fibres) {
        this.fibres = fibres;
    }

    public Float getProteines() {
        return proteines;
    }

    public void setProteines(Float proteines) {
        this.proteines = proteines;
    }

    public Float getSel() {
        return sel;
    }

    public void setSel(Float sel) {
        this.sel = sel;
    }

    public Float getVitA() {
        return vitA;
    }

    public void setVitA(Float vitA) {
        this.vitA = vitA;
    }

    public Float getVitD() {
        return vitD;
    }

    public void setVitD(Float vitD) {
        this.vitD = vitD;
    }

    public Float getVitE() {
        return vitE;
    }

    public void setVitE(Float vitE) {
        this.vitE = vitE;
    }

    public Float getVitK() {
        return vitK;
    }

    public void setVitK(Float vitK) {
        this.vitK = vitK;
    }

    public Float getVitC() {
        return vitC;
    }

    public void setVitC(Float vitC) {
        this.vitC = vitC;
    }

    public Float getVitB1() {
        return vitB1;
    }

    public void setVitB1(Float vitB1) {
        this.vitB1 = vitB1;
    }

    public Float getVitB2() {
        return vitB2;
    }

    public void setVitB2(Float vitB2) {
        this.vitB2 = vitB2;
    }

    public Float getVitPP() {
        return vitPP;
    }

    public void setVitPP(Float vitPP) {
        this.vitPP = vitPP;
    }

    public Float getVitB6() {
        return vitB6;
    }

    public void setVitB6(Float vitB6) {
        this.vitB6 = vitB6;
    }

    public Float getVitB9() {
        return vitB9;
    }

    public void setVitB9(Float vitB9) {
        this.vitB9 = vitB9;
    }

    public Float getVitB12() {
        return vitB12;
    }

    public void setVitB12(Float vitB12) {
        this.vitB12 = vitB12;
    }

    public Float getCalcium() {
        return calcium;
    }

    public void setCalcium(Float calcium) {
        this.calcium = calcium;
    }

    public Float getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(Float magnesium) {
        this.magnesium = magnesium;
    }

    public Float getIron() {
        return iron;
    }

    public void setIron(Float iron) {
        this.iron = iron;
    }

    public Float getFer() {
        return fer;
    }

    public void setFer(Float fer) {
        this.fer = fer;
    }

    public Float getBetaCarotene() {
        return betaCarotene;
    }

    public void setBetaCarotene(Float betaCarotene) {
        this.betaCarotene = betaCarotene;
    }

    public Boolean getHuilePalme() {
        return huilePalme;
    }

    public void setHuilePalme(Boolean huilePalme) {
        this.huilePalme = huilePalme;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(List<Additif> additifs) {
        this.additifs = additifs;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

}
