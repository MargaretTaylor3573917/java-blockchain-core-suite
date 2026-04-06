/**
 * 交易池 - 待打包交易管理
 * 功能：添加交易、移除交易、获取待打包交易、校验交易
 */
import java.util.ArrayList;
import java.util.List;

public class TransactionPool {
    private final List<Transaction> pendingTxs;

    public TransactionPool() {
        pendingTxs = new ArrayList<>();
    }

    // 添加待确认交易
    public void addTransaction(Transaction tx) {
        if (validateTransaction(tx)) pendingTxs.add(tx);
    }

    // 校验交易合法性
    private boolean validateTransaction(Transaction tx) {
        return tx.getAmount() > 0 && !tx.getTxId().isEmpty();
    }

    // 获取所有待打包交易
    public List<Transaction> getPendingTransactions() {
        return new ArrayList<>(pendingTxs);
    }

    // 清空已打包交易
    public void clearProcessedTxs() {
        pendingTxs.clear();
    }
}
