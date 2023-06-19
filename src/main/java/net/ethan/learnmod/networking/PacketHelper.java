package net.ethan.learnmod.networking;

import net.ethan.learnmod.mixin.ClientConnectionInvoker;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;

public class PacketHelper {
    public PlayerEntity player;
    public static void moveTo(Vec3d pos) {
        final MinecraftClient client = MinecraftClient.getInstance();
        assert client.player != null;
        ClientConnectionInvoker conn = (ClientConnectionInvoker)client.player.networkHandler.getConnection();

        float yaw = client.player.getYaw();
        float pitch = client.player.getPitch();
        double distance = 5.0;
        double offsetX = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch)) * distance;
        double offsetY = -Math.sin(Math.toRadians(pitch)) * distance;
        double offsetZ = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch)) * distance;

        Vec3d posNew = pos.add(offsetX, offsetY, offsetZ);

        Packet packet = (new PlayerMoveC2SPacket.PositionAndOnGround(posNew.x, posNew.y, posNew.z, true));
        conn._sendImmediately(packet, null);
        client.player.setPosition(posNew);
    }
}
