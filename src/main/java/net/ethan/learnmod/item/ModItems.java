package net.ethan.learnmod.item;

import net.ethan.learnmod.LearnMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LA_CROIX = registerItem("la_croix",
            new Item(new Item.Settings()), ItemGroups.FUNCTIONAL);
    private static Item registerItem(String name, Item item, ItemGroup group){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(LearnMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        LearnMod.LOGGER.debug("qqq");
    }
}
