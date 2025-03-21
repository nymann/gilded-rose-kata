package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            getItemUpdaterFor(item);
        }
    }

    private static ItemUpdater getItemUpdaterFor(Item item) {
        switch (item.name) {
            case "Aged Brie" -> {
                AgedBrieUpdater agedBrieUpdater = new AgedBrieUpdater();
                agedBrieUpdater.update(item);
                return agedBrieUpdater;
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
                BackstagePassesQualityUpdater backstagePassesQualityUpdater = new BackstagePassesQualityUpdater();
                backstagePassesQualityUpdater.update(item);
            }
            case "Sulfuras, Hand of Ragnaros" -> {

            }
            default -> new UncategorizedItemUpdater().update(item);
        }
        return null;
    }

}
