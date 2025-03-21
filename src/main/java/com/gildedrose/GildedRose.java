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
                case "Aged Brie" -> new AgedBrieUpdater().updateQualityForAgedBrie(item);
                case "Backstage passes to a TAFKAL80ETC concert" ->
                    new BackstagePassesQualityUpdater().updateQualityForBackstagePasses(item);
                case "Sulfuras, Hand of Ragnaros" -> {

                }
                default -> uncategorizedItemUpdater.updateQualityForItem(item);
            }
        }
    }

}
