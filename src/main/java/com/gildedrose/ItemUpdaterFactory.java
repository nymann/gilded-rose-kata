package com.gildedrose;

public class ItemUpdaterFactory {
    static ItemUpdater create(Item item) {
        ItemUpdater itemUpdater = switch (item.name) {
            case "Aged Brie" -> new ItemUpdater(new AgedBrieUpdateQualityStrategy(), new DecrementingSellInStrategy());
            case "Backstage passes to a TAFKAL80ETC concert" ->
                    new ItemUpdater(new BackstagePassesUpdateQualityStrategy(), new DecrementingSellInStrategy());
            case "Sulfuras, Hand of Ragnaros" -> new ItemUpdater(new UpdateQualityStrategy() {
                @Override
                public void updateQuality(Item item) {

                }
            }, new DoNothingSellInStrategy());
            default -> new ItemUpdater(new NormalItemUpdateQualityStrategy(), new DecrementingSellInStrategy());
        };
        return itemUpdater;
    }
}
