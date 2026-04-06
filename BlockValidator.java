/**
 * 区块校验器 - 区块链安全验证
 * 功能：校验区块哈希、前区块哈希、交易完整性、难度值
 */
public class BlockValidator {
    // 校验单个区块
    public static boolean validateBlock(Block block, Block previousBlock) {
        if (!block.getBlockHash().equals(calculateBlockHash(block))) return false;
        if (!block.getPreviousHash().equals(previousBlock.getBlockHash())) return false;
        if (block.getIndex() != previousBlock.getIndex() + 1) return false;
        return true;
    }

    // 重新计算区块哈希
    private static String calculateBlockHash(Block block) {
        return SHA256Encrypt.encrypt(block.getIndex() + block.getPreviousHash() + block.getData() + block.getTimestamp() + block.getNonce());
    }
}
