package edu.cuit.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static javax.swing.BorderFactory.createTitledBorder;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import edu.cuit.bean.Provide;
import edu.cuit.dao.FeelDao;
import edu.cuit.model.LocalTableModel;
import edu.cuit.subframe.InsertProvideFrame;
import edu.cuit.subframe.UpdateProvideFrame;

import java.io.*;

public class FeelWarePanel extends JPanel {
	private JPanel message;
	private JTextField nameTextField;
	private JTable table;
	private JTextField addressTextField;
	FeelDao feelDao = new FeelDao();
	LocalTableModel model = new LocalTableModel();
	/**
	 * Create the panel.
	 */
	public FeelWarePanel() {
		setBackground(new Color(160, 82, 45));

	}

	public JPanel getMessage() {
		this.setBorder(createTitledBorder(null, "��������Ϣ",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, new Font(
						"sansserif", Font.BOLD, 12), new Color(210, 105, 30)));
		message = new JPanel();
		
		message.setBackground(new Color(210, 105, 30));
		//message.setBackground(new Color(210, 105, 30));
		message.setBounds(0, 0, 520, 394);
		message.setLayout(null);
		JLabel nameLabel = new JLabel("�ͻ�����");
		
		nameLabel.setBackground(new Color(210, 105, 30));
		nameLabel.setBounds(10, 34, 54, 15);
		message.add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setBounds(62, 31, 97, 25);
		nameTextField.setBackground(new Color(210, 105, 30));
		message.add(nameTextField);
		nameTextField.setColumns(10);

		JLabel addresLlabel = new JLabel("��ַ");
		addresLlabel.setBounds(169, 34, 38, 15);
		message.add(addresLlabel);

		addressTextField = new JTextField();
		addressTextField.setBounds(204, 31, 119, 25);
		addressTextField.setBackground(new Color(210, 105, 30));
		message.add(addressTextField);
		addressTextField.setColumns(10);

		JButton findButton = new JButton("����");
		findButton.setBackground(new Color(210, 105, 30));
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				String name = nameTextField.getText();
				String address = addressTextField.getText();				
				if((name.equals("")) && (address.equals(""))){					
					JOptionPane.showMessageDialog(getParent(), "����д��ѯ������",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;					
				}
				if((!name.equals(""))&&(address.equals(""))){
					 List list = feelDao.selectProvideByName(name);
					 for(int i = 0;i<list.size();i++){
						 Provide provide = (Provide)list.get(i);
						 model.addRow(new Object[] { provide.getId(), provide.getcName(),
									provide.getAddress(), provide.getLinkman(),
									provide.getLinkPhone(), provide.getFaxes(),
									provide.getPostNum(), provide.getBankNum(),
									provide.getNetAddress(), provide.getEmaillAddress(),
									provide.getRemark() });
					 }
				}
				if((name.equals(""))&&(!address.equals(""))){
					List list = feelDao.selectProvideByAddress(address);
					for(int i =0;i<list.size();i++){
						 Provide provide = (Provide)list.get(i);
						 model.addRow(new Object[] { provide.getId(), provide.getcName(),
									provide.getAddress(), provide.getLinkman(),
									provide.getLinkPhone(), provide.getFaxes(),
									provide.getPostNum(), provide.getBankNum(),
									provide.getNetAddress(), provide.getEmaillAddress(),
									provide.getRemark() });
					}
				}
				if((!name.equals("")) && (!address.equals(""))){
					List list = feelDao.selectProvideByNameAddress(address, name);
					for(int i =0;i<list.size();i++){
					 Provide provide = (Provide)list.get(i);
					 model.addRow(new Object[] { provide.getId(), provide.getcName(),
								provide.getAddress(), provide.getLinkman(),
								provide.getLinkPhone(), provide.getFaxes(),
								provide.getPostNum(), provide.getBankNum(),
								provide.getNetAddress(), provide.getEmaillAddress(),
								provide.getRemark() 
						});
					}
				}
				if (model.getRowCount()==0) {
					model.setRowCount(20);
				} else {

				}
			}
		});
		findButton.setBounds(333, 30, 77, 23);
		message.add(findButton);
		JButton insertButton = new JButton("���");
		insertButton.setBackground(new Color(210, 105, 30));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertProvideFrame insertProvide = new InsertProvideFrame();
				insertProvide.setVisible(true);
			}
		});
		insertButton.setBounds(51, 313, 77, 23);
		message.add(insertButton);

		JButton updateButton = new JButton("�޸�");
		updateButton.setBackground(new Color(210, 105, 30));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
			  				
				if (row < 0) {
					JOptionPane.showMessageDialog(getParent(), "û��ѡ��Ҫ�޸ĵ����ݣ�",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					File file = new File("file.txt");
					try {
						 String column =	model.getValueAt(row, 0).toString();			
						file.createNewFile();
						FileOutputStream out = new FileOutputStream(file);
						out.write((Integer.parseInt(column)));
						out.close();					
						UpdateProvideFrame update = new UpdateProvideFrame();
						update.setVisible(true);
						repaint();
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		});
		updateButton.setBounds(169, 313, 77, 23);
		message.add(updateButton);
		JButton deleteButton = new JButton("ɾ��");
		deleteButton.setBackground(new Color(210, 105, 30));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String column =	model.getValueAt(row, 0).toString();
				if (Integer.parseInt(column) < 0) {
					JOptionPane.showMessageDialog(getParent(), "û��ѡ��Ҫ�h�������ݣ�",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					
					feelDao.deleteProvide(Integer.parseInt(column));
					JOptionPane.showMessageDialog(getParent(), "����ɾ���ɹ���",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					repaint();

				}
			}
		});
		deleteButton.setBounds(285, 313, 77, 23);
		message.add(deleteButton);
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 70, 416, 233);
		message.add(scrollPane_2);

		table = new JTable(model);
		repaint();
		List list = feelDao.selectProvide();
		model.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			Provide provide = (Provide) list.get(i);
			model.addRow(new Object[] { provide.getId(), provide.getcName(),
					provide.getAddress(), provide.getLinkman(),
					provide.getLinkPhone(), provide.getFaxes(),
					provide.getPostNum(), provide.getBankNum(),
					provide.getNetAddress(), provide.getEmaillAddress(),
					provide.getRemark() });
		}
		if (model.getRowCount()==0) {
			model.setRowCount(20);
		} else {

		}
		scrollPane_2.setViewportView(table);
		return message;

	}

}
