package com.example.demo.mapper;

import com.example.demo.dto.Itemsdto;
import com.example.demo.entity.Items;

public class itemsMapper {
    public static Itemsdto maptoItemsdto(Items items){
        return new Itemsdto(items.getItem_id(),items.getItem_name(), items.getItem_price(), items.getItem_category());
    }

    public static Items maptoItems(Itemsdto itemsdto){
        return new Items(itemsdto.getItem_id(), itemsdto.getItem_name(), itemsdto.getItem_price(), itemsdto.getItem_category());
    }
}
