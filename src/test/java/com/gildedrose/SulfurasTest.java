package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 50})
    void sulfurasNeverDecreasesInQuality(int sellIn) {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", sellIn, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.updateQuality();

        assertEquals(80, sulfuras.quality);
    }

    @Test
    void sulfurasNeverExpiresSoSellInDateDoesNotChange() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.updateQuality();

        assertEquals(-1, sulfuras.sellIn);
    }
}
