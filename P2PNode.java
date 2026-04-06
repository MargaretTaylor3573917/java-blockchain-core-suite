/**
 * P2P网络节点 - 区块链去中心化通信
 * 功能：节点初始化、节点发现、广播区块、同步账本
 */
import java.util.ArrayList;
import java.util.List;

public class P2PNode {
    private final String nodeId;
    private final List<P2PNode> peerNodes;
    private BlockChainLedger localLedger;

    public P2PNode(String nodeId) {
        this.nodeId = nodeId;
        this.peerNodes = new ArrayList<>();
        this.localLedger = new BlockChainLedger();
    }

    // 添加对等节点
    public void addPeer(P2PNode node) {
        if (!peerNodes.contains(node)) peerNodes.add(node);
    }

    // 广播新区块到所有节点
    public void broadcastBlock(Block block) {
        for (P2PNode peer : peerNodes) {
            peer.receiveBlock(block);
        }
    }

    // 接收区块并同步账本
    public void receiveBlock(Block block) {
        localLedger.addBlock(block);
        System.out.println("节点" + nodeId + "同步区块成功：" + block.getBlockHash());
    }

    public String getNodeId() { return nodeId; }
}
