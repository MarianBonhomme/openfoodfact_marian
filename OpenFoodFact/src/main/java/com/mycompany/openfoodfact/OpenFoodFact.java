/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.openfoodfact;

import com.mycompany.openfoodfact.dao.JPAUtils;
import com.mycompany.openfoodfact.service.csvFile;

/**
 *
 * @author maria
 */
public class OpenFoodFact {

    public static void main(String[] args) {
        
        csvFile.parseFile();
        
        try {
            JPAUtils.getInstance().closeEntityManager();
        } catch (Exception e) {
            
        }
        
    }
}
