/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.openfoodfact.dao;

import com.mycompany.openfoodfact.model.Categorie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
/**
 *
 * @author maria
 */
public class CategorieDAO {

    EntityManager em = JPAUtils.getInstance().getEntityManager();

    public void create(Categorie cate) {
        em.getTransaction().begin();
        em.persist(cate);
        em.getTransaction().commit();
    }

    public Categorie findByNom(String nomCategorie) {
        TypedQuery<Categorie> categoryQuery = em.createNamedQuery("findByCategorie", Categorie.class);
        categoryQuery.setParameter("nom", nomCategorie);
        Categorie categorie = null;
        try {
            categorie = categoryQuery.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {

        }
        return categorie;
    }
}
