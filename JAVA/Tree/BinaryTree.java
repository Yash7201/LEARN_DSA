import java.util.*;;

public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

         Node(int value){
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }

    static Node root;
   static Node createRoot(int value){
         root = new Node(value);
        return root;
   }

   static void addNode(int value, Node root){
             if(root == null) return;
        if(value < root.data){
            if(root.left == null){
                root.left = new Node(value);
            }else{
                addNode(value, root.left);
            }
        }else{
            if(root.right == null){
                root.right = new Node(value);
            }else{
                addNode(value, root.right);
            }
        }
   }

   static void printTree(Node root){
             if(root == null) return;
        // In-order Traversal
       // Order: Left Subtree → Root Node → Right SubtreeKey Use Case: Used in Binary Search Trees (BST) to retrieve data in sorted, 
       //ascending order.
       printTree(root.left); 
       System.out.println(root.data + " ");
       printTree(root.right);
   }

   static void printInOrder(Node root){
      if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null || !stack.isEmpty()){
              // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

             current = stack.pop();
        System.out.print(current.data + " ");

        //Now visit right tree
        current = current.right;
        }
}

// 2. Pre-order Traversal
//Order: Root Node → Left Subtree → Right SubtreeKey Use Case: Ideal for cloning/copying a tree structure or evaluating prefix expressions.

    static void printPreOrder(Node root){
        if(root == null) return;
        Stack<Node> stackOfNodes = new Stack<>();
     
        stackOfNodes.push(root);

        while(!stackOfNodes.isEmpty()){
            Node current = stackOfNodes.pop();
            System.out.print(current.data + " ");

            // Push right first so left is processed first (stack LIFO)
            if(current.right != null){
                stackOfNodes.push(current.right);
            }

            if(current.left != null){
                stackOfNodes.push(current.left);
            }

        }
    }


    public static void main(String[] args) {
     int[] arr = {2, 12, 24, 101, 95, 9, 55, 77, 35};
     Node root = createRoot(1);
     for(int x: arr){
        addNode(x, root);
     }

     printInOrder(root);
     System.out.println(" ");
     printPreOrder(root);
    }
    
}