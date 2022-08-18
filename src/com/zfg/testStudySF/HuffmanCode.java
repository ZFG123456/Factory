package com.zfg.testStudySF;

import java.util.*;

/**
 * @ClassName HuffmanCode
 * @Description 哈夫曼编码
 * @Author zfg
 * @Date 2022/8/16 下午 05:01
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] strBytes = str.getBytes();
        //40
        System.out.println(strBytes.length);
        List<HuffNode> nodes = getNodes(strBytes);
        System.out.println("哈夫曼树:");
        HuffNode root = huffmanTree(nodes);
        preOder(root);
        getCode(root, "", stringBuilder);
        System.out.println();
        System.out.println("生成的哈夫曼表是:" + huffmanCode);
//        for (Byte b : huffmanCode.keySet()) {
//            System.out.println(b+"->"+huffmanCode.get(b));
//        }

    }

    //获得对应字符次数的node集合
    public static List<HuffNode> getNodes(byte[] strBytes) {

        List<HuffNode> nodes = new ArrayList<>();
        //统计字符出现的次数--->map
        Map<Byte, Integer> counts = new HashMap<>();

        for (byte b : strBytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //输出
        for (Byte b : counts.keySet()) {
            System.out.println(b + ":" + counts.get(b));
            nodes.add(new HuffNode(b, counts.get(b)));
        }
        //输出nodes
        for (HuffNode temp : nodes) {
            System.out.println(temp);
        }

        return nodes;

    }

    //创建哈夫曼树
    public static HuffNode huffmanTree(List<HuffNode> nodes) {

        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取前两个结点构建二叉树
            HuffNode leftNode = nodes.get(0);
            HuffNode rightNode = nodes.get(1);
            HuffNode parent = new HuffNode(null, leftNode.weight + rightNode.weight);
            //左右子节点指向父节点
            parent.left = leftNode;
            parent.right = rightNode;
            //移除创建完的结点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //加入新的二叉树
            nodes.add(parent);
        }
        //最后的结点引用就是哈夫曼树
        return nodes.get(0);
    }

    //先序遍历
    public static void preOder(HuffNode root) {
        if (root == null) {
            System.out.println("二叉树为空!");
        } else {
            root.preOder();
        }
    }

    //生成哈夫曼编码表--->用map存放map<Byte,String>
    //1.保存编码
    static Map<Byte, String> huffmanCode = new HashMap<>();
    //2.拼接路径
    static StringBuilder stringBuilder = new StringBuilder();

    //路径code左子节点为0，右子节点为1
    public static void getCode(HuffNode node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        //将code加入
        stringBuilder1.append(code);
        if (node != null) {
            //判断当前结点是叶子结点还是非叶子结点
            //非叶子结点
            if (node.data == null) {
                //向左递归
                getCode(node.left, "0", stringBuilder1);
                //向右递归
                getCode(node.right, "1", stringBuilder1);
                //叶子结点
            } else {
                huffmanCode.put(node.data, stringBuilder1.toString());
            }
        }
    }

}
