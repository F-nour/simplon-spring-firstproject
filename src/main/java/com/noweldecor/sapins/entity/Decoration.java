package com.noweldecor.sapins.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Decoration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", nullable = false)
    String nom ;

    @Column(name = "prixEnCentime", nullable = false)
    int prixEnCentime ;

    @Column(name = "poidsEnGram", nullable = false)
    int poidsEnGram ;

    @ElementCollection(targetClass = EnumDecorationType.class)
    @CollectionTable(name = "decoration_type", joinColumns = @JoinColumn(name = "decoration_id"))
    @Enumerated(EnumType.ORDINAL)
    List<EnumDecorationType> types ;

    // On va garder ca simple
    // @Column(name = "nbUniteRestantes", nullable = false)
    // int nbUniteRestantes ;

}
