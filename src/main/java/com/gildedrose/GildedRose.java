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
                    UpdateQualityStrategy agedBrieUpdateQualityStrategy = new AgedBrieUpdateQualityStrategy();
                    itemUpdater = new ItemUpdater(agedBrieUpdateQualityStrategy, decrementingSellInStrategy);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    BackstagePassesUpdateQualityStrategy backstagePassesUpdateQualityStrategy = new BackstagePassesUpdateQualityStrategy();
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
                    NormalItemUpdateQualityStrategy normalItemUpdateQualityStrategy = new NormalItemUpdateQualityStrategy();
                    itemUpdater = new ItemUpdater(normalItemUpdateQualityStrategy, decrementingSellInStrategy);
            }

            itemUpdater.updateItem(item);


        }
    }

}
