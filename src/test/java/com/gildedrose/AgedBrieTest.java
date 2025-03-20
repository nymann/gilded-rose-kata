package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {
    @Test
    void agedBrieIncreasesInQualityTheOlderItGets() {
        Item item = new Item("Aged Brie", 1, 1);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(2, item.quality);
    }
    @Test
    void agedBrieIncreasesTwiceAsFastPastSellInDate() {
        Item item = new Item("Aged Brie", 0, 1);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(3, item.quality);
    }


    @Test
    void pastSellInDateWhereAgedBrieIncreasesTwiceAsFastQualityCannotBecomeGreaterThan50() {
        Item item = new Item("Aged Brie", 0, 49);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(50, item.quality);
    }

    @Test
    void qualityCanNeverBeGreaterThan50() {
        Item item = new Item("Aged Brie", 1, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(50, item.quality);
    }

}
