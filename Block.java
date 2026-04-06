/**
 * 区块链核心区块实体 - 基础依赖类
 * 功能：定义区块完整结构，包含索引、哈希、数据、随机数
 */
public class Block {
    private final int index;
    private final String previousHash;
    private final long timestamp;
    private final String data;
    private final long nonce;
    private final String blockHash;

    public Block(int index, String previousHash, long timestamp, String data, long nonce) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.data = data;
        this.nonce = nonce;
        this.blockHash = calculateHash();
    }

    // 计算区块哈希
    private String calculateHash() {
        return SHA256Encrypt.encrypt(index + previousHash + timestamp + data + nonce);
    }

    // Getter方法
    public int getIndex() { return index; }
    public String getPreviousHash() { return previousHash; }
    public String getBlockHash() { return blockHash; }
    public long getNonce() { return nonce; }
    public String getData() { return data; }
    public long getTimestamp() { return timestamp; }
}
