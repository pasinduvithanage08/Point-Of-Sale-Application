package com.pos_application.pos.repo;

import com.pos_application.pos.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface itemRepo extends JpaRepository<Item, Integer> {
    List<Item> findAllByItemNameEqualsAndActive(String itemName, boolean active);

    List<Item> findAllByActiveEquals(boolean activeStatus);
    Page<Item> findAllByActiveEquals(boolean activeStatus, Pageable pageable);

    int countAllByActive(boolean active);
}
