package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    @Test
    void sulfurasNeverDecreasesInQuality() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 50, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.updateQuality();

        assertEquals(80, sulfuras.quality);
    }

    @Test
    void sulfurasNeverExpires() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 50, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.updateQuality();

        assertEquals(50, sulfuras.sellIn);
    }
}
