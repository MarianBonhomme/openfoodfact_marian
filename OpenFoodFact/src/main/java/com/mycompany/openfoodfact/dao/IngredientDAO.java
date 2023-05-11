/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.openfoodfact.dao;

import com.mycompany.openfoodfact.model.Ingredient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author maria
 */
public class IngredientDAO {    
    
    EntityManager em = JPAUtils.getInstance().getEntityManager();
    
    public void create(Ingredient ingredient) {
        em.getTransaction().begin();
        em.persist(ingredient);
        em.getTransaction().commit();
    }
    
    public Ingredient findByNom(String nomIngredient) {
        TypedQuery<Ingredient> ingredientQuery = em.createNamedQuery("findByIngredient", Ingredient.class);
        ingredientQuery.setParameter("nom", nomIngredient);
        Ingredient ingredient = null;
        try {
            ingredient = ingredientQuery.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {

        }
        return ingredient;
    }
}
