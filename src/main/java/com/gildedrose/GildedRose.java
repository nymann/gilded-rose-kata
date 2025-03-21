package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> {
                    if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;

                        }
                    }

                    item.sellIn = item.sellIn - 1;

                    if (item.sellIn < 0) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
                case "Backstage passes to a TAFKAL80ETC concert" -> {
                    if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;

                            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
                        }
                    }

                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.sellIn = item.sellIn - 1;
                    }

                    if (item.sellIn < 0) {
                        if (!item.name.equals("Aged Brie")) {
                            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                                if (item.quality > 0) {
                                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                        item.quality = item.quality - 1;
                                    }
                                }
                            } else {
                                item.quality = 0;
                            }
                        } else {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
                case "Sulfuras, Hand of Ragnaros" -> {
                    if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;

                            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
                        }
                    }

                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.sellIn = item.sellIn - 1;
                    }

                    if (item.sellIn < 0) {
                        if (!item.name.equals("Aged Brie")) {
                            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                                if (item.quality > 0) {
                                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                        item.quality = item.quality - 1;
                                    }
                                }
                            } else {
                                item.quality = 0;
                            }
                        } else {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
                default -> {
                    if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;

                            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
                        }
                    }

                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.sellIn = item.sellIn - 1;
                    }

                    if (item.sellIn < 0) {
                        if (!item.name.equals("Aged Brie")) {
                            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                                if (item.quality > 0) {
                                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                        item.quality = item.quality - 1;
                                    }
                                }
                            } else {
                                item.quality = 0;
                            }
                        } else {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }
        }
    }

}
