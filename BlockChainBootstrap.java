/**
 * 区块链启动器 - 项目主入口
 * 功能：初始化区块链、启动节点、开启挖矿、加载核心组件
 */
public class BlockChainBootstrap {
    public static void main(String[] args) throws Exception {
        // 初始化核心组件
        BlockChainLedger ledger = new BlockChainLedger();
        TransactionPool txPool = new TransactionPool();
        P2PNode node = new P2PNode("main-node-01");
        BlockMiner miner = new BlockMiner(node, txPool, ledger);
        
        // 启动挖矿
        miner.startMining();
        
        // 打印区块链状态
        System.out.println("区块链启动成功！当前区块高度：" + ledger.getLastBlock().getIndex());
        System.out.println("区块链完整性：" + ledger.isChainValid());
    }
}
