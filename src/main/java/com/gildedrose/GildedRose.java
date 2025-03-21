package com.gildedrose;

class GildedRose {
    private final UncategorizedItemUpdater uncategorizedItemUpdater = new UncategorizedItemUpdater();
    private final AgedBrieUpdater agedBrieUpdater = new AgedBrieUpdater();
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> agedBrieUpdater.updateQualityForAgedBrie(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> updateQualityForBackstagePasses(item);
                case "Sulfuras, Hand of Ragnaros" -> {

                }
                default -> uncategorizedItemUpdater.updateQualityForItem(item);
            }
        }
    }

    private void updateQualityForAgedBrie(Item item) {

        agedBrieUpdater.updateQualityForAgedBrie(item);
    }

    private void updateQualityForBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality++;

            if (item.sellIn < 11 && item.quality < 50) {
                item.quality++;
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality++;
            }
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

}
