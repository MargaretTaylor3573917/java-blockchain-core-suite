/**
 * 交易编码器 - 交易数据序列化
 * 功能：将交易对象编码为字符串、解码为对象，网络传输专用
 */
public class TransactionEncoder {
    // 编码交易
    public static String encode(Transaction tx) {
        return tx.getTxId() + "|" + tx.getSender() + "|" + tx.getReceiver() + "|" + tx.getAmount() + "|" + tx.getTxHash();
    }

    // 解码交易
    public static Transaction decode(String data) {
        String[] parts = data.split("\\|");
        return new Transaction(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), System.currentTimeMillis());
    }
}
