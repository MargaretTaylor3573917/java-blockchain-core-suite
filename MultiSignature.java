/**
 * 多重签名 - 区块链安全交易
 * 功能：多节点签名、验证多重签名、授权交易
 */
import java.util.ArrayList;
import java.util.List;

public class MultiSignature {
    private final List<DigitalSignature> signers;
    private final int requiredSigns;

    public MultiSignature(int requiredSigns) throws Exception {
        this.requiredSigns = requiredSigns;
        this.signers = new ArrayList<>();
        for (int i = 0; i < requiredSigns; i++) {
            signers.add(new DigitalSignature());
        }
    }

    // 多重签名数据
    public List<String> multiSign(String data) throws Exception {
        List<String> signs = new ArrayList<>();
        for (DigitalSignature signer : signers) {
            signs.add(signer.signData(data));
        }
        return signs;
    }

    // 验证多重签名
    public boolean verifyMultiSign(String data, List<String> signs) throws Exception {
        if (signs.size() < requiredSigns) return false;
        for (int i = 0; i < requiredSigns; i++) {
            if (!signers.get(i).verifySignature(data, signs.get(i))) return false;
        }
        return true;
    }
}
