package net.kaupenjoe.adventures.biome;

import net.kaupenjoe.adventures.Adventures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class ModBiomes
{
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, Adventures.MODID);

    public static RegistryObject<Biome> register(ResourceKey<Biome> key, Supplier<Biome> biomeSupplier)
    {
        return BIOMES.register(key.location().getPath(), biomeSupplier);
    }

    public static void register(IEventBus eventBus)
    {
        register(Keys.SLIME_WASTELANDS, ModBiomeDefinitions::slimeWastelands);
        BIOMES.register(eventBus);
    }

    public static class Keys
    {
        public static final ResourceKey<Biome> SLIME_WASTELANDS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Adventures.MODID, "slime_wastelands"));
    }
}
