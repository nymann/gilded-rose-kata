package com.gildedrose;

class GildedRose {
    private final UncategorizedItemUpdater uncategorizedItemUpdater = new UncategorizedItemUpdater();
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> updateQualityForAgedBrie(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> updateQualityForBackstagePasses(item);
                case "Sulfuras, Hand of Ragnaros" -> {

                }
                default -> uncategorizedItemUpdater.updateQualityForItem(item);
            }
        }
    }

    private void updateQualityForItem(Item item) {

        uncategorizedItemUpdater.updateQualityForItem(item);
    }

    private void updateQualityForAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }

        item.sellIn--;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
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
