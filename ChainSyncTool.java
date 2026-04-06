/**
 * 区块链同步工具 - 节点间数据同步
 * 功能：对比区块高度、同步缺失区块、修复区块链
 */
public class ChainSyncTool {
    // 同步区块链
    public static void syncChain(BlockChainLedger local, BlockChainLedger remote) {
        if (remote.getLastBlock().getIndex() > local.getLastBlock().getIndex()) {
            // 模拟同步逻辑
            System.out.println("本地区块链低于远程，开始同步...");
            local.addBlock(remote.getLastBlock());
            System.out.println("区块链同步完成！");
        }
    }

    // 修复区块链
    public static boolean repairChain(BlockChainLedger ledger) {
        if (!ledger.isChainValid()) {
            // 简易修复：重置为创世区块
            ledger = new BlockChainLedger();
            return true;
        }
        return false;
    }
}
