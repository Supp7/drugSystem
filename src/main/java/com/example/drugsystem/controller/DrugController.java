package com.example.drugsystem.controller;

import com.example.drugsystem.pojo.Drug;
import com.example.drugsystem.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    private DrugService drugService;


    @GetMapping("")
    public List<Drug> findAllDrug(){
        return drugService.findAllDrugs();

    }

    @GetMapping("/{id}")
    public Drug findDrugById(@PathVariable("id")int id){
        return drugService.findDrugById(id);
    }
    @GetMapping("/checkShoppingCart/{id}")
    public int checkShoppingCartById(@PathVariable("id")int id){
        return drugService.checkShoppingCartById(id);
    }

    @GetMapping("/purchase/{id}")
    public String purchaseDrugById(@PathVariable("id")int id){
        return drugService.purchaseDrugById(id);
    }


    @GetMapping("/shoppingCart")
    public List<Drug> shoppingCart(){
        return drugService.shoppingCart();
    }

    @GetMapping("/removePurchase/{id}")
    public String removePurchaseById(@PathVariable("id")int id){
        return drugService.removePurchaseById(id);
    }



}
