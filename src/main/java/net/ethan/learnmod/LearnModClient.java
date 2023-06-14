package net.ethan.learnmod;

import net.ethan.learnmod.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class LearnModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();

    }
}
