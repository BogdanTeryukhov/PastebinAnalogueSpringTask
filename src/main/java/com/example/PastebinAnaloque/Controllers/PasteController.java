package com.example.PastebinAnaloque.Controllers;


import com.example.PastebinAnaloque.Entities.Paste;
import com.example.PastebinAnaloque.Repositories.PasteRepository;
import com.example.PastebinAnaloque.Repositories.PasteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class PasteController {

    @Autowired
    public PasteRepository pasteRepository;

    @Autowired
    public PasteService pasteService;

    public static String linkMaker(Paste paste){
        StringBuilder builder = new StringBuilder();

        boolean isLetter = true;
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            //97 122
            if (isLetter){
                char ch = (char) random.nextInt(97,122);
                builder.append(ch);
                isLetter = false;
            }else{
                builder.append(random.nextInt(0,10));
                isLetter = true;
            }
        }
        System.out.println(builder);
        return builder.toString();
    }


    @PostMapping("/paste/addPaste")
    public String addPaste(@RequestBody Paste paste){
        paste.setHashcode(linkMaker(paste));
        pasteRepository.save(paste);
        return "Paste have been saved";
    }

    @GetMapping("/paste/getAllPublicPastes")
    public List<String> getAllPublicPastes(){
        return pasteService.findPublicPastes();
    }

    @GetMapping("/my-awesome-pastebin.tld/{hashcode}")
    public String getParticularPaste(@PathVariable String hashcode){
        return pasteService.findByHashcode(hashcode);
    }
}
