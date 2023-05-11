/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.openfoodfact.dao;

import com.mycompany.openfoodfact.model.Marque;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author maria
 */
public class MarqueDAO {    
    
    EntityManager em = JPAUtils.getInstance().getEntityManager();
    
    public void create(Marque marque) {
        em.getTransaction().begin();
        em.persist(marque);
        em.getTransaction().commit();
    }
    
    public Marque findByNom(String nomMarque) {
        TypedQuery<Marque> marqueQuery = em.createNamedQuery("findByMarque", Marque.class);
        marqueQuery.setParameter("nom", nomMarque);
        Marque marque = null;
        try {
            marque = marqueQuery.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {

        }
        return marque;
    }
}
