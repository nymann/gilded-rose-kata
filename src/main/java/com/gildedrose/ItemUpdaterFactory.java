package com.gildedrose;

public class ItemUpdaterFactory {
    static ItemUpdater itemUpdaterFactory(Item item) {
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
