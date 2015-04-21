package edu.cuit.subframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import edu.cuit.DAOIMPL.SellDaoImpl;
import edu.cuit.bean.Provide;
import edu.cuit.bean.Sell;
import edu.cuit.dao.FeelDao;
import edu.cuit.dao.SellDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.Color;
public class UpdateSellFrame extends JFrame {

	private JPanel contentPane;
	private JTextField cNameTextField;
	private JTextField addressTextField;
	private JLabel linkNameLabel;
	private JTextField linkNameTextField;
	private JLabel linkPhoneLabel;
	private JTextField linkPhoneTextField;
	private JLabel fexesLabel;
	private JTextField faxesTextField;
	private JLabel postNumLabel;
	private JTextField postNumTextField;
	private JLabel bankNumLabel;
	private JTextField bankNumTextField;
	private JLabel netAddressLabel;
	private JTextField netAddressTextField;
	private JLabel emailLabel;
	private JTextField emaillTextField;
	private JLabel label;
	private JButton closeButton;
	JTextArea remarkTextArea = new JTextArea();
	cuit.edu.BEAN.Sell sell = null;
	/**
	 * Create the frame.
	 */
	public UpdateSellFrame() {
		setTitle("�޸������̴���");	
		//SellDao dao = new SellDao();
		cuit.edu.DAO.SellDao dao=new SellDaoImpl(); 
		try {
			  File file = new File("file.txt");
	            FileInputStream fin = new FileInputStream(file);
	            int count =  fin.read();	           
	            file.delete();
	            sell = dao.selectProvideByid(count);
	        } catch (Exception e) {
	          
	            e.printStackTrace();
	        }
	
		setBounds(100, 100, 635, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel cNameLabel = new JLabel("�ͻ����ƣ�");
		cNameLabel.setBounds(49, 53, 72, 15);
		contentPane.add(cNameLabel);

		cNameTextField = new JTextField();
		cNameTextField.setBackground(new Color(210, 105, 30));
		cNameTextField.setText(sell.getSellName());
		cNameTextField.setBounds(114, 50, 164, 25);
		contentPane.add(cNameTextField);
		cNameTextField.setColumns(10);

		JLabel addressLabel = new JLabel("�ͻ���ַ��");
		addressLabel.setBounds(315, 53, 72, 15);
		contentPane.add(addressLabel);

		addressTextField = new JTextField();
		addressTextField.setBackground(new Color(210, 105, 30));
		addressTextField.setText(sell.getAddress());
		addressTextField.setColumns(10);
		addressTextField.setBounds(385, 50, 164, 25);
		contentPane.add(addressTextField);

		linkNameLabel = new JLabel(" ��ϵ�ˣ�");
		linkNameLabel.setBounds(49, 97, 70, 15);
		contentPane.add(linkNameLabel);

		linkNameTextField = new JTextField();
		linkNameTextField.setBackground(new Color(210, 105, 30));
		linkNameTextField.setText(sell.getLinkman());
		linkNameTextField.setBounds(114, 94, 164, 25);
		contentPane.add(linkNameTextField);
		linkNameTextField.setColumns(10);

		linkPhoneLabel = new JLabel("��ϵ�绰��");
		linkPhoneLabel.setBounds(315, 97, 72, 15);
		contentPane.add(linkPhoneLabel);

		linkPhoneTextField = new JTextField();
		linkPhoneTextField.setBackground(new Color(210, 105, 30));
		linkPhoneTextField.setText(sell.getLinkPhone());
		linkPhoneTextField.setBounds(385, 94, 164, 25);
		contentPane.add(linkPhoneTextField);
		linkPhoneTextField.setColumns(10);

		fexesLabel = new JLabel("  �� �棺");
		fexesLabel.setBounds(50, 140, 54, 15);
		contentPane.add(fexesLabel);

		faxesTextField = new JTextField();
		faxesTextField.setBackground(new Color(210, 105, 30));
		faxesTextField.setText(sell.getFaxNum());
		faxesTextField.setColumns(10);
		faxesTextField.setBounds(114, 137, 164, 25);
		contentPane.add(faxesTextField);

		postNumLabel = new JLabel("  �� �ࣺ");
		postNumLabel.setBounds(321, 140, 54, 15);
		contentPane.add(postNumLabel);

		postNumTextField = new JTextField();
		postNumTextField.setBackground(new Color(210, 105, 30));
		postNumTextField.setText(sell.getPostNum());
		postNumTextField.setColumns(10);
		postNumTextField.setBounds(385, 137, 164, 25);
		contentPane.add(postNumTextField);

		bankNumLabel = new JLabel("�����˺ţ�");
		bankNumLabel.setBounds(49, 180, 72, 15);
		contentPane.add(bankNumLabel);

		bankNumTextField = new JTextField();
		bankNumTextField.setBackground(new Color(210, 105, 30));
		bankNumTextField.setText(sell.getBankNum());
		bankNumTextField.setColumns(10);
		bankNumTextField.setBounds(114, 177, 164, 25);
		contentPane.add(bankNumTextField);

		netAddressLabel = new JLabel("   �� ַ��");
		netAddressLabel.setBounds(315, 180, 60, 15);
		contentPane.add(netAddressLabel);

		netAddressTextField = new JTextField();
		netAddressTextField.setBackground(new Color(210, 105, 30));
		netAddressTextField.setText(sell.getNetAddress());
		netAddressTextField.setColumns(10);
		netAddressTextField.setBounds(385, 177, 164, 25);
		contentPane.add(netAddressTextField);

		emailLabel = new JLabel("   �� �䣺");
		emailLabel.setBounds(49, 223, 72, 15);
		contentPane.add(emailLabel);

		emaillTextField = new JTextField();
		emaillTextField.setBackground(new Color(210, 105, 30));
		emaillTextField.setText(sell.getEmaillAddress());
		emaillTextField.setColumns(10);
		emaillTextField.setBounds(114, 220, 164, 25);
		contentPane.add(emaillTextField);

		label = new JLabel("   �� ע��");
		label.setBounds(49, 294, 72, 15);
		contentPane.add(label);
		remarkTextArea.setBackground(new Color(210, 105, 30));

		remarkTextArea.setBounds(114, 267, 435, 89);
		contentPane.add(remarkTextArea);
		remarkTextArea.setText(sell.getRemark());
		JButton uodatetButton = new JButton("�޸�");
		uodatetButton.setBackground(new Color(210, 105, 30));
		uodatetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuit.edu.DAO.SellDao dao=new SellDaoImpl();				
				sell.setSellName(cNameTextField.getText());
				sell.setAddress(addressTextField.getText());
				sell.setLinkman(linkNameTextField.getText());
				sell.setLinkPhone(linkPhoneTextField.getText());
				sell.setBankNum(bankNumTextField.getText());
				sell.setFaxNum(faxesTextField.getText());
				sell.setPostNum(postNumTextField.getText());
				sell.setEmaillAddress(emaillTextField.getText());
				sell.setRemark(remarkTextArea.getText());
				sell.setNetAddress(netAddressTextField.getText());				
				dao.updateSell(sell);
				repaint();
				JOptionPane.showMessageDialog(getContentPane(), "�����޸ĳɹ���",
						"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		uodatetButton.setBounds(185, 388, 93, 23);
		contentPane.add(uodatetButton);

		closeButton = new JButton("�˳�");
		closeButton.setBackground(new Color(210, 105, 30));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_closeButton_actionPerformed(e);
			}
		});
		closeButton.setBounds(342, 388, 93, 23);
		contentPane.add(closeButton);
	}

	protected void do_closeButton_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
	}
}
