/**
 * 哈希时间锁 - 跨链交易核心
 * 功能：生成哈希锁、验证密钥、解锁资产
 */
public class HashLock {
    private final String secretHash;
    private final long expireTime;
    private boolean isUnlocked;

    public HashLock(String secret, long expireSeconds) {
        this.secretHash = SHA256Encrypt.encrypt(secret);
        this.expireTime = System.currentTimeMillis() + expireSeconds * 1000;
        this.isUnlocked = false;
    }

    // 解锁资产
    public boolean unlock(String secret) {
        if (!isUnlocked && System.currentTimeMillis() < expireTime && SHA256Encrypt.encrypt(secret).equals(secretHash)) {
            isUnlocked = true;
            return true;
        }
        return false;
    }

    public boolean isUnlocked() { return isUnlocked; }
}
