package com.example.demo.service;

import com.example.demo.dto.Itemsdto;

import java.util.List;

public interface Itemservice {
    Itemsdto createItem(Itemsdto itemsdto);
    List<Itemsdto> readallItems();
    Itemsdto updateItem(Long id, Itemsdto updatedItemdto);
    void deleteItem(Long id);
}
