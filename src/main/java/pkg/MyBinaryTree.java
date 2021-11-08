package pkg;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree {
    public Node rootNode;

    private List<Node> listLeafNode = new ArrayList<>();
    private Integer[][] mapID;

    public Node findNode(int id) {
        return findNode(id, rootNode);
    }
    public void insert(Person person) {
        Node insertNode;
        Node parentNode;

        int vPos = 1;
        int hPos = 1;

        if (rootNode == null) {
            insertNode = new Node(person, vPos, hPos);
            rootNode = insertNode;
        } else {
            parentNode = findParentNode(person.ID, rootNode, true);
            insertNode = new Node(person, -1, -1);

            if (person.ID < parentNode.person.ID) {
                parentNode.leftNode = insertNode;
            } else {
                parentNode.rightNode = insertNode;
            }

            recalcPos(insertNode, parentNode);
            listLeafNode.remove(parentNode);
        }
        listLeafNode.add(insertNode);
    }
    public boolean delete(int id) {
        Node deleteNode;
        Node parentNode;
        boolean isLeft;

        parentNode = findParentNode(id, rootNode, false);
        if (parentNode == null) return false;
        if (parentNode.leftNode != null && parentNode.leftNode.person.ID == id)
            isLeft = true;
        else
            isLeft = false;
        deleteNode = isLeft ? parentNode.leftNode : parentNode.rightNode;

        if (listLeafNode.contains(deleteNode)) {
            if (isLeft)
                parentNode.leftNode = null;
            else
                parentNode.rightNode = null;

            listLeafNode.remove(deleteNode);
            if (parentNode.leftNode == null && parentNode.rightNode == null) listLeafNode.add(parentNode);

            return true;
        }
        if (deleteNode.leftNode == null || deleteNode.rightNode == null) {
            replaceNode(deleteNode.leftNode == null ? deleteNode.rightNode : deleteNode.leftNode, parentNode, isLeft);
            return true;
        }

        Node switchNode = findMinMaxNode(deleteNode.rightNode, true);
        delete(switchNode.person.ID);

        deleteNode.person = switchNode.person;

        return true;
    }
    public void display() {
        setMap();
        StringBuilder emptyCellEtalon = new StringBuilder("   ");
        StringBuilder emptyCell;
        StringBuilder string;
        String cell;

        for (int i = 0; i < mapID.length; i++) {
            int len = (int) (int) Math.pow(2, mapID.length - i);
            int pos = (int) Math.pow(2, mapID.length - i) / 2 + 1;

            for (int j = 0; j < mapID[i].length; j++) {
                string = new StringBuilder();

                for (int k = 0; k < len; k++) {
                    emptyCell = new StringBuilder(emptyCellEtalon);
                    if (k == pos - 1) {
                        if (mapID[i][j] == null) {
                            string.append(emptyCell);
                        } else {
                            cell = String.valueOf(mapID[i][j]);
                            string.append(emptyCell.replace(emptyCell.length() - cell.length(), emptyCell.length(), cell));
                        }
                    } else {
                        string.append(emptyCell);
                    }
                }
                System.out.print(string);
            }
            System.out.println();
        }
    }
    public boolean isBalanced() {
        int min = getMinMaxLevel(true);
        int max = getMinMaxLevel(false);

        return max - min <= 1;
    }

    private Node findNode(int id, Node node) {
        if (node == null) return null;

        if (id == node.person.ID) return node;
        if (id < node.person.ID)
            return findNode(id, node.leftNode);
        else
            return findNode(id, node.rightNode);
    }
    private Node findParentNode(int id, Node node, boolean isNull) {
        if (node == null) return null;

        if (isNull) {
            if (id < node.person.ID && node.leftNode == null) return node;
            if (id > node.person.ID && node.rightNode == null) return node;
        } else {
            if (node == rootNode && node.person.ID == id) throw new RuntimeException("У root-узла не может быть родителя!");
            if (node.leftNode != null && node.leftNode.person.ID == id) return node;
            if (node.rightNode != null && node.rightNode.person.ID == id) return node;
        }

        if (id < node.person.ID)
            return findParentNode(id, node.leftNode, isNull);
        else
            return findParentNode(id, node.rightNode, isNull);
    }
    private Node findMinMaxNode(Node node, boolean isMin) {
        if (node == null) return null;
        if (isMin) {
            if (node.leftNode != null)
                return findMinMaxNode(node.leftNode, isMin);
            else
                return node;
        } else {
            if (node.rightNode != null)
                return findMinMaxNode(node.rightNode, isMin);
            else
                return node;
        }
    }
    private void recalcPos(Node node, Node parentNode) {
        if (node == null) return;
        if (parentNode == null) return;

        int vPos = parentNode.vPos + 1;
        int hPos = parentNode.hPos * 2;

        node.vPos = vPos;
        node.hPos = node.person.ID < parentNode.person.ID ? hPos - 1 : hPos;

        if (node.leftNode != null) recalcPos(node.leftNode, node);
        if (node.rightNode != null) recalcPos(node.rightNode, node);
    }
    private void getNodeList(List<Node> list, Node node) {
        if (node == null) return;
        if (node.leftNode != null) getNodeList(list, node.leftNode);
        if (node.rightNode != null) getNodeList(list, node.rightNode);
        list.add(node);
    }
    public int getMinMaxLevel(boolean isMin) {
        int min = 0;
        int max = 0;

        for (Node node : listLeafNode) {
            if (node.vPos < min || min == 0) min = node.vPos;
            if (node.vPos > max || max == 0) max = node.vPos;
        }
        return isMin ? min : max;
    }
    private void setMap() {
        mapID = new Integer[getMinMaxLevel(false)][];
        for (int i = 0; i < mapID.length; i++) {
            mapID[i] = new Integer[(int) Math.pow(2, i)];
        }
        List<Node> list = new ArrayList<>();
        getNodeList(list, rootNode);
        for (Node node : list) {
            mapID[node.vPos - 1][node.hPos - 1] = node.person.ID;
        }
    }
    private void replaceNode(Node node, Node parentNode, boolean isLeft) {
        if (node == null) return;
        if (parentNode == null) return;

        if (isLeft)
            parentNode.leftNode = node;
        else
            parentNode.rightNode = node;

        recalcPos(node, parentNode);
    }
}
