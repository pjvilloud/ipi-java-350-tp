package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmployeTest {

    @Test
    //Embauché en 2020. On est en 2020 : 0 an ancienneté
    public void testNombreAnneeAncienneteNow(){
        //Given
        LocalDate now = LocalDate.now();
        Employe employe = new Employe();
        employe.setDateEmbauche(now);

        //When
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(0);
    }

    @Test
    //Embauché en 2019. On est en 2020 : 1 an ancienneté
    public void testNombreAnneeAncienneteNMoins1(){
        //Given
        LocalDate nMoins1 = LocalDate.now().minusYears(1);
        Employe employe = new Employe();
        employe.setDateEmbauche(nMoins1);

        //When
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(1);
    }

    @Test
    //Embauché en 2021. On est en 2020 : 0 an ancienneté
    public void testNombreAnneeAncienneteNPlus1(){
        //Given
        LocalDate nPlus1 = LocalDate.now().plusYears(1);
        Employe employe = new Employe();
        employe.setDateEmbauche(nPlus1);

        //When
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(0);
    }

    @Test
    //Embauché en 2021. On est en 2020 : 0 an ancienneté
    public void testNombreAnneeAncienneteNull(){
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(null);

        //When
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(0);
    }

}
