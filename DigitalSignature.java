/**
 * 数字签名工具 - 区块链交易认证
 * 功能：生成RSA密钥对、签名交易数据、验证签名合法性
 */
import java.security.*;
import java.util.Base64;

public class DigitalSignature {
    private KeyPair keyPair;

    public DigitalSignature() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        this.keyPair = generator.generateKeyPair();
    }

    // 签名数据
    public String signData(String data) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(data.getBytes());
        return Base64.getEncoder().encodeToString(signature.sign());
    }

    // 验证签名
    public boolean verifySignature(String data, String sign) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(keyPair.getPublic());
        signature.update(data.getBytes());
        return signature.verify(Base64.getDecoder().decode(sign));
    }

    public PublicKey getPublicKey() { return keyPair.getPublic(); }
}
