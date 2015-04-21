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

import edu.cuit.DAOIMPL.WareDaoImpl;
import edu.cuit.bean.Provide;
import edu.cuit.bean.Ware;
import edu.cuit.dao.FeelDao;
import edu.cuit.dao.WareDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InsertWareFrame extends JFrame {

	private JPanel contentPane;
	private JTextField cNameTextField;
	private JTextField bewriteTextField;
	private JLabel unitLabel;
	private JTextField unitTextField;
	private JLabel stockLabel;
	private JTextField stockTextField;
	private JLabel retailLabel;
	private JTextField retailTextField;
	private JLabel memberLabel;
	private JTextField memberTextField;
	private JButton closeButton;
	private JLabel starLabel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	/**
	 * Create the frame.
	 */
	public InsertWareFrame() {
		setTitle("��ӻ�Ʒ����");	
		setBounds(100, 100, 635, 267);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel cNameLabel = new JLabel("��Ʒ���ƣ�");
		cNameLabel.setBounds(49, 53, 65, 15);
		contentPane.add(cNameLabel);

		cNameTextField = new JTextField();
		cNameTextField.setBackground(new Color(210, 105, 30));
		cNameTextField.setBounds(114, 50, 164, 25);
		contentPane.add(cNameTextField);
		cNameTextField.setColumns(10);

		JLabel bewriteLabel = new JLabel("��Ʒ������");
		bewriteLabel.setBounds(315, 53, 72, 15);
		contentPane.add(bewriteLabel);

		bewriteTextField = new JTextField();
		bewriteTextField.setBackground(new Color(210, 105, 30));
		bewriteTextField.setColumns(10);
		bewriteTextField.setBounds(385, 50, 164, 25);
		contentPane.add(bewriteTextField);

		unitLabel = new JLabel(" ��  λ��");
		unitLabel.setBounds(49, 97, 54, 15);
		contentPane.add(unitLabel);

		unitTextField = new JTextField();
		unitTextField.setBackground(new Color(210, 105, 30));
		unitTextField.setBounds(114, 94, 164, 25);
		contentPane.add(unitTextField);
		unitTextField.setColumns(10);

		stockLabel = new JLabel("�� �� �ۣ�");
		stockLabel.setBounds(315, 97, 72, 15);
		contentPane.add(stockLabel);

		stockTextField = new JTextField();
		stockTextField.setBackground(new Color(210, 105, 30));
		stockTextField.setBounds(385, 94, 164, 25);
		contentPane.add(stockTextField);
		stockTextField.setColumns(10);

		retailLabel = new JLabel("�� �� �ۣ�");
		retailLabel.setBounds(49, 142, 65, 15);
		contentPane.add(retailLabel);

		retailTextField = new JTextField();
		retailTextField.setBackground(new Color(210, 105, 30));
		retailTextField.setColumns(10);
		retailTextField.setBounds(114, 137, 164, 25);
		contentPane.add(retailTextField);

		memberLabel = new JLabel("�� Ա �ۣ�");
		memberLabel.setBounds(315, 140, 60, 15);
		contentPane.add(memberLabel);

		memberTextField = new JTextField();
		memberTextField.setBackground(new Color(210, 105, 30));
		memberTextField.setColumns(10);
		memberTextField.setBounds(385, 137, 164, 25);
		contentPane.add(memberTextField);

		JButton insertButton = new JButton("���");
		insertButton.setBackground(new Color(210, 105, 30));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	WareDao dao = new WareDao();
				cuit.edu.DAO.WareDao dao=new WareDaoImpl();
				String cName = cNameTextField.getText();
				String bewrite = bewriteTextField.getText();
				String unit = stockTextField.getText();
				String retail = retailTextField.getText();
				String member = memberTextField.getText();	
				String spec = unitTextField.getText();
				String stock = stockTextField.getText();
				Double memberPrice =0.0;
				Double unitPrice = 0.0;
				Double retailPrice = 0.0;
				if((cName.equals(""))||(bewrite.equals(""))||(unit.equals(""))||
						(retail.equals(""))||(member.equals(""))){
					JOptionPane.showMessageDialog(getContentPane(), "�����Ǻŵ���Ϣ��д������",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				try{
					unitPrice = Double.parseDouble(unit);
					retailPrice = Double.parseDouble(retail);
					memberPrice = Double.parseDouble(member);
					
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(getContentPane(), "�����ۡ����ۼۡ���Ա�۱��������֣�",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				}				
			cuit.edu.BEAN.Ware ware=new cuit.edu.BEAN.Ware();
				//Ware ware = new Ware();
				ware.setWareName(cName);
				ware.setWarBewrite(bewrite);
				ware.setAssociatorPrice(memberPrice);
				ware.setSpec(spec);
				ware.setStockPrice(memberPrice);
				ware.setRetailPrice(retailPrice);
				dao.insertWare(ware);
				JOptionPane.showMessageDialog(getContentPane(), "������ӳɹ���",
						"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
				

			}
		});
		insertButton.setBounds(185, 185, 93, 23);
		contentPane.add(insertButton);

		closeButton = new JButton("�˳�");
		closeButton.setBackground(new Color(210, 105, 30));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_closeButton_actionPerformed(e);
			}
		});
		closeButton.setBounds(315, 185, 93, 23);
		contentPane.add(closeButton);
		
		starLabel = new JLabel("*");
		starLabel.setForeground(Color.RED);
		starLabel.setBounds(283, 53, 6, 15);
		contentPane.add(starLabel);
		
		label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(559, 53, 6, 15);
		contentPane.add(label_1);
		
		label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(283, 97, 6, 15);
		contentPane.add(label_2);
		
		label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(559, 97, 6, 15);
		contentPane.add(label_3);
		
		label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(283, 140, 6, 15);
		contentPane.add(label_4);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(559, 140, 6, 15);
		contentPane.add(label);
	}

	protected void do_closeButton_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
	}
}
