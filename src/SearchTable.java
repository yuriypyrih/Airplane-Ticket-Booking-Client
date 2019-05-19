
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class SearchTable {
	
	private JScrollPane scroll;
	private Manager manager;
	private DefaultTableModel default_model;
	private JTable table;
	

	
	//private LinkedList<Object[][]> objectDataList = new LinkedList<Object[][]>();
	
	private String[] columnNames = {"Type",
            "ID",
            "Departure",
            "Arrival",
            "Date",
            "Time",
            "Seat",
            "Price",
            "Book"
            };
	
	
    public SearchTable( Manager manager ) {
       
    	this.manager = manager;
    	
   

    	default_model = new DefaultTableModel() {
        	@Override
            public boolean isCellEditable(int row, int column) {
              
               return true;
            }
        };
        
        
        
        refreshSearchTable();
        
		/*data = new Object[][]{
				{"Hello"," World","Hello","Show more"},
				{"Okey","Bey","Hello"," Show more"}
		};*/
		
		
       
       
        
    }

    public JScrollPane getJScrollPaneTable() {
    	return scroll;
    }
    
    
    
    public void refreshSearchTable(){
    	//manager.addObject(new Flight(TYPE.FREE, "haha", "Okey","something","Athens" ,"DSAD","GFG", 400));
    	Object[][] data;
    	if(manager.get_flightList() != null) {
    		int list_size = manager.get_flightList().size();
        	int index = 0;
        	data = new Object[list_size][9];
        	
        	for(Flight flight : manager.get_flightList() ) {
        		data[index][0] = flight.getObjectDataTable()[0];
        		data[index][1] = flight.getObjectDataTable()[1];
        		data[index][2] = flight.getObjectDataTable()[2];
        		data[index][3] = flight.getObjectDataTable()[3];
        		data[index][4] = flight.getObjectDataTable()[4];
        		data[index][5] = flight.getObjectDataTable()[5];
        		data[index][6] = flight.getObjectDataTable()[6];
        		data[index][7] = flight.getObjectDataTable()[7];
 
        		System.out.println( flight.getObjectDataTable());
        		index++;
        	}
        	
    	}else {
    		data = new Object[0][9];
    	}
    	
    
    	
    	 table = new JTable(data, columnNames);
    	 
    	 //DefaultTableModel model = (DefaultTableModel) table.getModel();
    	 
    	 
         table.getColumn("Book").setCellRenderer(new ButtonRenderer());
         table.getColumn("Book").setCellEditor(new ButtonEditor(new JCheckBox(), manager));
         
        
         
         
         System.out.println(table.getRowCount());

         scroll = new JScrollPane(table);

         table.setPreferredScrollableViewportSize(table.getPreferredSize());

         table.getColumnModel().getColumn(0).setPreferredWidth(100);
         
         
       
    }
}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;
    private int index;
    private Manager manager;
   
    

    public ButtonEditor(JCheckBox checkBox, Manager manager) {
        super(checkBox);
     
        this.manager = manager;
    
        
        
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }
   
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        index = row;
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            JOptionPane.showMessageDialog(null, label + ": Additional Info\n" );
         
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}