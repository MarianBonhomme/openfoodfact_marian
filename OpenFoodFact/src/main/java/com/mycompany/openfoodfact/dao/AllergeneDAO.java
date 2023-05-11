/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.openfoodfact.dao;

import com.mycompany.openfoodfact.model.Allergene;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author maria
 */
public class AllergeneDAO {    
    
    EntityManager em = JPAUtils.getInstance().getEntityManager();
    
    public void create(Allergene allergene) {
        em.getTransaction().begin();
        em.persist(allergene);
        em.getTransaction().commit();
    }
  
    public Allergene findByNom(String nomAllergene) {
        TypedQuery<Allergene> allergeneQuery = em.createNamedQuery("findByAllergene", Allergene.class);
        allergeneQuery.setParameter("nom", nomAllergene);
        Allergene allergene = null;
        try {
            allergene = allergeneQuery.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {

        }
        return allergene;
    }
    
}
