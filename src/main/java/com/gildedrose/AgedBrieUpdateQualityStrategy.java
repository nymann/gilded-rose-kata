package com.gildedrose;

public class AgedBrieUpdateQualityStrategy implements UpdateQualityStrategy {

    @Override
    public void updateQuality(Item item) {
        {
            if (item.quality < 50) {
                item.quality++;
            }


            if (item.sellIn < 0) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
        }
    }
}
