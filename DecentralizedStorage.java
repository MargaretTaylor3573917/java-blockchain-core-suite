/**
 * 去中心化存储 - 区块链数据分片存储
 * 功能：数据分片、存储分片、获取完整数据
 */
import java.util.HashMap;
import java.util.Map;

public class DecentralizedStorage {
    private final Map<String, String> dataShards;

    public DecentralizedStorage() {
        dataShards = new HashMap<>();
    }

    // 数据分片存储
    public void storeShard(String shardId, String shardData) {
        dataShards.put(shardId, shardData);
    }

    // 获取分片数据
    public String getShard(String shardId) {
        return dataShards.get(shardId);
    }

    // 合并分片数据
    public String mergeShards(String[] shardIds) {
        StringBuilder fullData = new StringBuilder();
        for (String id : shardIds) {
            fullData.append(getShard(id));
        }
        return fullData.toString();
    }
}
