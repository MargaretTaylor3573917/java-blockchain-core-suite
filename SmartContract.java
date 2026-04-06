/**
 * 基础智能合约 - 区块链自动化执行
 * 功能：定义合约规则，条件触发，执行转账逻辑
 */
public class SmartContract {
    private final String contractId;
    private double balance;
    private final String owner;

    public SmartContract(String contractId, String owner) {
        this.contractId = contractId;
        this.owner = owner;
        this.balance = 0;
    }

    // 合约存款
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    // 条件转账
    public boolean transfer(String to, double amount, double condition) {
        if (balance >= amount && amount <= condition) {
            balance -= amount;
            System.out.println("合约执行转账：" + amount + " 到 " + to);
            return true;
        }
        return false;
    }

    public double getBalance() { return balance; }
    public String getContractId() { return contractId; }
}
