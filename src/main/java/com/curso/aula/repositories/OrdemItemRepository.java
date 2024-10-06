package com.curso.aula.repositories;


import com.curso.aula.entities.OrdemItem;
import com.curso.aula.entities.OrdemItemPK;
import com.curso.aula.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemItemRepository extends JpaRepository<OrdemItem, OrdemItemPK> {

}
