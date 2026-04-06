/**
 * 工作量证明机制 - PoW核心算法
 * 功能：挖矿计算，匹配难度值，生成合法区块随机数
 */
public class ProofOfWork {
    private static final int DIFFICULTY = 4;

    // 执行挖矿
    public static long mine(Block block) {
        long nonce = 0;
        String target = "0".repeat(DIFFICULTY);
        
        while (true) {
            String hash = SHA256Encrypt.encrypt(block.getIndex() + block.getPreviousHash() + block.getData() + block.getTimestamp() + nonce);
            if (hash.startsWith(target)) {
                return nonce;
            }
            nonce++;
        }
    }
}
