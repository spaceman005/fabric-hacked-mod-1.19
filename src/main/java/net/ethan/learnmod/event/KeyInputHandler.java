package net.ethan.learnmod.event;

import net.ethan.learnmod.FlyHack;
import net.ethan.learnmod.networking.PacketHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_TUTORIAL = "key.category.learnmod.tutorial";
    public static final String KEY_FLY_HACK = "key.learnmod.fly_hack";
    public static final String TELEPORT_HACK = "key.learnmod.teleport_hack";

    public static KeyBinding hackKey;
    public static KeyBinding tpKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(hackKey.wasPressed()){
                FlyHack.setFlyhackEnabled();
            }
            if(tpKey.wasPressed()){
                PacketHelper.moveTo(client.player.getPos().add(5.0,0.0,0.0));
            }
        });
    }
    public static void register(){
        hackKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FLY_HACK,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_P,
                KEY_CATEGORY_TUTORIAL
        ));
        tpKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                TELEPORT_HACK,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                KEY_CATEGORY_TUTORIAL
        ));
        registerKeyInputs();
    }
}
