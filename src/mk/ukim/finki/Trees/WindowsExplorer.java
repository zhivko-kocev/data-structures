//package mk.ukim.finki.Trees;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Stack;
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//interface Tree<E> {
//    ////////////Accessors ////////////
//
//    Node<E> root();
//
//    Node<E> parent(Node<E> node);
//
//    int childCount(Node<E> node);
//
//    ////////////Transformers ////////////
//    void makeRoot(E elem);
//
//    Node<E> addChild(Node<E> node, E elem);
//
//    void remove(Node<E> node);
//
//    ////////////Iterator ////////////
//    Iterator<E> children(Node<E> node);
//
//}
//
//interface Node<E> {
//
//    E getElement();
//
//    void setElement(E elem);
//}
//
//
//class SLLTree<E> implements Tree<E> {
//
//    public SLLNode<E> root;
//
//    public SLLTree() {
//        root = null;
//    }
//
//    public Node<E> root() {
//        return root;
//    }
//
//    public Node<E> parent(Node<E> node) {
//        return ((SLLNode<E>) node).parent;
//    }
//
//    public int childCount(Node<E> node) {
//        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
//        int num = 0;
//        while (tmp != null) {
//            tmp = tmp.sibling;
//            num++;
//        }
//        return num;
//    }
//
//    public void makeRoot(E elem) {
//        root = new SLLNode<>(elem);
//    }
//
//    public Node<E> addChild(Node<E> node, E elem) {
//        SLLNode<E> tmp = new SLLNode<>(elem);
//        SLLNode<E> curr = (SLLNode<E>) node;
//        tmp.sibling = curr.firstChild;
//        curr.firstChild = tmp;
//        tmp.parent = curr;
//        return tmp;
//    }
//
//    public void remove(Node<E> node) {
//        SLLNode<E> curr = (SLLNode<E>) node;
//        if (curr.parent != null) {
//            if (curr.parent.firstChild == curr) {
//                // The node is the first child of its parent
//                // Reconnect the parent to the next sibling
//                curr.parent.firstChild = curr.sibling;
//            } else {
//                // The node is not the first child of its parent
//                // Start from the first and search the node in the sibling list and remove it
//                SLLNode<E> tmp = curr.parent.firstChild;
//                while (tmp.sibling != curr) {
//                    tmp = tmp.sibling;
//                }
//                tmp.sibling = curr.sibling;
//            }
//        } else {
//            root = null;
//        }
//    }
//
//    static class SLLTreeIterator<T> implements Iterator<T> {
//
//        SLLNode<T> start, current;
//
//        public SLLTreeIterator(SLLNode<T> node) {
//            start = node;
//            current = node;
//        }
//
//        public boolean hasNext() {
//            return (current != null);
//        }
//
//        public T next() throws NoSuchElementException {
//            if (current != null) {
//                SLLNode<T> tmp = current;
//                current = current.sibling;
//                return tmp.getElement();
//            } else {
//                throw new NoSuchElementException();
//            }
//        }
//
//        public void remove() {
//            if (current != null) {
//                current = current.sibling;
//            }
//        }
//    }
//
//    public Iterator<E> children(Node<E> node) {
//        return new SLLTreeIterator<>(((SLLNode<E>) node).firstChild);
//    }
//
//    void printTreeRecursive(Node<E> node, int level) {
//        if (node == null)
//            return;
//        int i;
//        SLLNode<E> tmp;
//
//        for (i = 0; i < level; i++)
//            System.out.print(" ");
//        System.out.println(node.getElement().toString());
//        tmp = ((SLLNode<E>) node).firstChild;
//        while (tmp != null) {
//            printTreeRecursive(tmp, level + 1);
//            tmp = tmp.sibling;
//        }
//    }
//
//    public void printTree() {
//        printTreeRecursive(root, 0);
//    }
//
//}
//
//class SLLNode<P> implements Node<P> {
//
//    // Holds the links to the needed nodes
//    public SLLNode<P> parent, sibling, firstChild;
//    // Hold the data
//    public P element;
//
//    public SLLNode(P o) {
//        element = o;
//        parent = sibling = firstChild = null;
//    }
//
//    public P getElement() {
//        return element;
//    }
//
//    public void setElement(P o) {
//        element = o;
//    }
//}
//
//public class WindowsExplorer {
//
//    public static void main(String[] args) throws Exception {
//        int i, j;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        String[] commands = new String[N];
//
//        for (i = 0; i < N; i++)
//            commands[i] = br.readLine();
//
//        br.close();
//
//        SLLTree<String> tree = new SLLTree<>();
//        tree.makeRoot("c:");
//        SLLNode<String> curr = tree.root;
//        for (j = 0; j < N; j++) {
//            String[] parts = commands[j].split("\\s+");
//            if (parts[0].equals("CREATE")) {
//                SLLNode<String> tmp = curr.firstChild;
//                if (tmp == null || parts[1].compareTo(tmp.element) < 0) {
//                    tree.addChild(curr, parts[1]);
//                } else {
//                    while (tmp.sibling != null && parts[1].compareTo(tmp.sibling.element) > 0) {
//                        tmp = tmp.sibling;
//                    }
//                    SLLNode<String> insert = new SLLNode<>(parts[1]);
//                    insert.sibling = tmp.sibling;
//                    tmp.sibling = insert;
//                    insert.parent = curr;
//                }
//            } else if (parts[0].equals("OPEN")) {
//                SLLNode<String> tmp = curr.firstChild;
//                while (tmp != null) {
//                    if(tmp.element.equals(parts[1])){
//                        break;
//                    }
//                    tmp = tmp.sibling;
//                }
//                if (tmp != null) {
//                    curr = tmp;
//                }
//            } else if (parts[0].equals("DELETE")) {
//                SLLNode<String> tmp = curr.firstChild;
//                while (tmp != null) {
//                    if (tmp.element.equals(parts[1])) {
//                        tree.remove(tmp);
//                        break;
//                    }
//                    tmp = tmp.sibling;
//                }
//                if (tmp == null) {
//                    System.out.println("No such element.");
//                }
//            } else if (parts[0].equals("BACK")) {
//                curr = curr.parent;
//            } else if (parts[0].equals("PATH")) {
//                Stack<String> tmp = new Stack<>();
//                SLLNode<String> tmpCurr = curr;
//                while (tmpCurr.parent != null) {
//                    tmp.push(tmpCurr.element);
//                    tmpCurr = tmpCurr.parent;
//                }
//                tmp.push(tree.root.element);
//                while (!tmp.empty()) {
//                    System.out.print(tmp.pop() + "\\");
//                }
//                System.out.print("\n");
//            } else if (parts[0].equals("PRINT")) {
//                tree.printTreeRecursive(tree.root, 0);
//            }
//        }
//
//
//    }
//
//}
