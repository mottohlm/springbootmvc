package hlm.com.treemap;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 插入子节点方法 addNode(Node pNode , Node node ,Position position)
 * pNode 完父节点；node 即将要插入的节点；position；表示插入的位置，左left,右right
 * 着色方法 colorNode(Node node , Color color)
 * node 即将着色的节点；color 表示着色 红red 黑 black
 *
 */
public class MyTreeMap  {

    Logger log = LoggerFactory.getLogger(MyTreeMap.class) ;

    /**
     * 根节点
     */
    private Node root ;

    /**
     * 元素个数
     */
    private transient int size ;


    public int getSize(){
        return this.size ;
    }
    /**
     * 添加节点方法
     * @param k
     * @param v
     * @return
     */
    public Object put(Object k ,Object v){

        Node node = new Node(k , v);

        //没有根那么传进来的就是根
        if(root == null){
            root = node ;
            size ++ ;
            return root.getKey();
        }

       return addNode(root , node);
    }

    public Object get(Object k){
        Node node = get(this.root ,k);
        return node==null? null : node.getValue() ;
    }
    private Node get(Node node ,Object k){
        if(node == null){
            return null;
        }
        int tarkey = hash(k) ;
        int rootkey = hash(node.getKey());
        //命出马上返回
        if(tarkey == rootkey){
            return node ;
        }
        //在左分支
        if(tarkey < rootkey){
            return get(node.getLeft(),k);
        }
        //在右分支
        else if(tarkey > rootkey){
            return get(node.getRight(),k);
        }

        return null ;
    }

    /**
     * 返回root的中序遍历
     * @return
     */
    public List<Object> listNode(){

        if(this.root == null){
            return null;
        }
        List<Object> resultList = new ArrayList<Object>();
        midIteractor(this.root ,resultList );
        return resultList ;
    }

    /**
     * 中序遍历：左——>根——>右
     * @param node
     * @param resultList
     */
    private void midIteractor(Node node , List<Object> resultList){
        if(node == null){
            return ;
        }
        //当再无左子节点时，时候保存它的值了
        if(node.getLeft() != null ){
            midIteractor(node.getLeft() ,resultList);

        }

        resultList.add(node);

        if(node.getRight() != null){
            midIteractor(node.getRight() ,resultList);
        }
        return ;
    }

    /**
     * 往root所在树枝上插入node
     * @param root 检索起点
     * @param node 即插入的节点
     * @return 插入成功则返回插入节点的key,失败返回null
     */
    private Object addNode(Node root ,Node node){
        //起点不存在，那么返回null
        if(root == null ){
            return null ;
        }
        //插入节点为空，那无法插入
        if(node == null ){
            return null ;
        }
        Object targetKey = node.getKey();
        int tarint = hash(targetKey);
        Object rootKey = root.getKey();
        int rootint = hash(rootKey);
        //小于,左分支
        if(tarint < rootint){
            //存在左子节点时，递归检索进去
            if(root.getLeft() != null){
               return addNode(root.getLeft() , node);
            }else{
                root.setLeft(node);
                node.setParent(root);
                size ++ ;
                return node.getKey();
            }
        }

        //大于,右分支
        if(tarint > rootint){
            //存在右子节点时，递归检索进去
            if(root.getRight() != null){
                return addNode(root.getRight() , node);
            }else{
                root.setRight(node);
                node.setParent(root);
                size ++ ;
                return node.getKey();
            }
        }

        return null ;
    }

    /**
     * 处理Key 的统一方法
     * @param k
     * @return
     */
    private int hash(Object k){
        return k==null? 0 : k.hashCode();
    }
}
