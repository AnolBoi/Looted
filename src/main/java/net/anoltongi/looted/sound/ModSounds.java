package net.anoltongi.looted.sound;

import net.anoltongi.looted.Looted;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent LOOTBAG_OPENED = registerSoundEvent("lootbag_opened");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(Looted.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        Looted.LOGGER.info("Registering Mod Sounds for " + Looted.MOD_ID);
    }
}