/**
 * 节点监控 - 区块链节点状态管理
 * 功能：监控节点在线状态、区块高度、交易数量
 */
public class NodeMonitor {
    private final String nodeId;
    private boolean isOnline;
    private long blockHeight;
    private int txCount;

    public NodeMonitor(String nodeId) {
        this.nodeId = nodeId;
        this.isOnline = true;
        this.blockHeight = 0;
        this.txCount = 0;
    }

    // 更新节点状态
    public void updateStatus(boolean online, long height, int txs) {
        this.isOnline = online;
        this.blockHeight = height;
        this.txCount = txs;
    }

    // 打印节点状态
    public void printStatus() {
        System.out.println("节点：" + nodeId + " | 在线：" + isOnline + " | 区块高度：" + blockHeight + " | 交易数：" + txCount);
    }
}
