import pkg.MyBinaryTree;
import pkg.Node;
import pkg.Person;

import java.util.Random;

public class Algoritms {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        Random random = new Random();
        int id = -1;

        // проверка корректности реализации работы с двоичным деревом
        while (tree.getMinMaxLevel(false) <= 6) {
            id = random.nextInt(30);
            if(tree.findNode(id) != null) continue;
            tree.insert(new Person(id));
        }
        tree.delete(id);
        tree.display();
        System.out.println("---------------------------------------------------------------------------");
        Node node = tree.rootNode.leftNode;
        if (node != null) {
            tree.delete(node.person.ID);
        }
        node = tree.rootNode.rightNode;
        if (node != null) {
            tree.delete(node.person.ID);
        }
        tree.display();
        System.out.println();

        // непосредственно выполнение ДЗ(п.1, 2)
        int countBalance = 0;
        int countDisbalance = 0;

        for (int i = 0; i < 100_000; i++) {
            tree = new MyBinaryTree();
            while (tree.getMinMaxLevel(false) <= 6) {
                id = random.nextInt(198) - 99;
                if(tree.findNode(id) != null) continue;
                tree.insert(new Person(id));
            }
            tree.delete(id);

            if (tree.isBalanced())
                ++countBalance;
            else
                ++countDisbalance;
        }
        System.out.println("Количество сбалансированных деревьев: " + countBalance);
        System.out.println("Количество несбалансированных деревьев: " + countDisbalance);
        System.out.println("Процент сбалансированных деревьев: " + (int) ((double) countBalance / (countBalance + countDisbalance) * 100) + '%');
    }
}
