package com.gildedrose;

import org.junit.jupiter.api.Test;

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

    @Test
    void qualityOfAnItemCanNeverBecomeNegative() {
        Item item = new Item("::name::", 2, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(0, item.quality);
    }
}
