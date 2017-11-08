package com.java94;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;

public class ComponentDemoUI extends JFrame {

	private JPanel contentPane;

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComponentDemoUI frame = new ComponentDemoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JComboBox cbHobby ;
	private JTable tbScore;

	/**
	 * Create the frame.
	 */
	public ComponentDemoUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//初始化cbHobby 
		cbHobby = new JComboBox();
		cbHobby.setToolTipText("\u5174\u8DA3");
		
		cbHobby.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent ie) {
				ComponentDemoUI.this.setTitle(ie.getItem().toString());
				
			}
		});
		
		
		//创建Model，将Model设置到combox/table
		cbHobby.setModel(new DefaultComboBoxModel(new String[] {"\u8DB3\u7403", "\u7BEE\u7403", "\u4E52\u4E53\u7403", "\u7F16\u7A0B"}));
		cbHobby.setSelectedIndex(0);
		
		DefaultComboBoxModel dcbm = (DefaultComboBoxModel) cbHobby.getModel();
		dcbm.removeElementAt(2);
		cbHobby.setRenderer(new ListCellRenderer<String>() {

			@Override
			public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
					boolean isSelected, boolean cellHasFocus) {
				//System.out.println(arg1+" "+arg2);
				JLabel label = new JLabel(value);
				if(isSelected){
					label.setBackground(Color.RED);
					label.setForeground(Color.RED);
				}
				return label;
			}

	
		});
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		
		tbScore = new JTable();
		tbScore.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(tbScore, GroupLayout.PREFERRED_SIZE, 559, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(cbHobby, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(66)
							.addComponent(chckbxNewCheckBox)
							.addGap(18)
							.addComponent(rdbtnNewRadioButton)))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbHobby, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxNewCheckBox)
						.addComponent(rdbtnNewRadioButton))
					.addGap(19)
					.addComponent(tbScore, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(170, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
