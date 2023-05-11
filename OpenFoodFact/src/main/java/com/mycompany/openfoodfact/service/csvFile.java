/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.openfoodfact.service;

import com.mycompany.openfoodfact.OpenFoodFact;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.openfoodfact.dao.ProduitDAO;
import com.mycompany.openfoodfact.dao.MarqueDAO;
import com.mycompany.openfoodfact.dao.AdditifDAO;
import com.mycompany.openfoodfact.dao.AllergeneDAO;
import com.mycompany.openfoodfact.dao.CategorieDAO;
import com.mycompany.openfoodfact.dao.IngredientDAO;
import com.mycompany.openfoodfact.model.Additif;
import com.mycompany.openfoodfact.model.Allergene;
import com.mycompany.openfoodfact.model.Categorie;
import com.mycompany.openfoodfact.model.Ingredient;
import com.mycompany.openfoodfact.model.Marque;
import com.mycompany.openfoodfact.model.Nutriscore;
import com.mycompany.openfoodfact.model.Produit;
/**
 *
 * @author maria
 */
public class csvFile {

    public static void parseFile() {
        Path path = Paths.get("C:\\Users\\maria\\OneDrive\\Documents\\NetBeansProjects\\openfoodfact_marian\\conception\\open-food-facts.csv");
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            int compteur = 0;

            ProduitDAO produitDao = new ProduitDAO();
            CategorieDAO categorieDao = new CategorieDAO();
            MarqueDAO marqueDao = new MarqueDAO();
            IngredientDAO ingredientDao = new IngredientDAO();
            AllergeneDAO allergeneDao = new AllergeneDAO();
            AdditifDAO additifDao = new AdditifDAO();

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (compteur == 0) {
                    compteur++;
                    continue;
                }

                String[] column = line.split("\\|");
//                Remplace ";" par "," pour trier split correctement + supprime "_" et "*"
                for (int i = 0; i < column.length; i++) {
                    column[i] = column[i].replaceAll(";", ",").replaceAll("-", "").replaceAll("_", "").replace("\\*", "");
                }

                Produit produit = new Produit();

//                Categorie                
                Categorie categorie = categorieDao.findByNom(column[0].trim());
                if (categorie == null) {
                    categorie = new Categorie();
                    categorie.setNom(column[0].trim());
                    categorieDao.create(categorie);
                }
                produit.setCategorie(categorie);

//                Marque
                String[] colMarque = column[1].split(",");
                for (int i = 0; i < colMarque.length; i++) {
                    Marque marque = marqueDao.findByNom(colMarque[i].trim());
                    if (marque == null) {
                        marque = new Marque();
                        marque.setNom(colMarque[i].trim());
                        marqueDao.create(marque);
                    }
                    produit.getMarque().add(marque);
                }

//                Nom
                produit.setNom(column[2]);

//                Nutriscore
                if (column[3].contains("a")) {
                    produit.setNutriscore(Nutriscore.A);
                } else if (column[3].contains("b")) {
                    produit.setNutriscore(Nutriscore.B);
                } else if (column[3].contains("c")) {
                    produit.setNutriscore(Nutriscore.C);
                } else if (column[3].contains("d")) {
                    produit.setNutriscore(Nutriscore.D);
                } else if (column[3].contains("e")) {
                    produit.setNutriscore(Nutriscore.E);
                }

//                Ingredients
                String[] colIngredient = column[4].split(",");
                for (int i = 0; i < colIngredient.length; i++) {
                    Ingredient ingredient = ingredientDao.findByNom(colIngredient[i].trim());
                    if (ingredient == null) {
                        ingredient = new Ingredient();
                        ingredient.setNom(colIngredient[i].trim());
                        ingredientDao.create(ingredient);
                    }
                    produit.getIngredients().add(ingredient);
                }

//                Energie --> Huile de Palme
                if (column[5] != "") {
                    produit.setEnergie(Float.valueOf(column[5]));
                } else {
                    produit.setEnergie(null);
                }

                if (column[6] != "") {
                    produit.setGraisse(Float.valueOf(column[6]));
                } else {
                    produit.setGraisse(null);
                }

                if (column[7] != "") {
                    produit.setSucres(Float.valueOf(column[7]));
                } else {
                    produit.setSucres(null);
                }

                if (column[8] != "") {
                    produit.setFibres(Float.valueOf(column[8]));
                } else {
                    produit.setFibres(null);
                }

                if (column[9] != "") {
                    produit.setProteines(Float.valueOf(column[9]));
                } else {
                    produit.setProteines(null);
                }

                if (column[10] != "") {
                    produit.setSel(Float.valueOf(column[10]));
                } else {
                    produit.setSel(null);
                }

                if (column[11] != "") {
                    produit.setVitA(Float.valueOf(column[11]));
                } else {
                    produit.setVitA(null);
                }

                if (column[12] != "") {
                    produit.setVitD(Float.valueOf(column[12]));
                } else {
                    produit.setVitD(null);
                }

                if (column[13] != "") {
                    produit.setVitE(Float.valueOf(column[13]));
                } else {
                    produit.setVitE(null);
                }

                if (column[14] != "") {
                    produit.setVitK(Float.valueOf(column[14]));
                } else {
                    produit.setVitK(null);
                }

                if (column[15] != "") {
                    produit.setVitC(Float.valueOf(column[15]));
                } else {
                    produit.setVitC(null);
                }

                if (column[16] != "") {
                    produit.setVitB1(Float.valueOf(column[16]));
                } else {
                    produit.setVitB1(null);
                }

                if (column[17] != "") {
                    produit.setVitB2(Float.valueOf(column[17]));
                } else {
                    produit.setVitB2(null);
                }

                if (column[18] != "") {
                    produit.setVitPP(Float.valueOf(column[18]));
                } else {
                    produit.setVitPP(null);
                }

                if (column[19] != "") {
                    produit.setVitB6(Float.valueOf(column[19]));
                } else {
                    produit.setVitB6(null);
                }

                if (column[20] != "") {
                    produit.setVitB9(Float.valueOf(column[20]));
                } else {
                    produit.setVitB9(null);
                }

                if (column[21] != "") {
                    produit.setVitB12(Float.valueOf(column[21]));
                } else {
                    produit.setVitB12(null);
                }

                if (column[22] != "") {
                    produit.setCalcium(Float.valueOf(column[22]));
                } else {
                    produit.setCalcium(null);
                }

                if (column[23] != "") {
                    produit.setMagnesium(Float.valueOf(column[23]));
                } else {
                    produit.setMagnesium(null);
                }

                if (column[24] != "") {
                    produit.setIron(Float.valueOf(column[24]));
                } else {
                    produit.setIron(null);
                }

                if (column[25] != "") {
                    produit.setFer(Float.valueOf(column[25]));
                } else {
                    produit.setFer(null);
                }

                if (column[26] != "") {
                    produit.setBetaCarotene(Float.valueOf(column[26]));
                } else {
                    produit.setBetaCarotene(null);
                }

                if (column[27].trim().equals("1")) {
                    produit.setHuilePalme(true);
                } else {
                    produit.setHuilePalme(false);
                }

//                Allergenes
                String[] colAllergene = column[28].split(",");
                for (int i = 0; i < colAllergene.length; i++) {
                    Allergene allergene = allergeneDao.findByNom(colAllergene[i].trim());
                    if (allergene == null) {
                        allergene = new Allergene();
                        allergene.setNom(colAllergene[i].trim());
                        allergeneDao.create(allergene);
                    }
                    produit.getAllergenes().add(allergene);
                }

//                Additifs
                String[] colAdditifs = column[29].split(",");
                for (int i = 0; i < colAdditifs.length; i++) {
                    Additif additif = additifDao.findByNom(colAdditifs[i].trim());
                    if (additif == null) {
                        additif = new Additif();
                        additif.setNom(colAdditifs[i].trim());
                        additifDao.create(additif);
                    }
                    produit.getAdditifs().add(additif);
                }

                produitDao.create(produit);

                compteur++;
                if (compteur > 500) {
                    break;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(OpenFoodFact.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
