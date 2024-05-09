package com.example.demo.repository;

import com.example.demo.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepo extends JpaRepository<Items, Long> {
}
