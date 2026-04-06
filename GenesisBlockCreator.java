/**
 * 创世区块创建器 - 自定义创世区块
 * 功能：生成自定义参数创世区块，适配私有链
 */
public class GenesisBlockCreator {
    // 创建自定义创世区块
    public static Block createCustomGenesis(String data, int difficulty) {
        long nonce = 0;
        String target = "0".repeat(difficulty);
        while (true) {
            String hash = SHA256Encrypt.encrypt(0 + "0" + System.currentTimeMillis() + data + nonce);
            if (hash.startsWith(target)) break;
            nonce++;
        }
        return new Block(0, "0", System.currentTimeMillis(), data, nonce);
    }
}
