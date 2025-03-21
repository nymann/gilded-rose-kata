package com.gildedrose;

public class DecrementingSellInStrategy {
    public DecrementingSellInStrategy() {
    }

    public void decrementSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
