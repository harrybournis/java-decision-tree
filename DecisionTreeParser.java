import javax.swing.JOptionPane;

public class DecisionTreeParser {
	
	private TreeNode root;
	private String[] array;
	private int itemIndex;
	
	public DecisionTreeParser(String[] dataArray) {
		array = dataArray;
		build();
	}
	
	private void build() {
		root = addNode();
	}
	
	private TreeNode addNode() {
	
		TreeNode tNode = new TreeNode( (Object) array[itemIndex] );	
		itemIndex += 1;

		//Insert Left Node
		if ( ( (String) array[itemIndex] ).contains("?") ) {
			tNode.setLeft( addNode() );
		} else if ( ( (String) array[itemIndex] ).contains(".") ){
			tNode.setLeft( new TreeNode( (Object) array[itemIndex] ) );
			itemIndex += 1;
		} else {
			throw new TreeException("Invalid String for Left Node. String " + 
			(String) array[itemIndex]);
		}
		
		//Insert Right Node
		if ( ( (String) array[itemIndex] ).contains("?") ) {
			tNode.setRight( addNode() );
		} else if ( ( (String) array[itemIndex] ).contains(".") ){
			tNode.setRight( new TreeNode( (Object) array[itemIndex] ) );
			itemIndex += 1;
		} else {
			throw new TreeException("Invalid String for Right Node. String " + 
			(String) array[itemIndex]);
		}
		
		return tNode;
	}
	
	public void use() {
		TreeNode current = root;
		
		while ( ( (String) current.getItem()).contains("?") ) {
		
			int input = JOptionPane.showConfirmDialog(null, (String) current.getItem(),
			 "Decision Tree", JOptionPane.YES_NO_OPTION);
			 
        	if (input == JOptionPane.YES_OPTION) {
         		current = current.getRight();
			} else if (input == JOptionPane.NO_OPTION) {
				current = current.getLeft();
			}
		}
		
		JOptionPane.showMessageDialog(null, (String) current.getItem() );
	}
	
	public void preOrderTraversal()
	{
		preOrderTraversal( root );
	}

	private void preOrderTraversal( TreeNode tNode )
	{
		if ( tNode != null )
		{
			System.out.print( tNode.getItem() + " \n" );
			preOrderTraversal( tNode.getLeft() );
			preOrderTraversal( tNode.getRight() );
		}
	}
}