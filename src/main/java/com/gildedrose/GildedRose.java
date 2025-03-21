package com.gildedrose;

class GildedRose {
    private final DecrementingSellInStrategy decrementingSellInStrategy = new DecrementingSellInStrategy();
    private final NormalItemQualityUpdater normalItemQualityUpdater = new NormalItemQualityUpdater();
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    decrementingSellInStrategy.decrementSellIn(item);
                    updateAgedBrieQuality(item);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    decrementingSellInStrategy.decrementSellIn(item);
                    updateBackstagePassesQuality(item);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;

                default:
                    decrementingSellInStrategy.decrementSellIn(item);
                    normalItemQualityUpdater.updateNormalItemQuality(item);
            }

        }
    }

    private static void updateBackstagePassesQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 10) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 5) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }


        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private static void updateAgedBrieQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }


        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

}
