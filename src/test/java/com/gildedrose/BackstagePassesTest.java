package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UseReporter({ClipboardReporter.class})
public class BackstagePassesTest {

    @Test
    void qualityIncreasesBy2WhenThereAreMoreThan5ButLessThan10DaysRemaining() {
        CombinationApprovals.verifyAllCombinations(((Integer sellIn) -> {
            Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 3);
            GildedRose gildedRose = new GildedRose(new Item[]{item});

            gildedRose.updateQuality();

            return String.format("sellIn=%d, quality=%d", item.sellIn, item.quality);
        }), new Integer[]{10, 9, 8, 7, 6});
    }

    @Test
    void qualityIncreasesBy3WhenThereAre5orLessDaysRemaining() {
        CombinationApprovals.verifyAllCombinations(((Integer sellIn) -> {
            Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, 20);
            GildedRose gildedRose = new GildedRose(new Item[]{item});

            gildedRose.updateQuality();

            return String.format("sellIn=%d, quality=%d", item.sellIn, item.quality);
        }), new Integer[]{5, 4, 3, 2, 1});
    }


    @Test
    void qualityDropsToZeroAfterTheConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }
}
