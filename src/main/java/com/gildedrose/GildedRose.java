package com.gildedrose;

class GildedRose {
    private final UncategorizedItemUpdater uncategorizedItemUpdater = new UncategorizedItemUpdater();
    private final AgedBrieUpdater agedBrieUpdater = new AgedBrieUpdater();
    private final BackstagePassesQualityUpdater backstagePassesQualityUpdater = new BackstagePassesQualityUpdater();
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> agedBrieUpdater.updateQualityForAgedBrie(item);
                case "Backstage passes to a TAFKAL80ETC concert" ->
                    backstagePassesQualityUpdater.updateQualityForBackstagePasses(item);
                case "Sulfuras, Hand of Ragnaros" -> {

                }
                default -> uncategorizedItemUpdater.updateQualityForItem(item);
            }
        }
    }

}
