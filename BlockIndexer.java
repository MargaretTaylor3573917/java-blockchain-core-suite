/**
 * 区块索引器 - 快速查询区块
 * 功能：建立区块哈希索引、根据哈希查询区块、根据高度查询区块
 */
import java.util.HashMap;
import java.util.Map;

public class BlockIndexer {
    private final Map<String, Block> hashIndex;
    private final Map<Integer, Block> heightIndex;

    public BlockIndexer() {
        hashIndex = new HashMap<>();
        heightIndex = new HashMap<>();
    }

    // 建立区块索引
    public void buildIndex(Block block) {
        hashIndex.put(block.getBlockHash(), block);
        heightIndex.put(block.getIndex(), block);
    }

    // 根据哈希查询区块
    public Block getBlockByHash(String hash) {
        return hashIndex.get(hash);
    }

    // 根据高度查询区块
    public Block getBlockByHeight(int height) {
        return heightIndex.get(height);
    }
}
