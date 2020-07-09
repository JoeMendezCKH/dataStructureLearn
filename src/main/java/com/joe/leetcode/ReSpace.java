package com.joe.leetcode;

import java.util.*;

/**
 * 面试题 17.13. 恢复空格
 * <p>
 * 你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
 * 像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
 * 在处理标点符号和大小写之前，你得先把它断成词语。
 * 你有一本厚厚的词典dictionary，不过，有些词没在词典里。
 * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * 示例：
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * <p>
 * 提示：
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 *
 * @author Joe
 * @create 2020/7/9 10:07
 */
public class ReSpace {
    public static void main(String[] args) {


        String[] dictionary = {"looked", "just", "like", "her", "brother"};
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(reSpace1(dictionary, sentence));
    }

    /**
     * 暴力法
     * 811 ms, 在所有 Java 提交中击败了35.08%, 竟然也过了
     * <p>
     * https://leetcode-cn.com/problems/re-space-lcci/solution/cong-bao-li-ru-shou-you-hua-yi-ji-triezi-dian-shu-/
     */
    public static int reSpace1(String[] dictionary, String sentence) {

        Set<String> dic = new HashSet<>();
        Collections.addAll(dic, dictionary);

        int sentenceLength = sentence.length();
        // dp[i] 表示 sentence 前 i 个字符 有 dp[i] 个字符未匹配
        int[] dp = new int[sentenceLength + 1];

        for (int i = 1; i <= sentenceLength; i++) {
            // 先假设当前字符作为单词不在字典中, 也就是每次都假设新的字符都不匹配
            dp[i] = dp[i - 1] + 1;

            for (int j = 0; j < i; j++) {
                /*
                每次遍历 (0, i) 的字符, 有没有子字符串 (j,i)是匹配的
                如果匹配上了, 那么, dp[i] 就可以减去 (j,i)的长度
                也就是说, dp[i] 可以直接用 dp[j] 来替换
                但是, 即使前面存在匹配的单词，也不能保证哪一种剩下的字符最少
                匹配最后一位 r , 可以先匹配 brother, 然后匹配 her, 如果直接替换就失去了 brot 4个字符
                所以要用  Math.min(dp[i], dp[j])
                也就是说, 除了 每次默认+1 外, 保证dp[i] 只会减小, 不会增大
                 */
                if (dic.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                    // dp[i] = dp[j];
                }
            }
        }
        return dp[sentenceLength];
    }

    /**
     * 优化暴力法
     * 对于每一个i，它前面的子字符串都被找了个遍，这其中包括一些根本不可能在字典中出现的单词。需要找一个方法提前结束
     * <p>
     * 一种方法是记录字典中每个单词最后一个字符，如果想匹配的字符串的最后一个字母都不在字典里，就没必要再看这个字符串了；
     * 此外，即使字符串最后一个字母在词典里，也不用挨个去找[j,i)子字符串是否匹配，即不需要让j从0到i遍历一遍，只要看对应长度的子串在不在词典里即可
     * <p>
     * 作者：tian-ye
     * 链接：https://leetcode-cn.com/problems/re-space-lcci/solution/cong-bao-li-ru-shou-you-hua-yi-ji-triezi-dian-shu-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int reSpace2(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>();
        Collections.addAll(dic, dictionary);

        // <最后一个字符，这样的单词长度集合>
        Map<Character, Set<Integer>> map = new HashMap<>(16);
        for (String str : dictionary) {
            int len = str.length();
            char c = str.charAt(len - 1);
            Set<Integer> set = map.getOrDefault(c, new HashSet<>());
            set.add(len);

            map.put(c, set);
        }

        int sentenceLength = sentence.length();
        int[] dp = new int[sentenceLength + 1];
        for (int i = 1; i <= sentenceLength; i++) {
            dp[i] = dp[i - 1] + 1;

            char c = sentence.charAt(i - 1);
            if (map.containsKey(c)) {
                Set<Integer> lens = map.get(c);
                // 提交时使用迭代期比 foreach 慢一点点
                for (int keyLength : lens) {
                    // 判断当前长度的单词是否匹配
                    if (i >= keyLength && dic.contains(sentence.substring(i - keyLength, i))) {
                        dp[i] = Math.min(dp[i], dp[i - keyLength]);
                    }
                }
            }
        }
        return dp[sentenceLength];
    }

    // ================== trie 字典树

    /**
     * 空白的根节点，设为全局变量更醒目
     */
    TrieNode root;

    public int reSpace3(String[] dictionary, String sentence) {
        root = new TrieNode();
        //创建字典树
        makeTrie(dictionary);

        int sentenceLength = sentence.length();
        int[] dp = new int[sentenceLength + 1];

        // 这里从sentence最后一个字符开始
        for (int i = sentenceLength - 1; i >= 0; i--) {
            // 初始默认后面全不匹配
            dp[i] = sentenceLength - i;
            TrieNode node = root;
            for (int j = i; j < sentenceLength; j++) {
                int c = sentence.charAt(j) - 'a';
                int min = Math.min(dp[i], j - i + 1 + dp[j + 1]);

                if (node.children[c] == null) {
                    //例如"abcde",i=1,j=2 可找出长度关系
                    dp[i] = min;
                    break;
                }
                if (node.children[c].isWord) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                } else {
                    dp[i] = min;
                }
                node = node.children[c];
            }
        }
        return dp[0];
    }

    public void makeTrie(String[] dictionary) {
        for (String str : dictionary) {
            TrieNode node = root;
            for (int k = 0; k < str.length(); k++) {
                // 在 26 个字母中的排位, 第 i 位
                int i = str.charAt(k) - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
            }
            // 单词的结尾
            node.isWord = true;
        }
    }


    /**
     * 自定义一个TrieNode类型。
     * 这里不用建一个变量来存当前节点表示的字符，
     * 因为只要该节点不为null，就说明存在这个字符
     */
    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            // 26 个字母
            children = new TrieNode[26];
            isWord = false;
        }
    }

}
