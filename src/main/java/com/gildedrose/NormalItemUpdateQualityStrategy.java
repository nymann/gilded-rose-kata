package com.gildedrose;

public class NormalItemUpdateQualityStrategy implements UpdateQualityStrategy {
    public NormalItemUpdateQualityStrategy() {
    }

    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }


        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality--;
            }
        }
    }
}
