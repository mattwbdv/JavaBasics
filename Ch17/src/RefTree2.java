
/**
 * BJP, reference tree #2
 * page 1029, for exercise #17
 */
public class RefTree2
{
    public static void main(String[] args) {

        IntTreeNode six = new IntTreeNode(6,null,new IntTreeNode(9,null,null));
        IntTreeNode seven = new IntTreeNode(7,new IntTreeNode(4,null,null),null);
        IntTreeNode eight = new IntTreeNode(8,new IntTreeNode(0,null,null),null);
        
        IntTree tree2 = new IntTree(new IntTreeNode(2,eight,new IntTreeNode(1,seven,six)));
        
        tree2.printSideways();
    }
}
