package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Itemsdto {
    private Long Item_id;
    private String Item_name;
    private Long Item_price;
    private String Item_category;
}
