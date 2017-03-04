import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DecisionTreeReader {
	
	String[] dataArray;
	DecisionTree tree;
	
	public DecisionTreeReader(String filePath) {
		try {
			dataArray = readFile(filePath);
			tree = new DecisionTree(dataArray);
		} catch (TreeException e) {
			e.printStackTrace();
		}
	}
	
	public void useTree() {
		tree.use();
	}
	
	//Calls the Decision Tree's preOrderTraversal method
	public void preOrderTraversal() {
		tree.preOrderTraversal();
	}
	
	//MESS. FIX it.
	public static String[] readFile(String file) throws TreeException {
	
		ArrayList<String> arrayList = new ArrayList<String>();
    	
    	BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
       			arrayList.add(line);
      		}
    	} catch (IOException e) {
      		System.err.format("Could not read %s: %s%n", file, e);
      		System.exit(1);
   		} finally {
     		if (reader != null) {
        		try {
        			reader.close();
    			} catch (IOException e) {
        			System.out.println("reader close");
        		}
    		}	
		}
		
		if ( (arrayList.size() % 2) != 0 ) {
		
			String[] array = new String[arrayList.size()];
			array = arrayList.toArray(array);
			return array;
			
		} else {
			throw new TreeException("Number of nodes has to be an odd number.");
		}
	}
	
}