package top.parak.DataStructures.RBTree;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p> Project: Algorithm </P>
 * <p> Package: top.parak.DataStructures.RBTree </p>
 * <p> FileName: RBTree <p>
 * <p> Description: 红黑树 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/5
 */

/* 红黑颜色 */
enum RBTColor {
    red,
    black
}

/* 红黑结点 */
class RBTNode<T extends Comparable<T>, D> {

    /* 结点颜色 */
    private RBTColor color;
    /* 结点键值 */
    private T key;
    /* 结点数据 */
    private D data;
    /* 父亲结点 */
    private RBTNode<T, D> parent;
    /* 左子结点 */
    private RBTNode left;
    /* 右子结点 */
    private RBTNode right;

    public RBTNode(RBTColor color, T key, D data, RBTNode<T, D> parent, RBTNode left, RBTNode right) {
        this.color = color;
        this.key = key;
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public RBTColor getColor() {
        if (this != null) {
            return color;
        }
        return null;
    }

    public void setColor(RBTColor color) {
        this.color = color;
    }

    public void updateColor() {
        if (this.color == RBTColor.red) {
            this.color = RBTColor.black;
        } else {
            this.color = RBTColor.red;
        }
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public RBTNode<T, D> getParent() {
        return parent;
    }

    public void setParent(RBTNode<T, D> parent) {
        this.parent = parent;
    }

    public RBTNode getLeft() {
        return left;
    }

    public void setLeft(RBTNode left) {
        this.left = left;
    }

    public RBTNode getRight() {
        return right;
    }

    public void setRight(RBTNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "RBTNode[" +
                "color=" + color +
                ", key=" + key +
                ", data=" + data +
                ']';
    }
}

/* 红黑树 */
public class RedBlackTree<T extends Comparable<T>, D> {

    /* 时间格式 */
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* 根节点 */
    private RBTNode<T, D> root;

    /* 树结点数量 */
    private AtomicLong count = new AtomicLong(0);

    /**
     * <p>获取时间</p>
     * @return
     */
    private String getCurrentTime() {
        return SDF.format(new Date());
    }

    /**
     * <p>大小<p/>
     * @return
     */
    public long size() {
        return count.get();
    }

    /**
     * <p>查询</p>
     * @param key
     * @return
     */
    public D get(T key) {
        RBTNode<T, D> node = search(key, this.root);
        return node == null ? null : node.getData();
    }

    /**
     * <p>插入</p>
     * @param key
     * @param data
     */
    public void add(T key, D data) {
        insertNode(key, data);
    }

    /**
     * <p>删除</p>
     * @param key
     */
    public void del(T key) {
        RBTNode<T, D> node = search(key, this.root);
        if (node != null) {
            deleteNode(node);
        } else {
            System.out.println(getCurrentTime() + " [ERROR] " + "key为" + key + "的结点不存在");
        }
    }

    /**
     * <p>root-getter</p>
     * @return
     */
    public RBTNode<T, D> getRoot() {
        return root;
    }

    /**
     * <p>判断结点是否为红色</p>
     * @param node
     * @return
     */
    public Boolean isRed(RBTNode<T, D> node) {
        return node != null && node.getColor() == RBTColor.red;
    }

    /**
     * <p>判断结点是否为黑色</p>
     * @param node
     * @return
     */
    public Boolean isBlack(RBTNode<T, D> node) {
        return node == null || node.getColor() == RBTColor.black;
    }

    /**
     * <p>查询key值的结点</p>
     * <p>递归查询: 比较key，相等直接返回，过大则继续向右，过小则继续向左</p>
     * @param key
     * @param node
     * @return
     */
    public RBTNode<T, D> search(T key, RBTNode<T, D> node) {
        if (node != null) {
            int cmp = key.compareTo(node.getKey());
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                return search(key, node.getRight());
            } else if (cmp < 0) {
                return search(key, node.getLeft());
            }
        }
        return null;
    }

    /**
     * <p>左旋</p>
     * <p>过程：父亲下沉，右子上升，右子的左子变为原父的右子</p>
     * <p>
     *     左旋X结点
     *             P                                P
     *            /                                /
     *           X                                Y
     *         /  \        --(左旋)-->           / \
     *       lX    Y                           X  rY
     *            / \                        /  \
     *          lY   rY                     lX  lY
     * </p>
     * @param x
     */
    private void leftRotate(RBTNode<T, D> x) {
        /* 右子结点 */
        RBTNode<T, D> y = x.getRight();
        /* 父亲结点 */
        RBTNode<T, D> p = x.getParent();

        /* Y的左子 变成 X的右子
        * 若X不Y的左子不为空
        * 则设置Y的左子的父亲为X */
        x.setRight(y.getLeft());
        if (y.getLeft() != null) {
            y.getLeft().setParent(x);
        }

        /* 设置Y的父亲为P
        * 1. P为空，则根节点设置为Y
        * 2. X为P的左子， 则P的左子设置为Y
        * 3. X为P的右子，则P的右子设置为Y */
        y.setParent(p);
        if (p == null) {
            this.root = y;
        } else {
            if (p.getLeft() == x) {
                p.setLeft(y);
            } else {
                p.setRight(y);
            }
        }

        /* 将X的父亲设置为Y
        * 将Y的左子设置为X */
        x.setParent(y);
        y.setLeft(x);
    }

    /**
     * <p>右旋</p>
     * <p>过程：父亲下沉，左子上升，左子的右子变成原父的左子</p>
     * <p>
     *     右旋X结点
     *             P                                P
     *            /                                /
     *           X                                Y
     *         /  \        --(右旋)-->           /  \
     *        Y   rX                           lY   X
     *       / \                                   / \
     *     lY  rY                                rY  rX
     * </p>
     * @param x
     */
    private void rightRotate(RBTNode<T, D> x) {
        /* 左子结点 */
        RBTNode<T, D> y = x.getLeft();
        /* 父亲结点 */
        RBTNode<T, D> p = x.getParent();

        /* Y的右子 变成 X的左子
        * 若Y的右子不为空
        * 则设置Y的右子的父亲为X */
        x.setLeft(y.getRight());
        if (y.getRight() != null) {
            y.getRight().setParent(x);
        }

        /* 设置Y的父亲为P
         * 1. P为空，则根节点设置为Y
         * 2. X为P的左子， 则P的左子设置为Y
         * 3. X为P的右子，则P的右子设置为Y */
        y.setParent(p);
        if (p == null) {
            this.root = y;
        } else {
            if (p.getLeft() == x) {
                p.setLeft(y);
            } else {
                p.setRight(y);
            }
        }

        /* 将X的父亲设置为Y
        * 将Y的右子设置为X */
        x.setParent(y);
        y.setRight(x);
    }

    /**
     * <p>插入结点</p>
     * @param key
     * @param data
     */
    private void insertNode(T key, D data) {
        int cmp;
        RBTNode<T, D> x = this.root;
        RBTNode<T, D> y = null;

        /* 寻找新结点的插入位置 */
        while (x != null) {
            y = x;
            cmp = key.compareTo(x.getKey());

            if (cmp == 0) {
                /* key已存在，直接更新 */
                System.out.println(getCurrentTime() + " [WARN] key已存在");
                System.out.println(getCurrentTime() + " [INFO] 更新value: " + get(key) + " => " + data);
                return;
            } else if (cmp > 0){
                /* key较大，继续向右查询 */
                x = x.getRight();
            } else if (cmp < 0) {
                /* key较小，继续向左查询 */
                x = x.getLeft();
            }
        }

        /* 生成一个新的结点 */
        RBTNode<T, D> node = new RBTNode<>(RBTColor.red, key, data, null, null, null);
        System.out.println(getCurrentTime() + " [INFO] 新增结点 (" + key + ", " + data + ")");
        /* 总结点数量+1 */
        this.count.incrementAndGet();
        /* 设置新结点的父亲为Y */
        node.setParent(y);

        /* 再次比较决定新结点是y的左子还是右子*/
        if (y == null) {
            this.root = node;
        } else {
            cmp = key.compareTo(y.getKey());
            if (cmp > 0) {
                y.setRight(node);
            } else {
                y.setLeft(node);
            }
        }

        /* 最后进行自平衡 */
        balanceInsertion(node);
    }

    /**
     * <p>插入结点的自平衡操作</p>
     * <p>由于插入节点默认颜色为红色，所以只有父结点为红色时候才需要修复
     *   分三种情况讨论</p>
     * <li>case1. 叔叔结点也为红色</li>
     * <li>case2. 叔叔结点为空，且祖父子三点一线</li>
     * <li>case3. 叔叔结点为空，且祖父子三角关系</li>
     * <p>G-祖父、P-父亲、U-叔叔、C-插入</p>
     * @param node
     */
    private void balanceInsertion(RBTNode<T, D> node) {
        /* 父亲 · 祖父 */
        RBTNode<T, D> paren, grand;

        /* 当父亲节点为黑色时，结束修复 */
        while (((paren = node.getParent()) != null) && isRed(paren)) {
            grand = paren.getParent();

            /* 确定父亲和叔叔的左右关系 */

            /* CASE: 父左叔右 */
            if (grand.getLeft() == paren) {
                RBTNode<T, D> uncle = grand.getRight();

                /**
                 * case1: PU双红
                 * solution1: GPU变色
                 * 如果此时整棵树不满足约束，则递归进行GPU变色
                 */
                if (isRed(uncle)) {
                    grand.setColor(RBTColor.red);
                    paren.setColor(RBTColor.black);
                    uncle.setColor(RBTColor.black);
                    node = grand;
                    continue;
                }
                /*
                 * case2: P红U黑，父为左子，GPC三点一线
                 * solution2: 右旋祖父，GP变色
                 *         (1) 右旋祖父结点
                 *           黑祖                        红父
                 *           / \                         / \
                 *        红父  黑叔    --(右旋)-->    红插  黑祖
                 *         /                                 \
                 *       红插                                黑叔
                 *         (2) 祖父和父亲变色
                 *           红父                        黑父
                 *           / \                         / \
                 *        红插  黑祖    --(变色)-->    红插  红祖
                 *              \                            \
                 *              黑叔                         黑叔
                 *
                 *
                * case3: P红U黑，父为左子，GPC三角关系
                * solution3: 左旋父亲，交换PC，右旋祖父，GP变色
                *         (1) 左旋父亲结点，并且交换父子身份，此时GPC三点一线
                *          黑祖                        黑祖                        黑祖
                *          / \                         / \                        / \
                *       红父  黑叔    --(左旋)-->    红插  黑叔    --(交换)-->    红父  黑叔
                *        \                          /                           /
                *        红插                     红父                         红插
                *        (2) 右旋祖父结点
                *          黑祖                        红父
                *          / \                         / \
                *       红父  黑叔    --(右旋)-->    红插  黑祖y
                *        /                                 \
                *      红插                                黑叔
                *        (3) 祖父和父亲变色
                *          红父                        黑
                *          / \                         / \
                *       红插  黑祖    --(变色)-->    红插  红组
                *              \                           \
                *              黑叔                        黑叔
                 *
                 * attention:
                 * 三角关系经过一步旋转即可转换成三点一线
                 * 因此case3先经过一步处理到case2，再进行case2的处理
                 */
                else {
                    if (paren.getRight() == node) { // case3
                        leftRotate(paren);
                        RBTNode<T, D> temp = node;
                        node = paren;
                        paren = temp;
                    } // case2
                    rightRotate(grand);
                    grand.updateColor();
                    paren.updateColor();
                }
            }
            /* CASE: 父右叔左 */
            else {
                RBTNode<T, D> uncle = grand.getLeft();

                /**
                 * case1: PU双红(父亲和叔叔都为红色)
                 * solution1: GPU变色(祖父变为红色，父亲和叔叔都变为黑色)
                 * 如果此时整棵树不满足约束，则递归进行GPU变色
                 */
                if (isRed(uncle)) {
                    grand.setColor(RBTColor.red);
                    paren.setColor(RBTColor.black);
                    uncle.setColor(RBTColor.black);
                    node = grand;
                    continue;
                }
                /*
                 * case4: P红U黑，父为左子，GPC三点一线
                 * solution4: 左旋祖父，GP变色
                 *         (1) 左旋祖父结点
                 *           黑祖                        红父
                 *           / \                         / \
                 *        黑叔  红父    --(右旋)-->    黑祖  红插
                 *               \                     /
                 *               红插                黑叔
                 *          (2) 祖父和父亲变色
                 *           红父                        黑父
                 *           / \                         / \
                 *        黑祖  红插    --(变色)-->    红祖  红插
                 *         /                           /
                 *       黑叔                        黑叔
                 *
                 * case5: P红U黑，父为右子，GPC三角关系
                 * solution5: 右旋父亲，交换PC，左旋祖父，GP变色
                 *          (1) 右旋父亲结点，并且交换父子身份，此时GPC三点一线
                 *           黑祖                        黑祖                        黑祖
                 *           / \                         / \                        / \
                 *        黑叔  红父    --(右旋)-->    黑祖  红插    --(交换)-->    黑祖  红父
                 *              /                            \                          \
                 *            红插                           红父                        红插
                 *          (2) 左旋祖父
                 *           黑祖                        红父
                 *           / \                         / \
                 *        黑叔  红父    --(左旋)-->    黑祖  红插
                 *               \                    /
                 *               红插               黑叔
                 *          (3) 祖父和父亲变色
                 *           红父                        黑父
                 *           / \                         / \
                 *        黑叔  红插    --(变色)-->    红祖  红插
                 *         /                         /
                 *       黑叔                      黑叔
                 *
                 * attention:
                 * 三角关系经过一步旋转即可转换成三点一线
                 * 因此case3先经过一步处理到case2，再进行case2的处理
                 */
                else {
                    if (paren.getLeft() == node) { // case3
                        rightRotate(paren);
                        RBTNode<T, D> temp = node;
                        node = paren;
                        paren = temp;
                    } // case2
                    leftRotate(grand);
                    grand.updateColor();
                    paren.updateColor();
                }
            }
        }

        /* 保证根节点为黑色 */
        if (root == node) {
            node.setColor(RBTColor.black);
        }
    }

    /**
     * <p>删除结点</p>
     * <p>三种情况</p>
     * <li>case1. 待删结点左子和右子都存在</li>
     * <li>case2. 待删结点没有左子和右子</li>
     * <li>case3. 待删结点只有左子或者右子</li>
     * @param node
     */
    private void deleteNode(RBTNode<T, D> node) {
        /* 父亲 · 儿子 · 继承者 */
        RBTNode<T, D> paren, child, replace;
        RBTColor color;

        /*
         * case1: 待删结点左子和右子都存在
         * solution1:
         * - 找到该结点的右子树中的最左子结点
         * - 把它的值和要删除的结点的值进行交换
         * - 然后删除这个结点即相当于删除所需删除结点
         */
        if ((node.getLeft() != null) && (node.getRight() != null))  {

            /*  获取其后继结点: 右子树中的最左子结点 */
            replace = descendants(node);
            paren = replace.getParent();
            child = replace.getRight();
            color = replace.getColor();

            if (node == replace.getParent()) {
                /**
                 * case:
                 *    node              replace
                 *      \                  \
                 *      replace    -->    child
                 *         \
                 *         child
                 */
                paren = replace;
            } else {
                /**
                 * case:
                 *     node                replace
                 *       \                   \
                 *        X                   X
                 *       / \                 / \
                 *  paren   X    -->    paren   X
                 *     /                  /
                 *  replace            child
                 *     \
                 *     child
                 *
                 */
                /* 建立替代结点的父亲与替换结点的右子的父子关系，即爷孙変父子 */
                if (child != null) {
                    child.setParent(replace.getParent());
                }
                replace.getParent().setLeft(child);
                /* 建立替代节点与待删节点的右子的父子关系 */
                replace.setRight(node.getRight());
                node.getRight().setParent(replace);
            }

            /* 待删节点的父亲设置为替代结点的父亲 */
            replace.setParent(node.getParent());
            /* 建立替换结点与待删节点左子的父子关系 */
            replace.setLeft(node.getLeft());
            node.getLeft().setParent(replace);
            /* 替代结点沿用待删节点的颜色 */
            replace.setColor(node.getColor());

            /* 待删结点的父亲不为空，则调整左右子 */
            if (node.getParent() != null) {
                if (node.getParent().getLeft() == node) {
                    node.getParent().setLeft(replace);
                } else {
                    node.getParent().setRight(replace);
                }
            }
            /* 待删结点的父亲为空，则设置根结点 */
            else {
                this.root = replace;
            }

            /* 删除黑色结点需要调整平衡，红色不需要 */
            if (color == RBTColor.black) {
                balanceDeletion(child, paren);
            }
        }
        /**
         * case2: 待删结点没有左子和右子
         * solution2: 直接删除结点
         */
        else if((node.getLeft() == null) && (node.getRight() == null)) {
            paren = node.getParent();
            if (node == paren.getLeft()) {
                paren.setLeft(node.getLeft());
            } else {
                paren.setRight(node.getRight());
            }
        }
        /**
         * case3: 待删结点只有左子或者右子
         * solution3: 待删节点的父亲指向存在的子嗣
         */
        else {
            /* 确定替代结点 */
            if (node.getLeft() != null) {
                replace = node.getLeft();
            } else {
                replace = node.getRight();
            }

            /* 待删结点的父亲 */
            paren = node.getParent();

            /* 待删结点的父亲是否为空 */
            if (paren != null) {
                if (paren.getLeft() == node) {
                    paren.setLeft(replace);
                } else {
                    paren.setRight(replace);
                }
            } else {
                this.root = replace;
            }

            /* 待删节点的父亲指向替代结点 */
            replace.setParent(paren);

            color = node.getColor();
            child = replace;

            /* 删除黑色结点需要调整平衡，红色不需要 */
            if (color == RBTColor.black) {
                balanceDeletion(child, paren);
            }
        }

        /* 结点数量-1 */
        count.decrementAndGet();
        System.out.println(getCurrentTime() + " [INFO] key为" + node.getKey() + "的结点删除成功");
    }

    /**
     * <p>寻找继承的后裔</p>
     * @param node
     * @return
     */
    public RBTNode<T, D> descendants(RBTNode<T, D> node) {
        /* 查询大于该节点的最小结点，即右子树的最左结点 */
        if (node.getRight() != null) {
            RBTNode<T, D> right = node.getRight();
            if (right.getLeft() == null) {
                return right;
            }
            while (right.getLeft() != null) {
                right = right.getLeft();
            }
            return right;
        }

        /* @deprecated */
        RBTNode<T, D> paren = node.getParent();
        while ((paren != null) && (paren.getRight() == node)) {
            node = paren;
            paren = paren.getParent();
        }
        return paren;
    }


    /**
     * <p>删除结点的自平衡操作</p>
     * <p>
     * P-父亲、D-删除、B-兄弟、BR-兄弟右子、BL-兄弟左子。
     *
     * - D为左子
     *   - B为红色：左旋父亲，父亲染红，兄弟染黑，然后continue
     *   - B为黑色
     *     - BL为黑色且BR黑色：兄弟染红，父亲回溯
     *     - BL为红色且BR为黑色：右旋兄弟，兄弟染红，BL染黑
     *     - BR为红色：左旋父亲，父亲的颜色给兄弟，父亲黑化，BR黑化，然后break
     * - D为右子
     *   - B为红色：右旋父亲，父亲染红，兄弟染黑，然后continue
     *   - B为黑色：
     *     - BL为黑色且BR为黑色：兄弟染红，父亲回溯
     *     - BL为红色且BR为黑色：左旋兄弟，父亲染红，BR染黑
     *     - BL为红色：右旋父亲，父亲的颜色给兄弟，父亲黑化，BL黑化，然后break
     * </p>
     *
     * @param node
     * @param paren
     * <p>
     *     入参情况:
     *     1. node=替换节点 paren=替换节点的父亲节点
     *     2. node=替换节点的孩子节点 paren=替换节点
     *     3. node=替换节点的孩子节点 parent=替换节点的父节点
     * </p>
     */
    private void balanceDeletion(RBTNode<T, D> node, RBTNode<T, D> paren) {
        RBTNode<T, D> broth;

        while (isBlack(node) && node != this.root) {

            if (paren.getLeft() == node) {
                broth = paren.getRight();

                /**
                 * case1: D为左子。B为红色
                 * solution1: 左旋父亲，父亲染红，兄弟染黑，然后continue
                 */
                if (isRed(broth)) {
                    leftRotate(paren);
                    paren.setColor(RBTColor.red);
                    broth.setColor(RBTColor.black);
                    continue;
                } else {
                    /**
                     * case2: D为左子。B为黑色，BL为黑色且BR为黑色
                     * solution2: 兄弟染红，父亲回溯
                     */
                    if (isBlack(broth.getLeft()) && isBlack(broth.getRight())) {
                        broth.setColor(RBTColor.red);
                        node = paren;
                        paren = paren.getParent();
                    }
                    /**
                     * case3: D为左子。B为黑色，BL为红色且BR为黑色
                     * solution3: 右旋兄弟，兄弟染红，BL染黑
                     */
                    else if (isRed(broth.getLeft()) && isBlack(broth.getRight())) {
                        rightRotate(broth);
                        broth.setColor(RBTColor.red);
                        broth.getLeft().setColor(RBTColor.black);
                    }
                    /**
                     * case4: D为左子，B为黑色，BR为红色
                     * solution4: 左旋父亲，父亲的颜色给兄弟，父亲黑化，BR黑化，然后break
                     */
                    else if (isRed(broth.getRight())) {
                        leftRotate(paren);
                        broth.setColor(paren.getColor());
                        paren.setColor(RBTColor.black);
                        broth.getRight().setColor(RBTColor.black);
                        break;
                    }
                }
            } else {
                broth = paren.getLeft();

                /**
                 * case5: D为右子。B为红色
                 * solution5: 右旋父亲，父亲染红，兄弟染黑，然后continue
                 */
                if (isRed(broth)) {
                    rightRotate(paren);
                    paren.setColor(RBTColor.red);
                    broth.setColor(RBTColor.black);
                } else {
                    /**
                     * case6: D为右子。B为黑色，BL为黑色且BR为黑色
                     * solution6: 兄弟染红，父亲回溯
                     */
                    if (isBlack(broth.getLeft()) && isBlack(broth.getRight())) {
                        broth.setColor(RBTColor.red);
                        node = paren;
                        paren = paren.getParent();
                    }
                    /**
                     * case7: D为右子。B为黑色，BL为红色且BR为黑色
                     * solution7: 左旋兄弟，父亲染红，BR染黑
                     */
                    else if (isRed(broth.getLeft()) && isBlack(broth.getRight())) {
                        leftRotate(broth);
                        paren.setColor(RBTColor.red);
                        broth.getRight().setColor(RBTColor.black);
                    }
                    /**
                     * case8: D为右子，B为黑色，BR为红色
                     * solution8: 右旋父亲，父亲的颜色给兄弟，父亲黑化，BL黑化，然后break
                     */
                    else if (isRed(broth.getRight())) {
                        rightRotate(paren);
                        broth.setColor(paren.getColor());
                        paren.setColor(RBTColor.black);
                        broth.getRight().setColor(RBTColor.black);
                        break;
                    }
                }
            }

        }

        /* node染成被删结点的颜色 */
        node.setColor(RBTColor.black);
    }

    /**
     * <p>层次遍历</p>
     */
    public void levelOrder() {
        List<List<RBTNode<T, D>>> levelList = levelOrder(this.root);
        for (List<RBTNode<T, D>> list:levelList) {
            for (RBTNode node : list) {
                System.out.print(node.getKey() + " ");
            }
            System.out.println();
        }
    }

    /**
     * <p>层次遍历</p>
     * @param node
     * @return
     */
    private List<List<RBTNode<T, D>>> levelOrder(RBTNode<T, D> node) {
        List<List<RBTNode<T, D>>> res = new LinkedList<>();
        Queue<RBTNode<T, D>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<RBTNode<T, D>> cur = new LinkedList<>();
            while (count != 0) {
                RBTNode<T, D> temp = queue.poll();
                cur.add(temp);
                if (temp.getLeft() != null) queue.add(temp.getLeft());
                if (temp.getRight() != null) queue.add(temp.getRight());
                count--;
            }
            res.add(cur);
        }
        return res;
    }

