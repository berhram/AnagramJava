package com.velvet.task1;

import org.junit.Assert;
import org.junit.Test;

public class AnagramCreatorTest {
    @Test
    public void create() {
        String[] input = new String[]{"London","Manchester", "Lancaster", "Marsh St., Innsmouth", "11.11.2021", "X Æ A-12"};
        String[] ignored = new String[]{"n","ae", "Lr", ".,", "1", "12"};
        String[] output = new String[]{"odnoLn","ratshecneM", "Letsacnar", "hsraM tS., htuomsnnI", "1121102..1", "X Æ -A12"};
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(AnagramCreator.create(input[i],ignored[i]),output[i]);
        }
        Assert.assertEquals(AnagramCreator.create(null,"12345"),"");
        Assert.assertEquals(AnagramCreator.create("12345",null),"12345");
    }

}