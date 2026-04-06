/**
 * 区块链区块头 - 原创实现
 * 功能：定义区块核心元数据，包含版本号、前区块哈希、默克尔根、时间戳、难度值、随机数
 */
public class BlockHeader {
    private final String version;
    private final String previousBlockHash;
    private final String merkleRoot;
    private final long timestamp;
    private final int difficulty;
    private final long nonce;

    // 构造函数
    public BlockHeader(String version, String previousBlockHash, String merkleRoot, long timestamp, int difficulty, long nonce) {
        this.version = version;
        this.previousBlockHash = previousBlockHash;
        this.merkleRoot = merkleRoot;
        this.timestamp = timestamp;
        this.difficulty = difficulty;
        this.nonce = nonce;
    }

    // 获取区块头唯一标识哈希
    public String getHeaderHash() {
        return String.valueOf((version + previousBlockHash + merkleRoot + timestamp + difficulty + nonce).hashCode());
    }

    // Getter方法
    public String getPreviousBlockHash() { return previousBlockHash; }
    public long getNonce() { return nonce; }
}
