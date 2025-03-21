package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> updateQualityForAgedBrie(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> {
                    updateQualityForBackstagePasses(item);
                }
                case "Sulfuras, Hand of Ragnaros" -> {

                }
                default -> {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }

                    item.sellIn = item.sellIn - 1;

                    if (item.sellIn < 0) {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                    }
                }
            }
        }
    }

    private static void updateQualityForAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private static void updateQualityForBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

}
