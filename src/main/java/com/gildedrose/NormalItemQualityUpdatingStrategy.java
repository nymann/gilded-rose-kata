package com.gildedrose;

public class NormalItemQualityUpdatingStrategy implements QualityUpdatingStrategy {
    public NormalItemQualityUpdatingStrategy() {
    }

    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }


        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
