package top.parak.DataStructures.HaffmanTree;

import java.io.*;
import java.util.*;

/**
 * @author KHighness
 * @since 2021-03-13
 * @apiNote 哈夫曼编码
 */
public class HuffmanCode {

    static class TreeNode implements Comparable<TreeNode> {
        /* ascii */
        Byte data;
        /* 权值 */
        Integer weight;
        /* 左子 */
        TreeNode left;
        /* 右子 */
        TreeNode right;

        public TreeNode(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "[data=" + data + ", weight = " + weight + "]";
        }

        @Override
        public int compareTo(TreeNode o) {
            return this.weight - o.weight;
        }
    }

    /* 哈夫曼编码表 */
    static Map<Byte, String> huffmanCodes = new HashMap<>();

    /**
     * 哈夫曼编码后的字节数组
     * @param bytes 字符串的字节数组
     * @return 字节数组
     */
    public static byte[] huffmanCompress(byte[] bytes) {
        List<TreeNode> nodes = getNodes(bytes);
        TreeNode huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodes = getHuffmanCodes(huffmanTreeRoot);
        byte[] compressByte = compressByte(bytes, huffmanCodes);
        return compressByte;
    }

    /**
     * 统计每个字符的出现次数
     * @param bytes 字节数组
     * @return 结点数组
     */
    private static List<TreeNode> getNodes(byte[] bytes) {
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        List<TreeNode> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new TreeNode(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 根据结点建立哈夫曼树
     * @param nodes 结点数组
     * @return 哈夫曼树的根结点
     */
    private static TreeNode createHuffmanTree(List<TreeNode> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            TreeNode leftNode = nodes.get(0);
            TreeNode rightNode = nodes.get(1);
            TreeNode parent = new TreeNode(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 获取哈夫曼树的所有叶子结点的哈夫曼编码
     * @param root 哈夫曼树的根节点
     * @return 哈夫曼编码表
     */
    public static Map<Byte, String> getHuffmanCodes(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        getHuffmanCodes(root.left, "0", stringBuilder);
        getHuffmanCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 获取传入的node结点的所有叶子结点的哈夫曼编码。并存到huffmanCodes中
     * @param treeNode      传入结点
     * @param code          路径(左0右1)
     * @param sb            拼接路径
     */
    private static void getHuffmanCodes(TreeNode treeNode, String code, StringBuilder sb) {
        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(code);
        if (treeNode != null) {
            if (treeNode.data == null) { // 非叶子结点
                getHuffmanCodes(treeNode.left, "0", stringBuilder);  // 向左递归
                getHuffmanCodes(treeNode.right, "1", stringBuilder); // 向右递归
            } else { // 叶子结点
                huffmanCodes.put(treeNode.data, stringBuilder.toString());
            }
        }
    }

    /**
     * 将字符串的字节数组转换成哈夫曼编码处理后的字节数组
     * 将字节数组每个字节对应的哈夫曼编码拼接起来，形成二进制字符串
     * 将二进制字符串01010101... -> 十进制数字(byte)
     * @param bytes         原始字符串字节数组
     * @return 哈夫曼字节数组
     */
    private static byte[] compressByte(byte[] bytes, Map<Byte, String> huffmanCodes) {
        // 将重新编码后的字符串拼接起来
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        // 拼接后的字符串都是01···，每8位对应一个byte
        // 简写：int len = (stringBuilder.length() + 7) / 8;
        int len = (stringBuilder.length() % 8 == 0) ? stringBuilder.length() / 8 : stringBuilder.length() / 8 + 1;
        // 压缩后的byte数组
        int index = 0;
        byte[] huffmanCodeBytes = new byte[len];
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) { // StringBuilder最后不足8位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return huffmanCodeBytes;
    }

    /**
     * 将一个字节转成一个二进制的字符串
     * @param flag  标识是否需要补高位，最后一个字节无需补高位
     * @param b     字节数
     * @return 二进制字符串
     */
    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        if (flag) { // 正数补高位
            temp |= 256;                               // 按位与
        }
        String str = Integer.toBinaryString(temp);     // temp对应的二进制补码
        if (flag) {
            return str.substring(str.length() - 8);    // 1byte=8bit，取后8位
        } else {
            return str;
        }
    }

    /**
     * 将哈夫曼字节数组转换成原字符串对应的字节数组
     * @param huffmanBytes 哈夫曼字节数组
     * @return 原来的字符串字节数组
     */
    public static byte[] decompressCode(byte[] huffmanBytes, Map<Byte, String> huffmanCodes) {
        // 拼接原始二进制字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte huffmanByte = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanByte));
        }
        // 把二进制按照哈夫曼编码表进行解码
        // 反转哈夫曼编码表，因为需要根据二进制字符串查找原字符串
        Map<String, Byte> reverseCodes = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            reverseCodes.put(entry.getValue(), entry.getKey());
        }
        // 存放解码后的字节
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length();) {
            int index = 1;
            while (true) {
                // 取出一个字符
                String key = stringBuilder.substring(i, i + index);
                if (!reverseCodes.containsKey(key)) { // 未匹配到
                    index++;
                } else { // 匹配到
                    list.add(reverseCodes.get(key));
                    i += index;
                    break;
                }
            }
        }
        // 将list转换成byte[]
        byte[] stringBytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            stringBytes[i] = list.get(i);
        }
        return stringBytes;
    }

    /**
     * 压缩文件
     * @param src 待压缩文件完全路径
     * @param des 压缩后文件完全路径
     */
    public static void compressFile(String src, String des) {
        InputStream input = null;
        OutputStream output = null;
        ObjectOutputStream objectOutput = null;
        try {
            // 将文件内容读取到字节数组
            input = new FileInputStream(src);
            byte[] bytes = new byte[input.available()];
            input.read(bytes);
            byte[] compressCode = huffmanCompress(bytes);
            // 将压缩内容写入对象输出流，便于恢复文件
            // 注意一定要把哈夫曼编码写入到压缩文件
            output = new FileOutputStream(des);
            objectOutput = new ObjectOutputStream(output);
            objectOutput.writeObject(compressCode);
            objectOutput.writeObject(huffmanCodes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
                if (objectOutput != null) {
                    objectOutput.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 解压文件
     * @param src 待解压文件完全路径
     * @param des 解压后文件完全路径
     */
    public static void decompressFile(String src, String des) {
        InputStream input = null;
        OutputStream output = null;
        ObjectInputStream objectInput = null;
        try {
            // 将文件内容读取到字节数组
            input = new FileInputStream(src);
            objectInput = new ObjectInputStream(input);
            byte[] compressCode = (byte[]) objectInput.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) objectInput.readObject();
            // 将解压缩内容写入到输出流
            byte[] decompressCode = decompressCode(compressCode, huffmanCodes);
            output = new FileOutputStream(des);
            output.write(decompressCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
                if (objectInput != null) {
                    objectInput.close();
                }
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 测试压缩与解压字符串
        String str = "i like like like java do you like a java";
        byte[] content = str.getBytes();
        byte[] compress = huffmanCompress(content);
        byte[] decompress = decompressCode(compress, huffmanCodes);
        System.out.println(new String(decompress));
         // 测试压缩与解压文件
         compressFile("C:/Users/18236/Desktop/K.jpg", "C:/Users/18236/Desktop/K-ZIP.zip");
         decompressFile("C:/Users/18236/Desktop/K-ZIP.zip", "C:/Users/18236/Desktop/K-UNZIP.png");
    }
}
