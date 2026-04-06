/**
 * 委托权益证明共识 - DPoS原创实现
 * 功能：节点投票，选举记账节点，生成区块
 */
import java.util.HashMap;
import java.util.Map;

public class DPoSConsensus {
    private final Map<String, Integer> nodeVotes;
    private static final int DELEGATE_COUNT = 5;

    public DPoSConsensus() {
        nodeVotes = new HashMap<>();
    }

    // 节点投票
    public void voteNode(String nodeId, int votes) {
        nodeVotes.put(nodeId, nodeVotes.getOrDefault(nodeId, 0) + votes);
    }

    // 选举记账节点
    public String electDelegate() {
        return nodeVotes.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    // 记账节点生成区块
    public Block generateBlock(String nodeId, BlockChainLedger ledger, String data) {
        Block last = ledger.getLastBlock();
        long nonce = ProofOfWork.mine(last);
        return new Block(last.getIndex() + 1, last.getBlockHash(), System.currentTimeMillis(), data, nonce);
    }
}
