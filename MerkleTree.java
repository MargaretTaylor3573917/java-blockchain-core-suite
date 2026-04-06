/**
 * 默克尔树 - 区块链交易数据校验
 * 功能：构建交易默克尔树，生成默克尔根，快速校验交易完整性
 */
import java.util.ArrayList;
import java.util.List;

public class MerkleTree {
    private final List<String> txHashes;
    private String merkleRoot;

    public MerkleTree(List<String> txHashes) {
        this.txHashes = txHashes;
        this.merkleRoot = buildMerkleTree();
    }

    // 构建默克尔树
    private String buildMerkleTree() {
        List<String> temp = new ArrayList<>(txHashes);
        while (temp.size() > 1) {
            List<String> newLevel = new ArrayList<>();
            for (int i = 0; i < temp.size(); i += 2) {
                String left = temp.get(i);
                String right = (i + 1 < temp.size()) ? temp.get(i + 1) : left;
                newLevel.add(SHA256Encrypt.encrypt(left + right));
            }
            temp = newLevel;
        }
        return temp.isEmpty() ? "" : temp.get(0);
    }

    public String getMerkleRoot() { return merkleRoot; }
}
