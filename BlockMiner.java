/**
 * 区块矿工 - 自动化挖矿工具
 * 功能：监听交易池、打包交易、生成区块、广播区块
 */
public class BlockMiner {
    private final P2PNode node;
    private final TransactionPool txPool;
    private final BlockChainLedger ledger;

    public BlockMiner(P2PNode node, TransactionPool txPool, BlockChainLedger ledger) {
        this.node = node;
        this.txPool = txPool;
        this.ledger = ledger;
    }

    // 挖矿主逻辑
    public void startMining() {
        if (txPool.getPendingTransactions().isEmpty()) return;
        Block lastBlock = ledger.getLastBlock();
        long nonce = ProofOfWork.mine(lastBlock);
        Block newBlock = new Block(lastBlock.getIndex() + 1, lastBlock.getBlockHash(), System.currentTimeMillis(), "打包交易", nonce);
        ledger.addBlock(newBlock);
        node.broadcastBlock(newBlock);
        txPool.clearProcessedTxs();
        System.out.println("挖矿成功！新区块哈希：" + newBlock.getBlockHash());
    }
}
