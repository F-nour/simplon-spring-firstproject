package com.noweldecor.sapins.controller;

import com.noweldecor.sapins.entity.BonDeCommande;
import com.noweldecor.sapins.entity.Decoration;
import com.noweldecor.sapins.entity.EnumDecorationType;
import com.noweldecor.sapins.entity.Sapin;
import com.noweldecor.sapins.repository.BonDeCommandeRepository;
import com.noweldecor.sapins.repository.DecorationRepository;
import com.noweldecor.sapins.repository.SapinRepository;
import org.hibernate.metamodel.mapping.internal.NoGeneratedValueResolver;
import org.hibernate.metamodel.mapping.internal.NoValueGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class SapinController {

    @Autowired
    private SapinRepository sapinRepository;

    @Autowired
    private DecorationRepository decorationRepository;

    @Autowired
    private BonDeCommandeRepository bonDeCommandeRepository;

    @GetMapping(path = "sapin/get")
    public Sapin getSapin(@RequestParam Long id) {
        Optional<Sapin> sapinOption = sapinRepository.findById(id);
        return sapinOption.orElse(null);
    }

    @PostMapping(path = "sapin/create")
    public Long addSapin() {
        sapinRepository.save(Sapin.builder().vendu(false).build());
        Long nbSapins = sapinRepository.count();
        return nbSapins;
    }

    @PostMapping(path = "sapin/addDecoration")
    public boolean addDecoration(@RequestParam Long sapinId, @RequestParam Long decoId) {
        Optional<Sapin> sapinOption = sapinRepository.findById(sapinId);
        if (sapinOption.isEmpty()) return false;

        Sapin sapin = sapinOption.get();
        if (sapin.isVendu()) return false;

        Optional<Decoration> decoOption = decorationRepository.findById(decoId);
        if (decoOption.isEmpty()) return false;

        Decoration decoration = decoOption.get();
        sapin.getDecorations().add(decoration);
        sapinRepository.save(sapin);
        return true;
    }

    @PostMapping(path = "sapin/vente")
    public BonDeCommande vente(@RequestParam Long sapinId) {
        Optional<Sapin> sapinOption = sapinRepository.findById(sapinId);
        if (sapinOption.isEmpty()) return null;

        Sapin sapin = sapinOption.get();
        if (sapin.isVendu()) return null;

        sapin.setVendu(true);
        sapinRepository.save(sapin);
        int coutTotal = 0;
        int poidTotal = 0;
        for (Decoration decoration : sapin.getDecorations()) {
            coutTotal += decoration.getPrixEnCentime();
            poidTotal += decoration.getPoidsEnGram();
        }
        return bonDeCommandeRepository.save(BonDeCommande.builder().coutTotal(coutTotal).PoidTotal(poidTotal).adresse("Nour, bègles").build());
    }

    @GetMapping(path="sapin/commande/get/{id}")
    public BonDeCommande getCommande(@PathVariable long id) {
        Optional<BonDeCommande> commandeOption = bonDeCommandeRepository.findById(id);
        return commandeOption.orElse(null);
    }
}
