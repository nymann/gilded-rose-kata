package com.gildedrose;

public class BackstagePassesQualityUpdater implements ItemUpdater {
    public BackstagePassesQualityUpdater() {
    }

    public void update(Item item) {
        if (item.quality < 50) {
            item.quality++;

            if (item.sellIn < 11 && item.quality < 50) {
                item.quality++;
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality++;
            }
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
