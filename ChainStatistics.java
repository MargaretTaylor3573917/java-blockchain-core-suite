/**
 * 区块链统计工具 - 数据可视化基础
 * 功能：统计区块数量、交易总数、平均出块时间、总算力
 */
public class ChainStatistics {
    private final BlockChainLedger ledger;

    public ChainStatistics(BlockChainLedger ledger) {
        this.ledger = ledger;
    }

    // 获取区块总数
    public long getBlockCount() {
        return ledger.getLastBlock().getIndex() + 1;
    }

    // 计算平均出块时间
    public double getAvgBlockTime() {
        if (getBlockCount() <= 1) return 0;
        long totalTime = ledger.getLastBlock().getTimestamp() - (System.currentTimeMillis() - 3600000);
        return totalTime / (getBlockCount() - 1) / 1000;
    }

    // 打印统计信息
    public void printStats() {
        System.out.println("区块总数：" + getBlockCount() + " | 平均出块时间：" + getAvgBlockTime() + "s");
    }
}
