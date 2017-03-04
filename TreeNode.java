public class TreeNode
{
	private Object item;
	private TreeNode leftChild;
	private TreeNode rightChild;

	// Initializes tree node with item and no children.
	public TreeNode(Object newItem)
	{
		item = newItem;
		leftChild  = null;
		rightChild = null;
	}
    
	// Initializes tree node with item and the left and right children references.
	public TreeNode(Object newItem, TreeNode left, TreeNode right)
	{
		item = newItem;
		leftChild  = left;
		rightChild = right;
	}

	// Returns the item field.
	public Object getItem()
	{
		return item;
	}

	// Sets the item field to the new value newItem.
	public void setItem(Object newItem)
	{
		item  = newItem;
	}

	// Returns the reference to the left child.
	public TreeNode getLeft()
	{
		return leftChild;
	}

	// Sets the left child reference to left.
	public void setLeft(TreeNode left)
	{
		leftChild  = left;
	}

	// Returns the reference to the right child.
	public TreeNode getRight()
	{
		return rightChild;
	}

	// Sets the right child reference to right.
	public void setRight(TreeNode right)
	{
		rightChild  = right;
	}
}