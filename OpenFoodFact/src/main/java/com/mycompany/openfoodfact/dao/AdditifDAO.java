/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.openfoodfact.dao;

import com.mycompany.openfoodfact.model.Additif;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author maria
 */
public class AdditifDAO {    
    
    EntityManager em = JPAUtils.getInstance().getEntityManager();
    
    public void create(Additif additif) {
        em.getTransaction().begin();
        em.persist(additif);
        em.getTransaction().commit();
    }
    
    public Additif findByNom(String nomAdditif) {
        TypedQuery<Additif> additifQuery = em.createNamedQuery("findByAdditif", Additif.class);
        additifQuery.setParameter("nom", nomAdditif);
        Additif additif = null;
        try {
            additif = additifQuery.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {

        }
        return additif;
    }
}
