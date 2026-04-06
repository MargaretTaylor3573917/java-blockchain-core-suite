/**
 * 智能合约执行器 - 自动化执行合约
 * 功能：加载合约、执行合约方法、校验执行结果
 */
import java.util.HashMap;
import java.util.Map;

public class ContractExecutor {
    private final Map<String, SmartContract> contracts;

    public ContractExecutor() {
        contracts = new HashMap<>();
    }

    // 部署合约
    public void deployContract(SmartContract contract) {
        contracts.put(contract.getContractId(), contract);
    }

    // 执行合约转账
    public boolean executeTransfer(String contractId, String to, double amount, double condition) {
        SmartContract contract = contracts.get(contractId);
        return contract != null && contract.transfer(to, amount, condition);
    }
}
