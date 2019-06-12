package com.maktab;

import com.maktab.Q1.Cat;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Collections;

import static com.maktab.Q1.Cat.BreedType.*;


public class MyTest {
    @Test
    @DisplayName("ListCreatorTest")
    public void testCreateCatList(){
        ArrayList<Cat> cats = new ArrayList<>();
        Cat.createCatList(cats);
        Assertions.assertNotNull(cats);
    }
    @Test
    @DisplayName("CatsFilterTest")
    public void testFilterCats(){
        ArrayList<Cat> cats = new ArrayList<>();
        Cat.createCatList(cats);
        Cat.assignBreeds(cats);
        ArrayList<Cat.BreedType> result = new ArrayList<>();
        Collections.addAll(result, new Cat.BreedType[]{Aegean, American_Curl, American_Wirehair, Arabian_Mau,
                Asian_Semilonghair, Chantilly_Tiffany, Chausie, Colorpoint_Shorthair, Cymric, Persian_Modern, Peterbald});
        Assertions.assertEquals(result,Cat.filterCats(cats));
    }


}
