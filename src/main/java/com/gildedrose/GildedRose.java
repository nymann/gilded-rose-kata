package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater itemUpdater;
            UpdateSellInStrategy decrementingSellInStrategy = new DecrementingSellInStrategy();
            switch (item.name) {
                case "Aged Brie":
                    decrementingSellInStrategy.updateSellIn(item);
                    UpdateQualityStrategy agedBrieUpdateQualityStrategy = new AgedBrieUpdateQualityStrategy();
                    agedBrieUpdateQualityStrategy.updateQuality(item);
                    itemUpdater = new ItemUpdater(agedBrieUpdateQualityStrategy, decrementingSellInStrategy);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    decrementingSellInStrategy.updateSellIn(item);
                    BackstagePassesUpdateQualityStrategy backstagePassesUpdateQualityStrategy = new BackstagePassesUpdateQualityStrategy();
                    backstagePassesUpdateQualityStrategy.updateQuality(item);
                    itemUpdater = new ItemUpdater(backstagePassesUpdateQualityStrategy, decrementingSellInStrategy);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    itemUpdater = new ItemUpdater(new UpdateQualityStrategy() {
                        @Override
                        public void updateQuality(Item item) {

                        }
                    }, new DoNothingSellInStrategy());
                    break;

                default:
                    new DecrementingSellInStrategy().updateSellIn(item);
                    NormalItemUpdateQualityStrategy normalItemUpdateQualityStrategy = new NormalItemUpdateQualityStrategy();
                    normalItemUpdateQualityStrategy.updateQuality(item);
                    itemUpdater = new ItemUpdater(normalItemUpdateQualityStrategy, decrementingSellInStrategy);
            }


        }
    }

}
