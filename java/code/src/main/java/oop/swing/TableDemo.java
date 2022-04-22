package oop.swing;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class TableDemo extends JFrame {
    public TableDemo() {
        super();
        MyTableModel model = new MyTableModel();
        model.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                // do something
                int row = e.getFirstRow();
                int column = e.getColumn();
                TableModel model = (TableModel)e.getSource();
                String columnName = model.getColumnName(column);
                Object data = model.getValueAt(row, column);
                System.out.printf("%d %d %s\n", row, column, data);
            }
        });

        JTable table = new JTable(model);
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);

        //Create and set up the window.
        JFrame frame = new JFrame("TableDemo");
        frame.setTitle("JTable Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new JScrollPane(table));
        frame.setSize(500, 150);
        frame.setVisible(true);
    }

    class MyTableModel extends AbstractTableModel {
        private final String[] columnNames = {
                "First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"
        };
        private final Object[][] data = {
                {"Kathy", "Smith", "Snowboarding", 5, false},
                {"John", "Doe", "Rowing", 3, true},
                {"Sue", "Black", "Knitting", 2, false},
                {"Jane", "White", "Speed reading", 20, true},
                {"Joe", "Brown", "Pool", 10, false}
        };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            return col >= 2;
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TableDemo::new);
    }
}