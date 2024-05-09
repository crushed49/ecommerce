package com.example.demo.service.implementation;

import com.example.demo.dto.Itemsdto;
import com.example.demo.entity.Items;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.itemsMapper;
import com.example.demo.repository.ItemsRepo;
import com.example.demo.service.Itemservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Itemserviceimpl implements Itemservice {
    private ItemsRepo itemsRepo;


    @Override
    public Itemsdto createItem(Itemsdto itemsdto) {
        Items items = itemsMapper.maptoItems(itemsdto);
        Items saveditem = itemsRepo.save(items);
        return itemsMapper.maptoItemsdto(saveditem);
    }

    @Override
    public List<Itemsdto> readallItems() {
        List<Items> items = itemsRepo.findAll();
        return items.stream().map((item) -> itemsMapper.maptoItemsdto(item)).collect(Collectors.toList());
    }

    @Override
    public Itemsdto updateItem(Long id, Itemsdto updatedItemdto) {
        Items item = itemsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not found with ID : " + id ));
        if(updatedItemdto.getItem_name() != null){
            item.setItem_name(updatedItemdto.getItem_name());
        }
        if(updatedItemdto.getItem_category() != null) {
            item.setItem_category(updatedItemdto.getItem_category());
        }
        if(updatedItemdto.getItem_price() != null){
            item.setItem_price(updatedItemdto.getItem_price());
        }
        Items updateditem = itemsRepo.save(item);
        return itemsMapper.maptoItemsdto(updateditem);
    }

    @Override
    public void deleteItem(Long id) {
        Items item = itemsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not found with ID : " + id ));
        itemsRepo.deleteById(id);
    }
}
