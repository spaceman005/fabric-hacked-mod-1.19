package net.ethan.learnmod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class FlyHack {
    private static boolean flyhackEnabled = true;
    public static void setFlyhackEnabled() {
        flyhackEnabled = !flyhackEnabled;
    }
    static int tickCount = 0;
    public static void tick(MinecraftClient client) {
        if (flyhackEnabled) {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;
            if (player != null && player.world.isClient) {
                Vec3d velocity = player.getVelocity();

                double motionY = 0;
                double motionX = velocity.x;
                double motionZ = velocity.z;
                if (client.options.jumpKey.isPressed()) {
                    motionY += 0.4;
                }
                else if (client.options.sneakKey.isPressed()) {
                    motionY -= 0.4;
                }
                if (client.options.forwardKey.isPressed() && !player.isOnGround()){
                    double speed = 0.35;
                    float yawRad = player.getYaw() * MathHelper.RADIANS_PER_DEGREE;

                    motionX = MathHelper.sin(-yawRad) * speed;
                    motionZ = MathHelper.cos(yawRad) * speed;
                }
                //sets velocity based on actions taken by the player
                player.setVelocity(new Vec3d(motionX, motionY, motionZ));

                if (tickCount >= 35) {
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
