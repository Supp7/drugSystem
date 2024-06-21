package com.example.drugsystem.service;

import com.example.drugsystem.pojo.Drug;

import java.util.List;

public interface DrugService {

    List<Drug> findAllDrugs();

    Drug findDrugById(int id);

    int checkShoppingCartById(int id);

    String purchaseDrugById(int id);

    List<Drug> shoppingCart();

    String removePurchaseById(int id);

    String uploadImgById(String imgUrl , int id);
}
