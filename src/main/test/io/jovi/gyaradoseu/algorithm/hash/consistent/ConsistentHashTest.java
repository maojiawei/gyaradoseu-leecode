package io.jovi.gyaradoseu.algorithm.hash.consistent;

import org.junit.Test;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class ConsistentHashTest {
    @Test
    public void ConsistentHashLoadBalanceNoVirtualNode(){
        String[] nodes = new String[]{"192.168.2.1:8080", "192.168.2.2:8080", "192.168.2.3:8080", "192.168.2.4:8080"};
        ConsistentHashingNoVirtualNode consistentHash = new ConsistentHashingNoVirtualNode(nodes);
        consistentHash.printTreeNode();
        String[] keys = {"gyaradoseu", "magikarp", "squirtle"};
        for(int i=0; i<keys.length; i++){
            System.out.println("[" + keys[i] + "]的hash值为" + consistentHash.hash(keys[i],0)
                    + ", 被路由到结点[" + consistentHash.selectNode(keys[i]) + "的hash值"
                    +consistentHash.hash(consistentHash.selectNode(keys[i]),0)+ "]");
        }

    }
}
