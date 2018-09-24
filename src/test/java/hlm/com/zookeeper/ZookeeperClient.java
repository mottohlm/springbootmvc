//package hlm.com.zookeeper;
//
//import java.util.concurrent.CountDownLatch;
//
//
///**
// * zookeeper 客户端，用于获取zookeeper 连接实例
// */
//public class ZookeeperClient {
//
//    /**
//     * 服务器连接地址
//     */
//    private static  String CONECTION_STRING = "10.1.10.41:2181";
//    /*
//    超时时间
//     */
//    private static int  sessionTimeOut = 60000 ;
//
//    public ZooKeeper getClient(){
//
//        final CountDownLatch connectedSignal = new CountDownLatch(1);
//
//        ZooKeeper zk = new ZooKeeper();
//
//        return zk ;
//    }
//
//    public static String getConectionString() {
//        return CONECTION_STRING;
//    }
//
//    public static void setConectionString(String conectionString) {
//        CONECTION_STRING = conectionString;
//    }
//
//    public static int getSessionTimeOut() {
//        return sessionTimeOut;
//    }
//
//    public static void setSessionTimeOut(int sessionTimeOut) {
//        ZookeeperClient.sessionTimeOut = sessionTimeOut;
//    }
//}
