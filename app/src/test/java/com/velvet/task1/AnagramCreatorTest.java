package com.velvet.task1;

import org.junit.Assert;
import org.junit.Test;

public class AnagramCreatorTest {
    @Test
    public void create() {
        Assert.assertEquals(AnagramCreator.create("a1bcd efglh","xl"),"dcb1a hgfle ");
        Assert.assertEquals(AnagramCreator.create("abcd efgh","xl"),"dcba hgfe ");
    }

}