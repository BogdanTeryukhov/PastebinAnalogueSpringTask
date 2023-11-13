package com.example.PastebinAnaloque.Services;

import com.example.PastebinAnaloque.Entities.Paste;
import com.example.PastebinAnaloque.Enums.Access;
import com.example.PastebinAnaloque.Repositories.PasteRepository;
import com.example.PastebinAnaloque.Repositories.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasteServiceImpl implements PasteService {

    @Autowired
    PasteRepository pasteRepository;
    @Override
    public String findByHashcode(String hashcode) {
        List<Paste> pasteList = pasteRepository.findAll();
        for (Paste paste: pasteList) {
            if (paste.getHashcode().equals(hashcode)){
                return paste.getPaste();
            }
        }
        return "No paste have been found";
    }

    @Override
    public List<String> findPublicPastes() {
        List<Paste> pasteList = pasteRepository.findAll().stream()
                .filter(x -> x.getAccess().equals(Access.PUBLIC))
                .limit(10)
                .toList();

        List<String> result = new ArrayList<>();
        for (Paste paste: pasteList) {
            result.add(paste.getPaste());
        }
        return result;
    }
}
