
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;







public class Window extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -8255319694373975038L;
	private Manager manager;
	private SearchTable search_table;

	GridBagConstraints c = new GridBagConstraints();
	CardLayout card_layout = new CardLayout();

	private JPanel mainPanel;
	private JPanel card_add, card_view;
	private JPanel card_view_top, card_view_center;
	
	private JTextField tf_departure_from, tf_arrival_at, tf_date_departure, tf_date_arrival,tf_number_of_passangers;
	private JTextArea textarea_view;
	private JComboBox comboboxSearch, comboboxRoom;
	private JCheckBox btn_include_breakast;
	private int combobox_index = 0;
	private JButton btn_sumbit,btn_view_all, btn_back;
	
	
	final static String ADD_PANEL = "Card with adding a booking form";
	final static String VIEW_PANEL = "Card with view form";
	
	
	
	
	
	//Constructor of Window
	public Window(int width, int height, String title, Manager manager) {
		
			
				this.manager = manager;
				JFrame frame = new JFrame(title);
				frame.setSize(width,height);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);	
				frame.setVisible(true);
			
				
				
				
				// Creating the components
				
				mainPanel = new JPanel(card_layout);
				card_add = new JPanel(new GridBagLayout());
				card_view = new JPanel(new BorderLayout());
				card_view_top = new JPanel();
				card_view_center = new JPanel(new BorderLayout());
				
			
				
			
				
				// SEARHCH Booking Card
				
				tf_departure_from = new JTextField(15);
				tf_arrival_at = new JTextField(15);
				tf_date_departure = new JTextField(15);
				tf_date_arrival = new JTextField(15);
				tf_number_of_passangers = new JTextField(15);
									
				btn_sumbit = new JButton("Search");
				btn_sumbit.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	clearInput();
		            	card_layout.show(mainPanel, VIEW_PANEL);
		            	/*try {
							manager.addObject(new Reservation(tf_first_name.getText(), tf_last_name.getText(), tf_phonenumber.getText(), tf_date_arrival.getText(),
									comboboxRoom.getSelectedItem().toString(), btn_include_breakast.isSelected()));
						} catch (IOException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	clearInput();
		            */ }
		        });
				c.insets = new Insets(6,6,6,6);
				c.fill = GridBagConstraints.HORIZONTAL;
				//c.weightx = 0.0;
				c.gridwidth = 2;
				c.gridx = 0;
				c.gridy = 0;
				card_add.add(new JLabel("Search a Flight by filling all the spaces below"),c);
				c.anchor = GridBagConstraints.LINE_START;  
				c.gridwidth = 1;
				c.gridx = 0;
				c.gridy = 1;
				card_add.add(new JLabel("Departure City"),c);
				c.gridx = 1;
				c.gridy = 1;
				card_add.add(tf_departure_from,c);
				c.gridx = 0;
				c.gridy = 2;
				card_add.add(new JLabel("Arrival City"),c);
				c.gridx = 1;
				c.gridy = 2;
				card_add.add(tf_arrival_at,c);
				c.gridx = 0;
				c.gridy = 3;
				card_add.add(new JLabel("Departure Date"),c);
				c.gridx = 1;
				c.gridy = 3;
				card_add.add(tf_date_departure,c);
				c.gridx = 0;
				c.gridy = 4;
				card_add.add(new JLabel("Arrival Date"),c);
				c.gridx = 1;
				c.gridy = 4;
				card_add.add(tf_date_arrival,c);
				c.gridx = 0;
				c.gridy = 5;
				card_add.add(new JLabel("Passnagers"),c);
				c.gridx = 1;
				c.gridy = 5;
				card_add.add(tf_number_of_passangers,c);
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 0.0;
				c.gridwidth = 2;
				c.gridx = 0;
				c.gridy = 6;
				card_add.add(btn_sumbit,c);
		
				
				
				//View Result card
				
				
				btn_view_all = new JButton("View all flights");
				btn_view_all.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	JOptionPane.showMessageDialog(null,"This button exists for debugging purposes only " );
		            	/*
		            	if(comboboxSearch.getSelectedIndex() == 0) {
		            		try {
								textarea_view.setText(manager.getAllList());
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		            	}
		            	else if(comboboxSearch.getSelectedIndex() == 1) {
		            		
		            		String name = tf_search.getText();
		            		try {
								textarea_view.setText(manager.getByNameList(name));
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		            	}
		            	
		            	clearInput();
		            */ }
		        });
				
				btn_back = new JButton("Go Back");
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	clearInput();
		            	card_layout.show(mainPanel, ADD_PANEL);
		            }
		        });
				

				
				card_view_top.add(btn_back);
				card_view_top.add(new JLabel(" 		 Can't find a flight? Press this button to view all the flights "));
				card_view_top.add(btn_view_all);
				
				
				
				search_table = new SearchTable(manager);
				
				search_table.refreshSearchTable();
			
				card_view_center.add(search_table.getJScrollPaneTable());
				
				card_view.add(card_view_top, BorderLayout.NORTH);
				card_view.add(card_view_center, BorderLayout.CENTER);
				
				
				
				
				//Adding everything together
				
				mainPanel.add(card_add, ADD_PANEL);
				mainPanel.add(card_view, VIEW_PANEL);
				frame.add(mainPanel);
				frame.setVisible(true);
			
			
				
					
		
	}//end of Constructor








	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void clearInput() {
		DateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
	
		
		tf_departure_from.setText("");
		tf_arrival_at.setText("");
		tf_date_departure.setText(date_format.format(date));
		tf_date_arrival.setText(date_format.format(date));
		tf_number_of_passangers.setText("");
	
	}



	
}//end of class Window