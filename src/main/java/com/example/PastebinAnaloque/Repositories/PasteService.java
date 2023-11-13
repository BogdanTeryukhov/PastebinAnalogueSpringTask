package com.example.PastebinAnaloque.Repositories;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PasteService {
    String findByHashcode(String hashcode);
    List<String> findPublicPastes();
}
