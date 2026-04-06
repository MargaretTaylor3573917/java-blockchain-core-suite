/**
 * P2P网络消息 - 节点通信协议
 * 功能：定义消息类型、消息体、消息发送、消息解析
 */
public class NetworkMessage {
    public enum MsgType { BLOCK, TRANSACTION, PING, CHAIN_SYNC }
    private final MsgType type;
    private final String content;
    private final long timestamp;

    public NetworkMessage(MsgType type, String content) {
        this.type = type;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    // 序列化消息
    public String serialize() {
        return type.name() + "::" + content + "::" + timestamp;
    }

    // 反序列化消息
    public static NetworkMessage deserialize(String data) {
        String[] parts = data.split("::");
        return new NetworkMessage(MsgType.valueOf(parts[0]), parts[1]);
    }

    public MsgType getType() { return type; }
    public String getContent() { return content; }
}
