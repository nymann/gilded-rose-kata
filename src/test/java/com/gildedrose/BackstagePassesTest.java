package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -2})
    void qualityDropsToZeroAfterTheConcert(int sellIn) {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(0, item.quality);
    }

    @Test
    void qualityIncreasesBy1WhenThereAreMoreThan10DaysRemaining() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(11, item.quality);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 9, 8, 7, 6})
    void qualityIncreasesBy2WhenThereAreMoreThan5But10orLessDaysRemaining(int sellIn) {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 3);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(5, item.quality);
    }

    @ValueSource(ints = {5, 4, 3, 2, 1})
    @ParameterizedTest
    void qualityIncreasesBy3WhenThereAre5orLessDaysRemaining(int sellIn) {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 2);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(5, item.quality);
    }

    @ValueSource(ints = {48, 49})
    @ParameterizedTest
    void qualityCanNeverBeMoreThan50(int quality) {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, quality);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(50, item.quality);
    }

}
