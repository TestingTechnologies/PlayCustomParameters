package ttworkbench.play.parameters.ipv6.widgets.tableviewer;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import com.testingtech.ttworkbench.ttman.parameters.api.IParameterEditor;


/**
 * This class implements the sorting for the Player Table
 */

public class TableViewerSorter extends ViewerSorter {
	private static final int ASCENDING = 0;
	private static final int DESCENDING = 1;
	private TableParameterColumnType column;
	private int direction;

	public TableViewerSorter() {
		super();

	}
	
	/**
	 * Does the sort. If it's a different column from the previous sort, do
	 * an ascending sort. If it's the same column as the last sort, toggle
	 * the sort direction.
	 * 
	 * @param column
	 */
	public void doSort(TableParameterColumnType column) {
		if (column == this.column) {
			// Same column as last sort; toggle the direction
			direction = 1 - direction;
		} else {
			// New column; do an ascending sort
			this.column = column;
			direction = ASCENDING;
		}
	}

	/**
	 * Compares the object for sorting
	 */
	public int compare(Viewer viewer, Object e1, Object e2) {
		IParameterEditor p1 = (IParameterEditor) e1;
		IParameterEditor p2 = (IParameterEditor) e2;

		int rc = 0;

		Object v1 = TableParameterColumnType.valueOf(column, p1);
		Object v2 = TableParameterColumnType.valueOf(column, p2);
		rc = String.valueOf( v1).compareTo( String.valueOf( v2));
		
		// If descending order, flip the direction
		if (direction == DESCENDING)
			rc = -rc;

		return rc;
	}
}
