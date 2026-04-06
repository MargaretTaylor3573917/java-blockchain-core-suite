/**
 * 消息广播器 - P2P网络广播工具
 * 功能：广播交易、广播区块、广播同步请求
 */
public class MessageBroadcast {
    private final P2PNode localNode;

    public MessageBroadcast(P2PNode localNode) {
        this.localNode = localNode;
    }

    // 广播交易
    public void broadcastTx(Transaction tx) {
        System.out.println("节点" + localNode.getNodeId() + "广播交易：" + tx.getTxId());
    }

    // 广播区块链同步请求
    public void broadcastSyncRequest() {
        System.out.println("节点" + localNode.getNodeId() + "发起区块链同步请求");
    }
}
