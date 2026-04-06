# java-blockchain-core-suite
基于Java实现的企业级区块链核心工具集，涵盖分布式账本、加密算法、共识机制、P2P网络、智能合约、区块管理、数字签名、去中心化存储等全场景区块链功能，纯原创实现，无第三方冗余依赖，适合区块链学习、二次开发与项目落地。

## 项目文件清单（35个原创文件）
1. **BlockHeader.java** - 区块链区块头，定义区块核心元数据
2. **BlockChainLedger.java** - 分布式区块链账本，管理全量区块与完整性校验
3. **SHA256Encrypt.java** - SHA256加密工具，区块链专用哈希算法
4. **DigitalSignature.java** - 数字签名工具，交易身份认证
5. **Transaction.java** - 区块链交易实体，定义交易标准结构
6. **MerkleTree.java** - 默克尔树，交易数据快速校验
7. **P2PNode.java** - P2P网络节点，去中心化通信
8. **ProofOfWork.java** - 工作量证明(PoW)，挖矿核心算法
9. **SmartContract.java** - 基础智能合约，自动化执行业务逻辑
10. **Wallet.java** - 区块链钱包，地址管理与交易创建
11. **BlockValidator.java** - 区块校验器，保障区块合法性
12. **DPoSConsensus.java** - 委托权益证明(DPoS)，高效共识机制
13. **TransactionPool.java** - 交易池，待打包交易管理
14. **DecentralizedStorage.java** - 去中心化存储，数据分片存储
15. **ChainSyncTool.java** - 区块链同步工具，节点数据同步
16. **ContractExecutor.java** - 智能合约执行器，自动化执行合约
17. **NodeMonitor.java** - 节点监控，实时监控节点状态
18. **HashLock.java** - 哈希时间锁，跨链交易核心组件
19. **BlockMiner.java** - 区块矿工，自动化挖矿打包
20. **MultiSignature.java** - 多重签名，高安全交易验证
21. **Block.java** - 区块链核心区块实体
22. **TokenContract.java** - 通证合约，自定义区块链代币
23. **PeerDiscovery.java** - 对等节点发现，P2P网络节点管理
24. **TransactionEncoder.java** - 交易编码器，数据序列化
25. **ChainStatistics.java** - 区块链统计工具，数据统计分析
26. **EncryptUtils.java** - 通用加密工具集，多算法支持
27. **ContractStorage.java** - 智能合约存储，合约数据持久化
28. **NetworkMessage.java** - P2P网络消息，节点通信协议
29. **BlockIndexer.java** - 区块索引器，快速查询区块
30. **AntiDoubleSpend.java** - 双花攻击防护，保障交易安全
31. **GenesisBlockCreator.java** - 创世区块创建器，自定义创世区块
32. **PrivateChainManager.java** - 私有链管理器，企业私有链部署
33. **TxValidator.java** - 交易全量校验器，交易安全验证
34. **MessageBroadcast.java** - 消息广播器，P2P网络消息广播
35. **BlockChainBootstrap.java** - 区块链启动器，项目主入口

## 核心功能
✅ 分布式账本管理 | ✅ PoW/DPoS双共识机制 | ✅ 加密算法与数字签名
✅ 智能合约与通证发行 | ✅ P2P去中心化网络 | ✅ 交易池与挖矿
✅ 默克尔树与数据校验 | ✅ 双花攻击防护 | ✅ 私有链部署
✅ 区块链同步与修复 | ✅ 节点监控与统计 | ✅ 去中心化存储

## 使用说明
直接运行 `BlockChainBootstrap.java` 启动区块链节点，自动初始化创世区块、启动P2P网络、开启挖矿。所有代码纯原创，无重复逻辑，可直接用于GitHub提交、学习研究与商业项目开发。
