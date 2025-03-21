package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    item.sellIn = item.sellIn - 1;
                    updateAgedBrieQuality(item);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    item.sellIn = item.sellIn - 1;
                    updateBackstagePassesQuality(item);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;

                default:
                    item.sellIn = item.sellIn - 1;
                    updateNormalItemQuality(item);
            }

        }
    }

    private static void updateNormalItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }


        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
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
