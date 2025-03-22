package com.gildedrose;

public class ItemUpdater {
    private final UpdateQualityStrategy updateQualityStrategy;
    private final UpdateSellInStrategy updateSellInStrategy;

    public ItemUpdater(UpdateQualityStrategy updateQualityStrategy, UpdateSellInStrategy updateSellInStrategy) {
        this.updateQualityStrategy = updateQualityStrategy;
        this.updateSellInStrategy = updateSellInStrategy;
    }

    public void updateItem(Item item) {
        this.updateSellInStrategy.updateSellIn(item);
        this.updateQualityStrategy.updateQuality(item);
    }
}
