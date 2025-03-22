package com.gildedrose;

class GildedRose {
    private final DecrementingSellInStrategy decrementingSellInStrategy = new DecrementingSellInStrategy();
    private final NormalItemQualityUpdater normalItemQualityUpdater = new NormalItemQualityUpdater();
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    decrementingSellInStrategy.decrementSellIn(item);
                    AgedBrieQualityUpdatingStrategy.updateAgedBrieQuality(item);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    decrementingSellInStrategy.decrementSellIn(item);
                    BackstagePassesUpdatingStrategy.updateBackstagePassesQuality(item);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;

                default:
                    decrementingSellInStrategy.decrementSellIn(item);
                    normalItemQualityUpdater.updateNormalItemQuality(item);
            }

        }
    }

}
