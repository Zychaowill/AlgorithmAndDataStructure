package zychaowill.datastructure.basic.tree.rb;

public class RBTreeNode {
	RBTreeNode parent = nullNode;
	RBTreeNode left = nullNode;
	RBTreeNode right = nullNode;
	int value;
	RBColor color;

	public RBTreeNode() {}
	public RBTreeNode(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "(" + value + " " + color + ")";
	}
	
	public static RBTreeNode nullNode = new RBTreeNode() {
		{
			color = RBColor.BLACK;
		}
		@Override
		public String toString() {
			return "(null " + color + ")";
		}
	};
	
	public static RBTreeNode leftRotate(RBTreeNode root, RBTreeNode node) {
		
	}
}
