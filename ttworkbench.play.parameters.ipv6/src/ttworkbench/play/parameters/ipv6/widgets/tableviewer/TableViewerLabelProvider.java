package ttworkbench.play.parameters.ipv6.widgets.tableviewer;

import java.util.LinkedList;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.testingtech.ttworkbench.ttman.parameters.api.IParameterEditor;



/**
 * This class provides the labels for the parameters table
 */
public class TableViewerLabelProvider implements ITableLabelProvider {
	/**
	 * Returns the image
	 * 
	 * @param element
	 *            the element
	 * @param columnIndex
	 *            the column index
	 * @return Image
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}


	private LinkedList<TableParameterColumnType> registeredColumns = new LinkedList<TableParameterColumnType>(); 
	public void addColumn(TableParameterColumnType columnType) {
		registeredColumns.add( columnType);
	}
	
	/**
	 * Returns the column text
	 * 
	 * @param element
	 *            the element
	 * @param columnIndex
	 *            the column index
	 * @return String
	 */
	public String getColumnText(Object element, int columnIndex) {
		IParameterEditor editor = (IParameterEditor) element;
		return String.valueOf( TableParameterColumnType.valueOf( registeredColumns.get( columnIndex), editor));
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            the listener
	 */
	public void addListener(ILabelProviderListener listener) {
		// Ignore it
	}

	/**
	 * Disposes any created resources
	 */
	public void dispose() {
		// Nothing to dispose
	}

	/**
	 * Returns whether altering this property on this element will affect
	 * the label
	 * 
	 * @param element
	 *            the element
	 * @param property
	 *            the property
	 * @return boolean
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the listener
	 */
	public void removeListener(ILabelProviderListener listener) {
		// Ignore
	}

}
