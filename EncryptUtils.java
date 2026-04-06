/**
 * 通用加密工具集 - 区块链扩展加密
 * 功能：Base64编解码、MD5加密、异或加密，多场景适配
 */
import java.util.Base64;

public class EncryptUtils {
    // Base64编码
    public static String base64Encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    // Base64解码
    public static byte[] base64Decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    // MD5加密
    public static String md5Encrypt(String data) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
