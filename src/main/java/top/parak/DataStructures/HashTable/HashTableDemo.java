package top.parak.DataStructures.HashTable;

import java.util.Scanner;

/**
 * @author KHighness
 * @date 2020/9/12 20:58
 * @apiNote 散列表
 */

class HashTable {
    private int size;
    private EmpLinkedList[] empLinkedListArray;

    public HashTable(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int empLinkedListNo = hashIndex(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].show(i);
        }
    }

    public void find(int id) {
        int empLinkedListNo = hashIndex(id);
        Emp emp = empLinkedListArray[empLinkedListNo].find(id);
        if (emp != null) {
            System.out.println("查找结果 => " + emp.toString());
        } else {
            System.out.println("未找到相关雇员");
        }
    }

    public void remove(int id) {
        int empLinkedListNo = hashIndex(id);
        empLinkedListArray[empLinkedListNo].remove(id);
    }

    // 散列函数
    public int hashIndex(int id) {
        return id % size;
    }
}

/**
 * 雇员
 */
class Emp {
    public int id;
    public String name;
    public Emp next; // 默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return '[' +
                "id=" + id +
                ", name='" + name + '\'' +
                ']';
    }
}

/**
 * 链表
 */
class EmpLinkedList{
    // 头指针，指向第一个Emp
    private Emp head;

    /*
     * 添加雇员
     */
    public void add(Emp emp) {
        // 如果添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        // 如果不是第一个雇员
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    /**
     * 遍历链表
     */
    public void show(int no) {
        if (head == null) {
            System.out.println("第[" + (no + 1) + "]链表为空");
            return;
        }
        System.out.print("第[" + (no + 1) +"]链表信息 => ");
        Emp cueEmp = head;
        while (cueEmp != null) {
            System.out.printf(cueEmp.toString());
            cueEmp = cueEmp.next;
        }
        System.out.println();
    }

    /**
     * 查找雇员
     */
    public Emp find(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (curEmp != null) {
            if (curEmp.id == id) {
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    public void remove(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        if (head.id == id) {
            head = head.next;
            System.out.println("删除成功");
            return;
        }
        Emp curEmp = head;
        boolean flag = false;
        while (curEmp.next != null) {
            if (curEmp.next.id == id) {
                flag = true;
                break;
            }
            curEmp = curEmp.next;
        }
        if (!flag) {
            System.out.println("不存在该员工");
            return;
        } else {
            curEmp.next = curEmp.next.next;
            System.out.println("删除成功");
        }
     }
}

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(">>> HashTable <<<");
            System.out.println("[add] - 添加雇员");
            System.out.println("[show] - 显示雇员");
            System.out.println("[find] - 查找雇员");
            System.out.println("[remo] - 删除雇员");
            System.out.println("[exit] - 退出系统");
            System.out.print("choice >");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.print("id >");
                    int id = scanner.nextInt();
                    System.out.print("name >");
                    scanner.nextLine(); // 接收上一个Enter
                    String name = scanner.nextLine();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "show":
                    hashTable.show();
                    break;
                case "find":
                    System.out.print("id >");
                    int fId = scanner.nextInt();
                    hashTable.find(fId);
                    break;
                case "remo":
                    System.out.print("id >");
                    int rId = scanner.nextInt();
                    hashTable.remove(rId);
                    break;
                case "exit":
                    System.exit(1);
                    break;
                default:
                    System.out.println("Input Error");
                    break;
            }
        }
    }
}
