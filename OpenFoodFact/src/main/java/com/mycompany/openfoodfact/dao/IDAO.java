/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.openfoodfact.dao;

import java.util.List;

/**
 *
 * @author maria
 */
public interface IDAO<T> {
    public T create (T t);
    public List<T> readAll();
    public T read(Integer id);
    public void update(T t);
    public void delete(T t);
}
