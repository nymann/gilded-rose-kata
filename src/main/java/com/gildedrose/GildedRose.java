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
                    new AgedBrieUpdateQualityStrategy().updateQuality(item);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    new DecrementingSellInStrategy().updateSellIn(item);
                    new BackstagePassesUpdateQualityStrategy().updateQuality(item);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;

                default:
                    new DecrementingSellInStrategy().updateSellIn(item);
                    new NormalItemUpdateQualityStrategy().updateQuality(item);
            }

        }
    }

}
