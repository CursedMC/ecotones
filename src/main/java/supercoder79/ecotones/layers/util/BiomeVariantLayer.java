package supercoder79.ecotones.layers.util;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.layer.type.IdentitySamplingLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import supercoder79.ecotones.biome.special.HazelGroveBiome;
import supercoder79.ecotones.biome.special.WoodlandThicketBiome;

public enum BiomeVariantLayer implements IdentitySamplingLayer {
    INSTANCE;

    @Override
    public int sample(LayerRandomnessSource context, int sample) {
        if (context.nextInt(4) == 0) {
            if (sample == Registry.BIOME.getRawId(HazelGroveBiome.INSTANCE)) {
                switch (context.nextInt(3)) {
                    case 0:
                        return Registry.BIOME.getRawId(HazelGroveBiome.CLEARING);
                    case 1:
                        return Registry.BIOME.getRawId(HazelGroveBiome.HILLY);
                    case 2:
                        return Registry.BIOME.getRawId(HazelGroveBiome.CLEARING_HILLY);
                }
            }

            if (sample == Registry.BIOME.getRawId(WoodlandThicketBiome.INSTANCE)) {
                switch (context.nextInt(3)) {
                    case 0:
                        return Registry.BIOME.getRawId(WoodlandThicketBiome.CLEARING);
                    case 1:
                        return Registry.BIOME.getRawId(WoodlandThicketBiome.HILLY);
                    case 2:
                        return Registry.BIOME.getRawId(WoodlandThicketBiome.HILLY_CLEARING);
                }
            }
        }

        return sample;
    }
}
