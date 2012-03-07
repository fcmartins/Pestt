package ui.display.views.structural;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchPartSite;

public abstract class AbstractTableViewer {

	protected TableViewer createViewTable(Composite parent, IWorkbenchPartSite site, boolean check) {
		TableViewer viewer = null;
		if(check)
			viewer = new TableViewer(parent, SWT.CHECK | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		else
			viewer = new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		Table table = viewer.getTable(); // create the table.
		table.setHeaderVisible(true); // show header.
		table.setLinesVisible(true); // show table lines.
		viewer.setContentProvider(new ArrayContentProvider()); // set the content provider.
		site.setSelectionProvider(viewer); // Make the selection available to other views.
		return viewer;
	}
	
	protected TableViewerColumn createColumnsHeaders(TableViewer viewer, String columnName, int columnWidth, int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE); // the columns style.
		final TableColumn column = viewerColumn.getColumn(); // get the column.
		column.setText(columnName); // set the column title.
		column.setWidth(columnWidth); // set the column width.
		column.setAlignment(SWT.CENTER); // set the column alignment.
		column.setResizable(true); // set the column to be resizable.
		column.setMoveable(true); // set the column to be moveable.
		return viewerColumn;
	}
}
