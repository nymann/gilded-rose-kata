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
                    new DecrementingSellInStrategy().updateSellIn(item);
                    new AgedBrieQualityUpdatingStrategy().updateQuality(item);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    new DecrementingSellInStrategy().updateSellIn(item);
                    new BackstagePassesQualityUpdatingStrategy().updateQuality(item);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;

                default:
                    new DecrementingSellInStrategy().updateSellIn(item);
                    new NormalItemQualityUpdatingStrategy().updateQuality(item);
            }

        }
    }

}
