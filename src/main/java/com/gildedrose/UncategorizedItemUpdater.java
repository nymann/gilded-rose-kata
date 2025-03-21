package com.gildedrose;

public class UncategorizedItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality > 0) {
            item.quality--;
        }

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}
