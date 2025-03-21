package com.gildedrose;

public class AgedBrieUpdater {
    public AgedBrieUpdater() {
    }

    public void updateQualityForAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }

        item.sellIn--;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }
}
