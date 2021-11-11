package com.velvet.task1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class AnagramCreatorTest {
    @Test
    public void create() {
        Assert.assertSame(AnagramCreator.create("a1bcd efglh","xl"),"dcb1a hgfle ");
    }
}