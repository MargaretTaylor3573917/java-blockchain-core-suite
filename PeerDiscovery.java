/**
 * 对等节点发现 - P2P网络核心
 * 功能：扫描网络节点、自动添加节点、维护节点列表
 */
import java.util.ArrayList;
import java.util.List;

public class PeerDiscovery {
    private final List<P2PNode> networkNodes;

    public PeerDiscovery() {
        networkNodes = new ArrayList<>();
    }

    // 扫描网络节点
    public void scanNetwork() {
        // 模拟网络扫描
        System.out.println("正在扫描区块链P2P网络节点...");
    }

    // 注册节点
    public void registerNode(P2PNode node) {
        if (!networkNodes.contains(node)) networkNodes.add(node);
    }

    // 获取所有在线节点
    public List<P2PNode> getOnlineNodes() {
        return new ArrayList<>(networkNodes);
    }
}
