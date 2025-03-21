package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalInventoryItemTest {
    @Test
    void whenUpdatingNormalInventoryItemQualityIsDecreasedByOne() {
        Item item = new Item("::name::", 2, 2);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(1, item.quality);
    }

    @Test
    void whenUpdatingNormalInventoryItemSellInIsDecreasedByOne() {
        Item item = new Item("::name::", 2, 2);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(1, item.sellIn);
    }

    @Test
    void onceSellByDateHasPassedQualityDegradesTwiceAsFast() {
        Item item = new Item("::name::", 0, 2);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(0, item.quality);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void onceSellByDateHasPassedQualityDegradesTwiceAsFastButNotBelowZero(int quality) {
        Item item = new Item("::name::", 0, quality);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(Math.max(quality - 2, 0), item.quality);
    }

    @Test
    void qualityOfAnItemCanNeverBecomeNegative() {
        Item item = new Item("::name::", 2, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(0, item.quality);
    }
}
