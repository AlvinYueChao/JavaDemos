package org.example.alvin.study.network.netty.serializable.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;
import org.msgpack.MessagePack;

/*基于MessagePack的解码器，反序列化*/
public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf> {
  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
    final int length = msg.readableBytes();
    final byte[] array = new byte[length];
    msg.getBytes(msg.readerIndex(), array, 0, length);
    MessagePack messagePack = new MessagePack();
    out.add(messagePack.read(array, User.class));
  }
}
