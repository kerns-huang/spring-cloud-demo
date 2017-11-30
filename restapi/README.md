面向客户端的模块

接口测试访问路径
http://127.0.0.1:8080/restapi/swagger-ui.html

依赖 : discover 模块和 contentCenter模块的启动

## zookeeper 客户端

### zkClient：
    zkClient主要做了两件事情。一件是在session loss和session expire时自动创建新的ZooKeeper实例进行重连。另一件是将一次性watcher包装为持久watcher。后者的具体做法是简单的在watcher回调中，重新读取数据的同时再注册相同的watcher实例。

### menagerie
    menagerie基于Zookeeper实现了java.util.concurrent包的一个分布式版本。
    这个封装是更大粒度上对各种分布式一致性使用场景的抽象。其中最基础和常用的是一个分布式锁的实现：
    org.menagerie.locks.ReentrantZkLock，通过ZooKeeper的全局有序的特性和EPHEMERAL_SEQUENTIAL类型znode的支持，实现了分布式锁。
    具体做法是：不同的client上每个试图获得锁的线程，都在相同的basepath下面创建一个EPHEMERAL_SEQUENTIAL的node。
    EPHEMERAL表示要创建的是临时znode，创建连接断开时会自动删除； SEQUENTIAL表示要自动在传入的path后面缀上一个自增的全局唯一后缀,作为最终的path。因此对不同的请求ZK会生成不同的后缀，并分别返回带了各自后缀的path给各个请求。
    因为ZK全局有序的特性，不管client请求怎样先后到达，在ZKServer端都会最终排好一个顺序，因此自增后缀最小的那个子节点，就对应第一个到达ZK的有效请求。
    然后client读取basepath下的所有子节点和ZK返回给自己的path进行比较，当发现自己创建的sequential node的后缀序号排在第一个时，就认为自己获得了锁；否则的话，就认为自己没有获得锁。
    这时肯定是有其他并发的并且是没有断开的client/线程先创建了node。