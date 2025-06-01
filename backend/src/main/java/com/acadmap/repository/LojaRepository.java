package com.acadmap.repository;


import com.acadmap.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
}
