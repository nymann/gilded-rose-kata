package com.gildedrose;

public class AgedBrieQualityUpdatingStrategy implements QualityUpdatingStrategy {

    @Override
    public void updateQuality(Item item) {
        {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }


            if (item.sellIn < 0) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
