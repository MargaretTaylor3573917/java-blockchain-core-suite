/**
 * 通证合约 - 自定义区块链代币
 * 功能：发行代币、转账代币、查询余额、燃烧代币
 */
public class TokenContract {
    private final String tokenName;
    private final long totalSupply;
    private final java.util.Map<String, Long> balances;

    public TokenContract(String tokenName, long totalSupply) {
        this.tokenName = tokenName;
        this.totalSupply = totalSupply;
        this.balances = new java.util.HashMap<>();
        balances.put("root", totalSupply);
    }

    // 转账代币
    public boolean transfer(String from, String to, long amount) {
        if (balances.getOrDefault(from, 0L) >= amount) {
            balances.put(from, balances.get(from) - amount);
            balances.put(to, balances.getOrDefault(to, 0L) + amount);
            return true;
        }
        return false;
    }

    // 燃烧代币
    public void burn(String address, long amount) {
        if (balances.getOrDefault(address, 0L) >= amount) {
            balances.put(address, balances.get(address) - amount);
        }
    }

    public long getBalance(String address) { return balances.getOrDefault(address, 0L); }
    public String getTokenName() { return tokenName; }
}
