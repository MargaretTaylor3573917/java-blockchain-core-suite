/**
 * 分布式区块链账本 - 原创实现
 * 功能：管理全量区块，校验区块链完整性，新增区块，查询区块
 */
import java.util.ArrayList;
import java.util.List;

public class BlockChainLedger {
    private final List<Block> chain;
    private static final int GENESIS_BLOCK_INDEX = 0;

    public BlockChainLedger() {
        chain = new ArrayList<>();
        createGenesisBlock();
    }

    // 创建创世区块
    private void createGenesisBlock() {
        Block genesis = new Block(GENESIS_BLOCK_INDEX, "0", System.currentTimeMillis(), "创世区块数据", 0);
        chain.add(genesis);
    }

    // 添加新区块
    public void addBlock(Block block) {
        if (validateNewBlock(block)) {
            chain.add(block);
        }
    }

    // 校验新区块合法性
    private boolean validateNewBlock(Block block) {
        Block lastBlock = getLastBlock();
        return block.getIndex() == lastBlock.getIndex() + 1 && block.getPreviousHash().equals(lastBlock.getBlockHash());
    }

    // 获取最后一个区块
    public Block getLastBlock() {
        return chain.get(chain.size() - 1);
    }

    // 校验整个区块链完整性
    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block previous = chain.get(i - 1);
            if (!current.getPreviousHash().equals(previous.getBlockHash())) return false;
        }
        return true;
    }
}
