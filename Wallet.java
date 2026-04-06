/**
 * 区块链钱包 - 原创实现
 * 功能：生成钱包地址、管理密钥对、创建交易、查询余额
 */
public class Wallet {
    private final String walletAddress;
    private final DigitalSignature signature;
    private double balance;

    public Wallet() throws Exception {
        this.signature = new DigitalSignature();
        this.walletAddress = SHA256Encrypt.encrypt(signature.getPublicKey().toString());
        this.balance = 0;
    }

    // 创建交易
    public Transaction createTransaction(String receiver, double amount) {
        if (balance < amount) throw new RuntimeException("余额不足");
        String txId = SHA256Encrypt.encrypt(walletAddress + receiver + amount + System.currentTimeMillis());
        Transaction tx = new Transaction(txId, walletAddress, receiver, amount, System.currentTimeMillis());
        balance -= amount;
        return tx;
    }

    // 接收交易
    public void receiveTransaction(Transaction tx) {
        if (tx.getReceiver().equals(walletAddress)) balance += tx.getAmount();
    }

    public String getWalletAddress() { return walletAddress; }
    public double getBalance() { return balance; }
}
