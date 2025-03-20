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
    void qualityDropsToZeroAfterTheConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void qualityIncreasesBy1WhenThereAreMoreThan10DaysRemaining() {
        Integer[] sellIn = {11};
        Integer[] qualities = {3};
        CombinationApprovals.verifyAllCombinations(this::updateQuality, sellIn, qualities);
    }

    @Test
    void qualityIncreasesBy2WhenThereAreMoreThan5ButLessThan10DaysRemaining() {
        Integer[] sellIns = {10, 9, 8, 7, 6};
        Integer[] qualities = {3, 48, 49};
        CombinationApprovals.verifyAllCombinations(this::updateQuality, sellIns, qualities);
    }

    @Test
    void qualityIncreasesBy3WhenThereAre5orLessDaysRemaining() {
        Integer[] sellIns = {5, 4, 3, 2, 1};
        Integer[] qualities = {10, 48};
        CombinationApprovals.verifyAllCombinations(this::updateQuality, sellIns, qualities);
    }

    private String updateQuality(int sellIn, int initialQuality) {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, initialQuality);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        return item.toString();
    }
}
