/**
 * 区块链交易实体 - 原创实现
 * 功能：定义交易结构，包含交易ID、发送方、接收方、金额、时间戳、签名
 */
public class Transaction {
    private final String txId;
    private final String sender;
    private final String receiver;
    private final double amount;
    private final long timestamp;
    private String signature;

    public Transaction(String txId, String sender, String receiver, double amount, long timestamp) {
        this.txId = txId;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // 签名交易
    public void signTransaction(String sign) {
        this.signature = sign;
    }

    // 获取交易唯一标识
    public String getTxHash() {
        return SHA256Encrypt.encrypt(txId + sender + receiver + amount + timestamp);
    }

    // Getter方法
    public String getTxId() { return txId; }
    public double getAmount() { return amount; }
}
