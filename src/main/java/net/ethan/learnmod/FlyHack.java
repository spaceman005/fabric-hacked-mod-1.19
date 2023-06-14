package net.ethan.learnmod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class FlyHack {
    private static boolean flyhackEnabled = true;
    private static int tickCount = 0;
    private static final double MIN_VERTICAL_VELOCITY = -0.37; // Adjust this threshold as needed

    public static void setFlyhackEnabled() {
        flyhackEnabled = !flyhackEnabled;
    }

    public static void tick() {
        if (flyhackEnabled) {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;
            if (player != null) {
                player.getAbilities().allowFlying = true;
                double yVelocity = player.getVelocity().y;

                if (yVelocity < MIN_VERTICAL_VELOCITY) {
                    tickCount = 0;
                }

                if (tickCount >= 40) {
                    if (!player.isOnGround()){
                        Vec3d pos = player.getVelocity();
                        player.setVelocity(pos.x, -0.37, pos.z);
                    }
                    tickCount = 0;
                }
                tickCount++;
            }
        }
    }
}