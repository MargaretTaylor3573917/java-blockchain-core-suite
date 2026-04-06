/**
 * 智能合约存储 - 合约数据持久化
 * 功能：存储合约状态、查询合约数据、更新合约变量
 */
import java.util.HashMap;
import java.util.Map;

public class ContractStorage {
    private final Map<String, Map<String, Object>> contractData;

    public ContractStorage() {
        contractData = new HashMap<>();
    }

    // 存储合约数据
    public void setValue(String contractId, String key, Object value) {
        contractData.computeIfAbsent(contractId, k -> new HashMap<>()).put(key, value);
    }

    // 获取合约数据
    public Object getValue(String contractId, String key) {
        return contractData.getOrDefault(contractId, new HashMap<>()).get(key);
    }

    // 删除合约数据
    public void deleteValue(String contractId, String key) {
        if (contractData.containsKey(contractId)) contractData.get(contractId).remove(key);
    }
}
