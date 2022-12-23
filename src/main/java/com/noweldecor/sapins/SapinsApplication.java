package com.noweldecor.sapins;

import com.noweldecor.sapins.entity.Decoration;
import com.noweldecor.sapins.entity.EnumDecorationType;
import com.noweldecor.sapins.repository.DecorationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class SapinsApplication {

	@Autowired
	DecorationRepository decorationRepository ;

	public static void main(String[] args) {
		SpringApplication.run(SapinsApplication.class, args);
	}

	@PostConstruct
	public void init()
	{
		if(decorationRepository.count() == 0)
		{
			decorationRepository.save(Decoration.builder().nom("Etoile").prixEnCentime(500).poidsEnGram(100).types(Arrays.asList(EnumDecorationType.TETE_DE_SAPIN)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Ange").prixEnCentime(550).poidsEnGram(110).types(Arrays.asList(EnumDecorationType.TETE_DE_SAPIN)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Boule Rouge").prixEnCentime(400).poidsEnGram(50).types(Arrays.asList(EnumDecorationType.FRAGILE, EnumDecorationType.A_ACCROCHER)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Boule Bleu").prixEnCentime(400).poidsEnGram(50).types(Arrays.asList(EnumDecorationType.FRAGILE, EnumDecorationType.A_ACCROCHER)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Boule Vert").prixEnCentime(400).poidsEnGram(50).types(Arrays.asList(EnumDecorationType.FRAGILE, EnumDecorationType.A_ACCROCHER)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Scooby doo special edition de nowel").prixEnCentime(2500).poidsEnGram(132).types(Arrays.asList(EnumDecorationType.INCASSABLE, EnumDecorationType.LUMIERE, EnumDecorationType.SONG, EnumDecorationType.A_ACCROCHER)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Tofu special edition de nowel").prixEnCentime(2000).poidsEnGram(121).types(Arrays.asList(EnumDecorationType.INCASSABLE, EnumDecorationType.LUMIERE, EnumDecorationType.SONG, EnumDecorationType.A_ACCROCHER)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Bouftou special edition de nowel").prixEnCentime(2000).poidsEnGram(122).types(Arrays.asList(EnumDecorationType.INCASSABLE, EnumDecorationType.LUMIERE, EnumDecorationType.SONG, EnumDecorationType.A_ACCROCHER)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Prespic special edition de nowel").prixEnCentime(2000).poidsEnGram(123).types(Arrays.asList(EnumDecorationType.LUMIERE, EnumDecorationType.SONG, EnumDecorationType.A_ACCROCHER)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Morgana de nowel").prixEnCentime(2300).poidsEnGram(143).types(Arrays.asList(EnumDecorationType.A_ACCROCHER)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Annie de nowel").prixEnCentime(2300).poidsEnGram(120).types(Arrays.asList(EnumDecorationType.A_ACCROCHER)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Lumière de sapin LED").prixEnCentime(3000).poidsEnGram(75).types(Arrays.asList(EnumDecorationType.LUMIERE)).build()) ;
			decorationRepository.save(Decoration.builder().nom("Lumière de sapin Halo").prixEnCentime(2200).poidsEnGram(100).types(Arrays.asList(EnumDecorationType.LUMIERE)).build()) ;
		}
	}

}
