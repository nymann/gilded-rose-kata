package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    new DecrementingSellInStrategy().decrementSellIn(item);
                    AgedBrieQualityUpdatingStrategy.updateAgedBrieQuality(item);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    new DecrementingSellInStrategy().decrementSellIn(item);
                    BackstagePassesUpdatingStrategy.updateBackstagePassesQuality(item);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;

                default:
                    new DecrementingSellInStrategy().decrementSellIn(item);
                    new NormalItemQualityUpdatingStrategy().updateQuality(item);
            }

        }
    }

}
