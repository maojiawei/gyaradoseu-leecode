package io.jovi.gyaradoseu.algorithm.java.collection;

import com.google.common.collect.Maps;
import io.jovi.gyaradoseu.algorithm.hash.consistent.ConsistentHashingNoVirtualNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
public class HashMapTest {
    @Test
    public void ConsistentHashLoadBalanceNoVirtualNode(){
        Map<String,String> params = new HashMap<>(1);
        params.put("test","test");
        params.put("text","text");
    }
}
