package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater itemUpdater = getItemUpdaterFor(item);
            itemUpdater.update(item);
        }
    }

    private static ItemUpdater getItemUpdaterFor(Item item) {
        switch (item.name) {
            case "Aged Brie" -> {
                AgedBrieUpdater agedBrieUpdater = new AgedBrieUpdater();
                return agedBrieUpdater;
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
                BackstagePassesQualityUpdater backstagePassesQualityUpdater = new BackstagePassesQualityUpdater();
                return backstagePassesQualityUpdater;
            }
            case "Sulfuras, Hand of Ragnaros" -> {
                return new SulurasQualityUpdater();
            }
            default -> {
                UncategorizedItemUpdater uncategorizedItemUpdater = new UncategorizedItemUpdater();
                return uncategorizedItemUpdater;
            }
        }
    }

}