    /**
     * <p>输出红黑树的层级结构</p>
     */
    public void printRBTreeLevel() {
        System.out.println(getCurrentTime() + " [INFO] 开始打印红黑树的层级结构");
        ConcurrentHashMap<Integer, List<RBTNode>> map = showTree();
        int size = map.size();

        for (int i = 0; i < map.size(); i++) {
            System.out.println();
            for (int j = 0; j < map.get(i).size(); j++) {
                System.out.print( makeSpace(size, i) +
                        (map.get(i).get(j).getKey() == null ? " " : (map.get(i).get(j).getKey()) + (map.get(i).get(j).getColor() == RBTColor.black ? "(黑)" : "(红)")) + makeSpace(size, i));
            }
            System.out.println();
        }
        System.out.println(getCurrentTime() + " [INFO] 红黑树的层级结构打印完毕");
    }

    /**
     * <p>输出整棵树的Graphviz结构</p>
     */
    public void printGraphviz(){
        System.out.println(getCurrentTime() + " [INFO] 开始打印树的Graphviz结构");
        ConcurrentHashMap<Integer, List<RBTNode>> map = showTree();
        int size = map.size();
        System.out.println("digraph {");
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if(map.get(i).get(j).getKey() != null){
                    System.out.println(map.get(i).get(j).getKey() + " [color="  + (map.get(i).get(j).getColor()) + "] ");
                }
            }
        }

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if(map.get(i).get(j).getKey() != null){
                    if(map.get(i).get(j).getLeft() != null){
                        System.out.println(map.get(i).get(j).getKey() + "->" + map.get(i).get(j).getLeft().getKey() + "[label=left]");
                    }
                    if(map.get(i).get(j).getRight() != null){
                        System.out.println(map.get(i).get(j).getKey() + "->" + map.get(i).get(j).getRight().getKey() + "[label=right]");
                    }
                }
            }
        }
        System.out.println("}");
        System.out.println(getCurrentTime() + " [INFO] 树的Graphviz结构打印完毕");
    }

    public String makeSpace(int size, int index){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1 << (size - index); i++) {
            builder.append("  ");
        }
        return builder.toString();
    }

    public ConcurrentHashMap<Integer, List<RBTNode>> showTree(){
        ConcurrentHashMap<Integer, List<RBTNode>> map = new ConcurrentHashMap<>();
        showTree(root, 0, map);
        return map;
    }

    public void showTree(RBTNode root, int count, ConcurrentHashMap<Integer, List<RBTNode>> map){
        if (map.get(count) == null){
            map.put(count, new ArrayList<>());
        }
        map.get(count).add(root);

        if (root.getLeft() != null){
            showTree(root.getLeft(), count+1 , map);
        } else{
            if(map.get(count+1) == null){
                map.put(count+1, new ArrayList<>());
            }
            map.get(count+1).add(new RBTNode(RBTColor.red, null, null, null, null, null));
        }
        if (root.getRight() != null){
            showTree(root.getRight(), count+1 , map);
        } else{
            if(map.get(count+1) == null){
                map.put(count+1, new ArrayList<>());
            }
            map.get(count+1).add(new RBTNode(RBTColor.red, null, null, null, null, null));
        }
    }


    /**
     * <p>菜单</p>
     */
    public void RBT() {
        RedBlackTree KTree = new RedBlackTree();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(("┏━━━━━━━━━ ▶ ▶ ▶ ▶ ▶ RED ❤ BLACK ◀ ◀ ◀ ◀ ◀ ━━━━━━━━━━┓"));
            System.out.println(("   ✪━━━━━━━━━━━━━━━━━━━ 1. 插入节点 ━━━━━━━━━━━━━━━━━━━✪"));
            System.out.println(("   ✪━━━━━━━━━━━━━━━━━━━ 2. 查询节点 ━━━━━━━━━━━━━━━━━━━✪"));
            System.out.println(("   ✪━━━━━━━━━━━━━━━━━━━ 3. 删除结点 ━━━━━━━━━━━━━━━━━━━✪"));
            System.out.println(("   ✪━━━━━━━━━━━━━━━━━━━ 4. 查询数量 ━━━━━━━━━━━━━━━━━━━✪"));
            System.out.println(("   ✪━━━━━━━━━━━━━━━━━━━ 5. 层次结构 ━━━━━━━━━━━━━━━━━━━✪"));
            System.out.println(("   ✪━━━━━━━━━━━━━━━━━━━ 6. Graphviz ━━━━━━━━━━━━━━━━━━✪"));
            System.out.println(("   ✪━━━━━━━━━━━━━━━━━━━ 7. 退出系统 ━━━━━━━━━━━━━━━━━━━✪"));
            System.out.println(("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"));

            System.out.print(getCurrentTime() + " [input] 输入选择：");
            int choice = scanner.nextInt();
            int key;
            String value;
            switch (choice) {
                case 1:
                    System.out.print(getCurrentTime() + " [INPUT] 输入键值：");
                    key = scanner.nextInt();
                    System.out.print(getCurrentTime() + " [INPUT] 输入数据：");
                    value = scanner.next();
                    KTree.add(key, value);
                    break;
                case 2:
                    System.out.print(getCurrentTime() + " [INPUT] 输入键值：");
                    key = scanner.nextInt();
                    System.out.println(getCurrentTime() + " [INFO] 查询结果 value = " + KTree.get(key));
                    break;
                case 3:
                    System.out.print(getCurrentTime() + " [INPUT] 输入键值：");
                    key = scanner.nextInt();
                    KTree.del(key);
                    break;
                case 4:
                    System.out.println(getCurrentTime() + " [INFO] 查询结果 size = " + KTree.size());
                    break;
                case 5:
                    KTree.printRBTreeLevel();
                    break;
                case 6:
                    KTree.printGraphviz();
                    break;
                case 7:
                    System.out.println(getCurrentTime() + " [INFO] 退出成功");
                    break;
                default:
                    System.out.println(getCurrentTime() + " [ERROR] 输入错误");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.RBT();
    }
}
