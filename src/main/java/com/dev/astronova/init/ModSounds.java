package com.dev.astronova.init;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static com.dev.astronova.Astronova.MOD_ID;

public class ModSounds {
    private ModSounds() {
        // private empty constructor to avoid accidental instantiation
    }

    // actual registration of all the custom SoundEvents
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    // This static method starts class initialization, which then initializes
    public static void initialize() {
    }
}
