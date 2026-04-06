/**
 * 私有链管理器 - 企业级私有区块链
 * 功能：创建私有链、授权节点、管理权限
 */
import java.util.HashSet;
import java.util.Set;

public class PrivateChainManager {
    private final Set<String> authorizedNodes;
    private final BlockChainLedger privateChain;

    public PrivateChainManager() {
        authorizedNodes = new HashSet<>();
        privateChain = new BlockChainLedger();
    }

    // 授权节点加入私有链
    public void authorizeNode(String nodeId) {
        authorizedNodes.add(nodeId);
    }

    // 校验节点权限
    public boolean isNodeAuthorized(String nodeId) {
        return authorizedNodes.contains(nodeId);
    }

    public BlockChainLedger getPrivateChain() { return privateChain; }
}
