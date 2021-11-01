import linkedlist.MyLinkedListStack;

public class Lesson4 {
    public static void main(String[] args) throws Exception {
        MyLinkedListStack<String> stack = new MyLinkedListStack<>();

        stack.push("A0");
        stack.push("B1");
        stack.push("C2");
        System.out.println(stack.getList());

        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.getList());
    }
}
