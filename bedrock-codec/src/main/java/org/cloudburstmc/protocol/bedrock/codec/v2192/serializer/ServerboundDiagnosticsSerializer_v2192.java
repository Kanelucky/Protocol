package org.cloudburstmc.protocol.bedrock.codec.v2192.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.v2168.serializer.ServerboundDiagnosticsSerializer_v2168;
import org.cloudburstmc.protocol.bedrock.data.MemoryCategoryCounter;
import org.cloudburstmc.protocol.bedrock.packet.ServerboundDiagnosticsPacket;
import org.cloudburstmc.protocol.bedrock.util.TypeMap;

public class ServerboundDiagnosticsSerializer_v2192 extends ServerboundDiagnosticsSerializer_v2168 {

    public ServerboundDiagnosticsSerializer_v2192(TypeMap<MemoryCategoryCounter.Category> memoryCategoryTypes) {
        super(memoryCategoryTypes);
    }

    @Override
    protected void writeEntityDiagnostics(
            ByteBuf buffer, BedrockCodecHelper helper, ServerboundDiagnosticsPacket.EntityDiagnostics diagnostics) {
        super.writeEntityDiagnostics(buffer, helper, diagnostics);
        helper.writeVector3f(buffer, diagnostics.getPosition());
        helper.writeString(buffer, diagnostics.getDimension());
    }

    @Override
    protected ServerboundDiagnosticsPacket.EntityDiagnostics readEntityDiagnostics(
            ByteBuf buffer, BedrockCodecHelper helper) {
        ServerboundDiagnosticsPacket.EntityDiagnostics diagnostics = super.readEntityDiagnostics(buffer, helper);
        diagnostics.setPosition(helper.readVector3f(buffer));
        diagnostics.setDimension(helper.readString(buffer));
        return diagnostics;
    }
}
