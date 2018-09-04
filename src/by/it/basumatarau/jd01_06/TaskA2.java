package by.it.basumatarau.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(Poem.text);
        System.out.println(sb);

        Pattern regex = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = regex.matcher(sb);
        BinSearchTree bst = new BinSearchTree("");
        while(matcher.find()){
            bst.addWord(matcher.group());
        }
        bst.print();
    }

}
class BinSearchTree{
    private class Node{
        private String word;
        private int amount = 1;
        Node left;
        Node right;
        private int balanceCriteria = 0;

        Node(String word){
            this.word = word;
        }

        void incrCounter(){
            this.amount++;
        }
        private void rebalance(Node child) {
            if(child.balanceCriteria == -2 && child.left.balanceCriteria == -1){
                this.rotateRight(child);
            }else if (child.balanceCriteria == -2 && child.left.balanceCriteria == 1){
                this.rotateLeftRight(child);
            }else if (child.balanceCriteria == 2 && child.right.balanceCriteria == 1){
                this.rotateLeft(child);
            }else if (child.balanceCriteria == 2 && child.right.balanceCriteria == -1){
                this.rotateRightLeft(child);
            }
        }

        private void rotateRightLeft(Node child) {
            child.right.balanceCriteria = 1;
            child.rotateRight(child.right);
            child.right.balanceCriteria = 1;
            this.rotateLeft(child);
        }

        private void rotateLeft(Node child) {
            Node nd;
            nd = child.right;
            child.right = nd.left;
            nd.left = child;
            if(child == this.left){
                this.left = nd;
            } else{
                this.right = nd;
            }
            child.balanceCriteria=0;
            nd.balanceCriteria=0;
        }

        private void rotateLeftRight(Node child) {
            child.left.right.balanceCriteria = -1;
            child.rotateLeft(child.left);
            child.left.balanceCriteria = -1;
            this.rotateRight(child);
        }

        private void rotateRight(Node child) {
            Node nd;
            nd = child.left;
            child.left= nd.right;
            nd.right = child;
            if(this.left==child){
                this.left=nd;
            }else{
                this.right=nd;
            }
            child.balanceCriteria=0;
            nd.balanceCriteria=0;
        }
    }
    //private BinSearchTree(){}
    BinSearchTree(String word){
        Node nd = new Node(word);
        nd.left = null;
        nd.right = null;
        this.top = nd;
    }
    private Node top=null;

    void addWord(String word){
        this.insertNode(this.top, word);
    }

    private boolean insertNode(Node currentNode, String word) {
        if(currentNode.word.equals(word)){
            currentNode.incrCounter();
            return false;
        }else if(currentNode.word.compareTo(word)<0){
            if(currentNode.left==null){
                currentNode.left = new Node(word);
                if (currentNode.right==null){
                    currentNode.balanceCriteria=-1;
                }else {
                    currentNode.balanceCriteria=0;
                }
            }else {
                if(insertNode(currentNode.left, word)){
                    if (currentNode.left.balanceCriteria<-1 || currentNode.left.balanceCriteria>1){
                        currentNode.rebalance(currentNode.left);
                    }else{
                        currentNode.balanceCriteria--;
                    }
                }
            }
        }else {
            if(currentNode.right==null) {
                currentNode.right = new Node(word);
                if (currentNode.left == null) {
                    currentNode.balanceCriteria = 1;
                } else {
                    currentNode.balanceCriteria = 0;
                }
            }else {
                if (insertNode(currentNode.right, word)){
                    if (currentNode.right.balanceCriteria<-1||currentNode.right.balanceCriteria>1){
                        currentNode.rebalance(currentNode.right);
                    }else{
                        currentNode.balanceCriteria++;
                    }
                }
            }
        }

        if (currentNode.balanceCriteria!=0) return true;
        return false;
    }
    public void print(){
        printTree(this.top);
    }
    private void printTree(Node nd){
        if(nd == null) return;

        printTree(nd.left);
        printTree(nd.right);
        System.out.println(nd.word + "=" + nd.amount);

    }
}

