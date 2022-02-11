package com.velvet.anagrams;

import org.junit.Assert;
import org.junit.Test;

public class AnagramCreatorTest {
    @Test
    public void create() {
        String[] input = new String[]{"London","Manchester", "Lancaster", "Marsh St., Innsmouth", "11.11.2021", "X Æ A-12","Mongolia"};
        String[] ignored = new String[]{"n","ae", "Lr", ".,", "1", "12",""};
        String[] output = new String[]{"odnoLn","ratshecneM", "Letsacnar", "hsraM tS., htuomsnnI", "1121102..1", "X Æ -A12","ailognoM"};
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(AnagramCreator.create(input[i],ignored[i]),output[i]);
        }
    }

    @Test(expected = NullPointerException.class)
    public void checkIsExceptionOfRightType_whenFirstArgumentIsNull() {
        AnagramCreator.create(null,"12345");
    }

    @Test(expected = NullPointerException.class)
    public void checkIsExceptionOfRightType_whenSecondArgumentIsNull() {
        AnagramCreator.create("12345",null);
    }

}