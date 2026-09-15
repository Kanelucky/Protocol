package org.cloudburstmc.protocol.bedrock.data;

/**
 * The player's furnace interface preferences.
 *
 * @param leftTabIndex the section open in the left tab
 * @param filtering    Are recipe submissions open?
 * @param layout       interface layout
 * @since v2192
 */
public record FurnaceOptions(FurnaceLeftTabIndex leftTabIndex, boolean filtering, FurnaceLayout layout) {

    public enum FurnaceLeftTabIndex {
        NONE,
        RECIPE_FOOD,
        RECIPE_ITEMS,
        RECIPE_BLOCKS,
        RECIPE_SEARCH,
        INVENTORY
    }

    public enum FurnaceLayout {
        NONE,
        INVENTORY_ONLY,
        DEFAULT
    }
}