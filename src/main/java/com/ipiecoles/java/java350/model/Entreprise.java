package com.ipiecoles.java.java350.model;

import java.time.LocalDate;
import java.util.*;

public final class Entreprise {
    public static final Double SALAIRE_BASE = 1521.22;
    public static final Integer NB_CONGES_BASE = 25;
    public static final Double INDICE_PRIME_BASE = 0.3;
    public static final Double INDICE_PRIME_MANAGER = 1.7;
    public static final Double PRIME_ANCIENNETE = 100d;
    public static final Integer PERFORMANCE_BASE = 1;
    public static final Integer NB_JOURS_MAX_FORFAIT = 218;
    private static final double PRIME_BASE = 1000d;

    public static final Map<NiveauEtude, Double> COEFF_SALAIRE_ETUDES = new EnumMap<>(NiveauEtude.class);
    private static final Map<Integer, LocalDate> datePaque = new HashMap<>();

    private Entreprise() {

    }

    static {
        COEFF_SALAIRE_ETUDES.put(NiveauEtude.CAP, 1.0);
        COEFF_SALAIRE_ETUDES.put(NiveauEtude.BAC, 1.1);
        COEFF_SALAIRE_ETUDES.put(NiveauEtude.BTS_IUT, 1.2);
        COEFF_SALAIRE_ETUDES.put(NiveauEtude.LICENCE, 1.2);
        COEFF_SALAIRE_ETUDES.put(NiveauEtude.MASTER, 1.4);
        COEFF_SALAIRE_ETUDES.put(NiveauEtude.INGENIEUR, 1.6);
        COEFF_SALAIRE_ETUDES.put(NiveauEtude.DOCTORAT, 1.7);

        datePaque.put(2019, LocalDate.of(2019, 4, 21));
        datePaque.put(2020, LocalDate.of(2020, 4, 12));
        datePaque.put(2021, LocalDate.of(2021, 4, 4));
        datePaque.put(2022, LocalDate.of(2022, 4, 17));
        datePaque.put(2023, LocalDate.of(2023, 4, 9));
        datePaque.put(2024, LocalDate.of(2024, 3, 31));
        datePaque.put(2025, LocalDate.of(2025, 4, 20));
        datePaque.put(2026, LocalDate.of(2026, 4, 5));
        datePaque.put(2027, LocalDate.of(2027, 3, 28));
        datePaque.put(2028, LocalDate.of(2028, 4, 16));
        datePaque.put(2029, LocalDate.of(2029, 4, 1));
        datePaque.put(2030, LocalDate.of(2030, 4, 21));
        datePaque.put(2031, LocalDate.of(2031, 4, 13));
        datePaque.put(2032, LocalDate.of(2032, 3, 28));
        datePaque.put(2033, LocalDate.of(2033, 4, 17));
        datePaque.put(2034, LocalDate.of(2034, 4, 9));
        datePaque.put(2035, LocalDate.of(2035, 3, 25));
        datePaque.put(2036, LocalDate.of(2036, 4, 13));
        datePaque.put(2037, LocalDate.of(2037, 4, 5));
        datePaque.put(2038, LocalDate.of(2038, 4, 25));
        datePaque.put(2039, LocalDate.of(2039, 4, 10));
        datePaque.put(2040, LocalDate.of(2040, 4, 1));
    }

    public static final String MATRICULE_INITIAL = "00000";


    public static Double primeAnnuelleBase() {
        return PRIME_BASE;
    }

    public static List<LocalDate> joursFeries(LocalDate now){

        return Arrays.asList(
                // 1er janvier	Jour de l’an
                LocalDate.of(now.getYear(), 1,1),
                // Lendemain du dimanche de Pâques.	Lundi de Pâques
                datePaque.get(now.getYear()).plusDays(1L),
                // 1er mai	Fête du Travail
                LocalDate.of(now.getYear(), 5,1),
                // 8 mai Fête de la Victoire
                LocalDate.of(now.getYear(), 5,8),
                // Jeudi 40 jours après Pâques Ascension Fête chrétienne célébrant la montée de Jésus aux cieux.
                datePaque.get(now.getYear()).plusDays(40L),
                // Le lundi suivant le dimanche de Pentecôte (le septième après Pâques).
                datePaque.get(now.getYear()).plusDays(50L),
                // 14 juillet Fête nationale
                LocalDate.of(now.getYear(), 7,14),
                // 15 août Assomption
                LocalDate.of(now.getYear(), 8,15),
                // 1er novembre	Toussaint Fête de tous les saints de l’Église catholique.
                LocalDate.of(now.getYear(), 11,1),
                // 11 novembre Armistice de 1918
                LocalDate.of(now.getYear(), 11,11),
                // 25 décembre Noël
                LocalDate.of(now.getYear(), 12,25)

        );
    }

}