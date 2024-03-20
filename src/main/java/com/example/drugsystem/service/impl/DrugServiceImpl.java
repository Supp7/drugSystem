package com.example.drugsystem.service.impl;

import com.example.drugsystem.mapper.DrugMapper;
import com.example.drugsystem.pojo.Drug;
import com.example.drugsystem.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public List<Drug> findAllDrugs() {
        return drugMapper.findAllDrugs();
    }

    @Override
    public Drug findDrugById(int id) {
        return drugMapper.findDrugById(id);
    }

    @Override
    public int checkShoppingCartById(int id) {
        return drugMapper.checkShoppingCartById(id);
    }

    @Override
    public String purchaseDrugById(int id) {
        return drugMapper.purchaseDrugById(id);
    }

    @Override
    public List<Drug> shoppingCart() {
        return drugMapper.shoppingCart();
    }

    @Override
    public String removePurchaseById(int id) {
        return drugMapper.removePurchaseById(id);
    }
}
