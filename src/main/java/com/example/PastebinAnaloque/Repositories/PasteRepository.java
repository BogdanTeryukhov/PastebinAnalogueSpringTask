package com.example.PastebinAnaloque.Repositories;

import com.example.PastebinAnaloque.Entities.Paste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasteRepository extends JpaRepository<Paste, Long> {
}
