package com.gildedrose;

public class DecrementingSellInStrategy implements UpdateSellInStrategy {
    public DecrementingSellInStrategy() {
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn--;
    }
}
