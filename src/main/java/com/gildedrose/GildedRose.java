package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater itemUpdater;
            switch (item.name) {
                case "Aged Brie":
                    itemUpdater = new ItemUpdater(new AgedBrieUpdateQualityStrategy(), new DecrementingSellInStrategy());
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    itemUpdater = new ItemUpdater(new BackstagePassesUpdateQualityStrategy(), new DecrementingSellInStrategy());
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    itemUpdater = new ItemUpdater(new UpdateQualityStrategy() {
                        @Override
                        public void updateQuality(Item item) {

                        }
                    }, new DoNothingSellInStrategy());
                    break;

                default:
                    itemUpdater = new ItemUpdater(new NormalItemUpdateQualityStrategy(), new DecrementingSellInStrategy());
            }

            itemUpdater.updateItem(item);


        }
    }

}
