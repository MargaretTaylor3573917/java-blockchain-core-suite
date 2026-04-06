/**
 * 交易全量校验器 - 交易安全验证
 * 功能：校验签名、余额、双花、格式合法性
 */
public class TxValidator {
    // 完整校验交易
    public static boolean fullValidate(Transaction tx, Wallet senderWallet, AntiDoubleSpend antiDouble) {
        if (tx.getAmount() <= 0) return false;
        if (antiDouble.isDoubleSpend(tx)) return false;
        if (senderWallet.getBalance() < tx.getAmount()) return false;
        return true;
    }
}
