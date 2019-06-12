package com.maktab.Q1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cat extends Animal {
    protected BreedType breed;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public static void createCatList(ArrayList<Cat> cats) {
        for (int i = 1; i < 100; i++) {
            cats.add(new Cat("cat" + i));
        }
    }

    public static void assignBreeds(ArrayList<Cat> cats) {
        for (int i = 0; i < 99; i++) {
            cats.get(i).breed = Cat.BreedType.values()[i];
        }
    }

    public static List<BreedType> filterCats(ArrayList<Cat> cats) {
        Stream<Cat.BreedType> filterCats = cats.stream().filter(a -> a.breed.startsWith("A") || a.breed.startsWith("C")
                || a.breed.startsWith("P")).filter(a -> a.name.charAt(a.name.length() - 1) % 2 == 0).map(a -> a.breed);
        return filterCats.collect(Collectors.toList());
    }

    public enum BreedType {
        Abyssinian, Aegean, American_Bobtail, American_Curl, American_Shorthair, American_Wirehair,
        Aphrodite_Giant, Arabian_Mau, Asian, Asian_Semilonghair, Australian_Mist, Balinese, Bambino,
        Bengal, Birman, Bombay, Brazilian_Shorthair, British_Longhair, British_Semilonghair,
        British_Shorthair, Burmese, Burmilla, California_Spangled, Chantilly_Tiffany, Chartreux,
        Chausie, Cheetoh, Colorpoint_Shorthair, Cornish_Rex, Cymric, Cyprus, Devon_Rex, Donskoy,
        Dragon_Li, Dwelf, Egyptian_Mau, European_Shorthair, Exotic_Shorthair, Foldex, German_Rex,
        Havana_Brown, Highlander, Himalayan, Japanese_Bobtail, Javanese, Karelian_Bobtail, Khao_Manee,
        Korat, Korean_Bobtail, Korn_Ja, Kurilian_Bobtail, LaPerm, Lykoi, Maine_Coon, Manx, Mekong_Bobtail,
        Minskin, Munchkin, Napoleon, Nebelung, Norwegian_Forest_Cat, Ocicat, Ojos_Azules, Oregon_Rex,
        Oriental_Bicolor, Oriental_Longhair, Oriental_Shorthair, Persian_Modern, Persian_Traditional,
        Peterbald, Pixie_Bob, Raas, Ragamuffin, Ragdoll, Russian_Blue, Russian_White, Sam_Sawet,
        Savannah, Scottish_Fold, Selkirk_Rex, Serengeti, Serrade_Petit, Siamese, Siberian, Singapura,
        Snowshoe, Sokoke, Somali, Sphynx, Suphalak, Thai_Lilac, Thai, Tonkinese, Toyger, Turkish_Angora,
        Turkish_Van, Ukrainian_Levkoy, Wila_Krungthep, YorkChocolate;

        public boolean startsWith(String a) {
            String s;
            s = this.toString();
            if (s.startsWith(a))
                return true;
            return false;
        }
    }//End of BreedType enum

}//End of Cat class
