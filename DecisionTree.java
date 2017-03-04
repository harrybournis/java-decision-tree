import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class DecisionTree {

	String[] dataArray;
	DecisionTreeParser tree;

	public DecisionTree(String filePath) {
		try {
			dataArray = readFile(filePath);
			tree = new DecisionTreeParser(dataArray);
		} catch (TreeException e) {
			e.printStackTrace();
		}
	}

	public void startParsing() {
		tree.use();
	}

	//Calls the Decision Tree's preOrderTraversal method
	public void preOrderTraversal() {
		tree.preOrderTraversal();
	}

	public static String[] readFile(String file) throws TreeException {

		List<String> lines = null;
		try {
			lines = Files.readAllLines(new File("TreeData.txt").toPath(), Charset.defaultCharset() );
		} catch (IOException e) {
	   		System.err.format("Could not read %s: %s%n", file, e);
	   		System.exit(1);
		}

		if ( lines != null && (lines.size() % 2) != 0 ) {

			String[] array = new String[lines.size()];
			array = lines.toArray(array);
			return array;

		} else {
			throw new TreeException("Number of nodes has to be an odd number.");
		}
	}
}
