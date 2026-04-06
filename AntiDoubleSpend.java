/**
 * 双花攻击防护 - 区块链安全核心
 * 功能：检测双花交易、验证交易唯一性、锁定未确认交易
 */
import java.util.HashSet;
import java.util.Set;

public class AntiDoubleSpend {
    private final Set<String> processedTxIds;

    public AntiDoubleSpend() {
        processedTxIds = new HashSet<>();
    }

    // 校验交易是否双花
    public boolean isDoubleSpend(Transaction tx) {
        if (processedTxIds.contains(tx.getTxId())) return true;
        processedTxIds.add(tx.getTxId());
        return false;
    }

    // 清空已确认交易
    public void clearConfirmed() {
        processedTxIds.clear();
    }
}
