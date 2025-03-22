package com.gildedrose;

public class DecrementingSellInStrategy {
    public DecrementingSellInStrategy() {
    }

    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
