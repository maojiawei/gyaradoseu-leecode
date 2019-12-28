package io.jovi.gyaradoseu.algorithm.hash.consistent;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * Title: 一致性哈希算法（无虚拟结点）
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
public class ConsistentHashingNoVirtualNode {
    /**
     * 真实结点
     */
    private TreeMap<Long, String> realNodes = new TreeMap<>();
    /**
     * 结点
     */
    private String[] nodes;

    /**
     * 构造器 初始化结点数量
     * @param nodes
     */
    public ConsistentHashingNoVirtualNode(String[] nodes){
        this.nodes = nodes;
        init();
    }

    /**
     * 初始化哈希环
     * 循环计算每个node名称的哈希值，将其放入treeMap
     */
    private void init(){
        for (String nodeName: nodes) {
            realNodes.put(hash(nodeName, 0), nodeName);
        }
    }
    /**
     * 根据资源key选择返回相应的节点名称
     * @param key
     * @return 节点名称
     */
    public String selectNode(String key){
        Long hashOfKey = hash(key, 0);
        if (! realNodes.containsKey(hashOfKey)) {
            //ceilingEntry()的作用是得到比hashOfKey大的第一个Entry
            Map.Entry<Long, String> entry = realNodes.ceilingEntry(hashOfKey);
            if (entry != null){
                return entry.getValue();
            }
            else{
                return nodes[0];
            }
        }else{
            return realNodes.get(hashOfKey);
        }

    }

    /**
     *
     * @param nodeName
     * @param number
     * @return
     */
    public Long hash(String nodeName, int number) {
        byte[] digest = md5(nodeName);
        return (((long) (digest[3 + number * 4] & 0xFF) << 24)
                | ((long) (digest[2 + number * 4] & 0xFF) << 16)
                | ((long) (digest[1 + number * 4] & 0xFF) << 8)
                | (digest[number * 4] & 0xFF))
                & 0xFFFFFFFFL;
    }

    /**
     * md5加密
     * @param str
     * @return
     */
    public byte[] md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(str.getBytes("UTF-8"));
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void printTreeNode(){
        if (realNodes != null && ! realNodes.isEmpty()){
            realNodes.forEach((hashKey, node) ->
                    System.out.println(
                            new StringBuffer(node)
                                    .append(" ==> ")
                                    .append(hashKey)
                    )
            );
        }else{
            System.out.println("Cycle is Empty");
        }

    }
}
