package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater itemUpdater = itemUpdaterFactory(item);
            itemUpdater.update(item);
        }
    }

    private static ItemUpdater itemUpdaterFactory(Item item) {
        switch (item.name) {
            case "Aged Brie" -> {
                return new AgedBrieUpdater();
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
                return new BackstagePassesQualityUpdater();
            }
            case "Sulfuras, Hand of Ragnaros" -> {
                return new SulurasQualityUpdater();
            }
            default -> {
                return new UncategorizedItemUpdater();
            }
        }
    }

}
