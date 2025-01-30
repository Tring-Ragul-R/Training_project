
public class Stack {

    Node top;
    int size;

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        size++;

    }

    public void pop(){
        int result = top.data;
        top = top.next;
        System.out.println("Element "+result+" is popped");
        size--;
    }

    public int peek(){
        return top.data;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void display(){
        Node temp = top;
        while(temp.next!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }


}
