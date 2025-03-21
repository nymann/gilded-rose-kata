package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {
    public AgedBrieUpdater() {
    }

    public void update(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
        }

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }
}
