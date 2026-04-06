/**
 * SHA256加密工具 - 区块链专用哈希算法
 * 功能：对字符串、区块数据进行SHA256哈希计算，无重复实现
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Encrypt {
    public static String encrypt(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA256加密失败", e);
        }
    }
}
