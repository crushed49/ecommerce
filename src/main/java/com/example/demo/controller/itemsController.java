package com.example.demo.controller;

import com.example.demo.dto.Itemsdto;
import com.example.demo.entity.Items;
import com.example.demo.service.Itemservice;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class itemsController {
    private Itemservice itemservice;

    @PostMapping("/create")
    public ResponseEntity<Itemsdto> createItem(@RequestBody Itemsdto itemsdto){
        Itemsdto createdItem = itemservice.createItem(itemsdto);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Itemsdto>> getallItems(){
        List<Itemsdto> items = itemservice.readallItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Itemsdto> updateItem(@RequestBody Long id, Itemsdto itemsdto){
        Itemsdto updatedItem = itemservice.updateItem(id, itemsdto);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteItem(@RequestBody Long id){
        itemservice.deleteItem(id);
        return new ResponseEntity<>("Item with ID " + id + " deleted successfully", HttpStatus.OK);
    }
}
