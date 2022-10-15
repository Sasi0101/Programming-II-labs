import uk.ac.soton.ecs.comp1206.labtestlibrary.datastructure.Tree;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.MinimumInTree;

public class MinTree implements MinimumInTree{
    int min=2147483647;
    /*//Just for testing
    public static void main(String[] args){
        Tree tree = new Tree( 24,
                new Tree( 9,
                        null ,
                        new Tree(8, null , null) ) ,
                new Tree ( 17,
                        new Tree (6 , null , null ) ,
                        null ) );
        MinTree minTree = new MinTree();
        System.out.println("Minimum is: " + minTree.findMin(tree));
    }*/

    /**
     * Find the smallest value in the tree if the tree is null than return min if its not check whether one of the children
     * is null, if not that means both children has a value so we continue by separating them into 2 subtrees
     * @param tree gives the tree and later on the subtrees
     * @return the min value of the tree
     */
    public int findMin(Tree tree) {
        if (tree == null) {
            return min;
        }
        min = Math.min(min, tree.getVal());
        if((tree.left() == null) && (tree.right() != null)){
            return Math.min(min, findMin(tree.right()));
        }else if((tree.left() != null) && (tree.right() == null)){
            return Math.min(findMin(tree.left()), min);
        }else return Math.min(findMin(tree.left()), findMin(tree.right()));

    }

}