package com.jsako;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/7/8 10:31
 * @Description:
 */
public class RecoverIP {

    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     * <p>
     * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
     * <p>
     * 示例:
     * <p>
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     */
    public static void main(String[] args) {
        List<String> outputArr = new ArrayList<>();
        backstrack(0, 3, new LinkedList<>(), outputArr, "25525511135");
        outputArr.forEach(System.out::println);
    }

    /**
     * 最大字符串间隔
     */
    private final static int MAX_INTERVAL_POS = 3;

    /**
     * 回溯方法
     *
     * @param pos       字符串所在节点
     * @param dots      切割的节点树
     * @param tempArray 临时存放有效集合
     * @param outputArr 结果集合
     * @param ipStr     ip数据字符串
     */
    public static void backstrack(int pos, int dots, List<String> tempArray, List<String> outputArr, String ipStr) {
        int maxSearchPos = Math.min(ipStr.length() - 1, pos + MAX_INTERVAL_POS);
        for (int i = pos; i < maxSearchPos; i++) {
            String ipNode = ipStr.substring(pos, i + 1);
            if (validIpNode(ipNode)) {
                tempArray.add(ipNode);
                if (dots == 1) {
                    String lastIpNode = ipStr.substring(i + 1);
                    if (validIpNode(lastIpNode)) {
                        tempArray.add(lastIpNode);
                        outputArr.add(String.join(".", tempArray));
                        tempArray.remove(tempArray.size() - 1);
                    }
                } else {
                    backstrack(i + 1, dots - 1, tempArray, outputArr, ipStr);
                }
                tempArray.remove(tempArray.size() - 1);
            }
        }
    }

    /**
     * 校验ip节点是否合法
     *
     * @param ipNode
     * @return
     */
    private static boolean validIpNode(String ipNode) {
        int m = ipNode.length();
        if (m > 3) {
            return false;
        }
        return (ipNode.charAt(0) != '0') ? (Integer.parseInt(ipNode) <= 255) : (m == 1);
    }

}
