package edu.cuit.subframe;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import edu.cuit.DAOIMPL.OutDepotDaoImpl;
import edu.cuit.bean.JoinDepot;
import edu.cuit.bean.OutDepot;
import edu.cuit.bean.Provide;
import edu.cuit.bean.Sell;
import edu.cuit.bean.Stock;
import edu.cuit.dao.FeelDao;
import edu.cuit.dao.JoinDepotDao;
import edu.cuit.dao.OutDepotDao;
import edu.cuit.dao.SellDao;
import edu.cuit.dao.StockDao;
import edu.cuit.util.GetDate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Date;
import java.util.List;

import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
public class UpdateOutDepotFrame extends JFrame {
	private JPanel contentPane;
	private JLabel dateLabel;
	private JLabel joinTimeLabel;
	private JTextField joinTimeTextField;
	private JLabel remarkLabel;
	private JButton closeButton;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private cuit.edu.DAO.OutDepotDao dao=new OutDepotDaoImpl();
	private JComboBox dIdcomboBox;
	JTextArea remarkTextArea = new JTextArea();
	private JTextField wighttextField;
	private JLabel label_4;
	JButton button;
	JComboBox comboBox;
	cuit.edu.BEAN.OutDepot outDepot = new cuit.edu.BEAN.OutDepot();
	/**
	 * Create the frame.
	 */
	public UpdateOutDepotFrame() {
		setBackground(new Color(160, 82, 45));
		setTitle("�޸Ĳֿ���ⴰ��");	
		setBounds(100, 100, 689, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 try {
			  File file = new File("file.txt");
	            FileInputStream fin = new FileInputStream(file);
	            int count =  fin.read();	           
	            file.delete();
	            outDepot = dao.selectOutDepotByid(count);
	            
	        } catch (Exception e) {	           
	            e.printStackTrace();
	        }
	
		JLabel dIdLabel = new JLabel("�ֿ��ţ�");
		dIdLabel.setBounds(37, 36, 74, 15);
		contentPane.add(dIdLabel);

		dateLabel = new JLabel(" ��Ʒ���ƣ�");
		dateLabel.setBounds(328, 36, 70, 15);
		contentPane.add(dateLabel);

		joinTimeLabel = new JLabel("����ʱ�䣺");
		joinTimeLabel.setBounds(328, 77, 72, 15);
		contentPane.add(joinTimeLabel);

		joinTimeTextField = new JTextField();
		joinTimeTextField.setBackground(new Color(210, 105, 30));
		joinTimeTextField.setBounds(392, 72, 164, 25);
		contentPane.add(joinTimeTextField);
		joinTimeTextField.setColumns(10);

		remarkLabel = new JLabel("  �� ע��");
		remarkLabel.setBounds(37, 158, 54, 15);
		contentPane.add(remarkLabel);
		
		
		JButton insertButton = new JButton("�޸�");
		insertButton.setBackground(new Color(210, 105, 30));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String did = dIdcomboBox.getSelectedItem().toString();				
				String joinTime = joinTimeTextField.getText();
				String wight = wighttextField.getText();
				String wName = comboBox.getSelectedItem().toString();
				Float depotWight ;
				if((did.equals(""))|(joinTime.equals("")) ||(wight.equals(""))){
					JOptionPane.showMessageDialog(getContentPane(), "�뽫���Ǻŵ�������д������",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;					
				}		
				try{
					depotWight = Float.parseFloat(wight);
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(getContentPane(), "�������ֵ���ͣ�",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;					
				}
				//OutDepotDao dao = new OutDepotDao();
				cuit.edu.DAO.OutDepotDao dao=new OutDepotDaoImpl();
				Float wFloat = outDepot.getWight();
				if(wFloat<depotWight){
					JOptionPane.showMessageDialog(getContentPane(), "�ֿ���ֻ��"+wFloat+"ǧ���ˣ�",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				}				
				int idid = Integer.parseInt(did);
				outDepot.setDid(idid);
				outDepot.setOutDate(joinTimeTextField.getText());
				outDepot.setWight(depotWight);
				outDepot.setRemark(remarkTextArea.getText());
				outDepot.setWname(wName);
				dao.updateOutDepot(outDepot);
				if(wFloat>depotWight){
				dao.updateJoinAdd(idid,wName,depotWight);
				}
				JOptionPane.showMessageDialog(getContentPane(), "�����޸ĳɹ���",
						"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		insertButton.setBounds(187, 273, 93, 23);
		contentPane.add(insertButton);

		closeButton = new JButton("�˳�");
		closeButton.setBackground(new Color(210, 105, 30));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_closeButton_actionPerformed(e);
			}
		});
		closeButton.setBounds(328, 273, 93, 23);
		contentPane.add(closeButton);
		
		label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(284, 36, 7, 15);
		contentPane.add(label_1);
		
		label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(579, 36, 7, 15);
		contentPane.add(label_2);
		
		label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(647, 77, 7, 15);
		contentPane.add(label_3);
		JoinDepotDao jDao = new JoinDepotDao();
		List list = jDao.selectOidId();
		String [] orderId = new String[list.size()+1];
		orderId[0] = "";
		for(int i = 0;i<list.size();i++){
			orderId[i+1 ]=  (String)list.get(i);
		}
		remarkTextArea.setBackground(new Color(210, 105, 30));
		remarkTextArea.setBounds(101, 123, 417, 112);
		remarkTextArea.setText(outDepot.getRemark());
		contentPane.add(remarkTextArea);
		List listDid = jDao.selectDepotId();
		Integer[] did = new Integer [listDid.size()]; 
		for(int j = 0;j<listDid.size();j++){
			did[j] = (Integer)listDid.get(j);
		}
		dIdcomboBox = new JComboBox(did);
		dIdcomboBox.setBackground(new Color(210, 105, 30));
		dIdcomboBox.setSelectedItem(outDepot.getDid());
		dIdcomboBox.setBounds(101, 33, 164, 21);
		contentPane.add(dIdcomboBox);
		
		JLabel wightlabel = new JLabel("������ ");
		wightlabel.setBounds(59, 76, 44, 15);
		contentPane.add(wightlabel);
		
		wighttextField = new JTextField();
		wighttextField.setBackground(new Color(210, 105, 30));
		wighttextField.setText(outDepot.getWight()+"");
		wighttextField.setBounds(101, 73, 164, 25);
		contentPane.add(wighttextField);
		wighttextField.setColumns(10);
		
		JLabel label = new JLabel("ǧ��");
		label.setBounds(275, 77, 31, 15);
		contentPane.add(label);
		
		label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(311, 77, 7, 15);
		contentPane.add(label_4);
		
		button = new JButton("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button.getText().equals("���")){
					joinTimeTextField.setText("");
					button.setText("����");
				}
				else{GetDate getDate = new GetDate();
				String strDate = getDate.getDateTime();
				joinTimeTextField.setText(strDate);
				button.setText("���");
				}
			}
		});
		joinTimeTextField.setText(outDepot.getOutDate());
		button.setBounds(566, 73, 71, 23);
		contentPane.add(button);	
		List listName = dao.selectOutDepotNames(Integer.parseInt(dIdcomboBox.getSelectedItem().toString()));
		String [] orderName = new String[listName.size()+1];
		orderName[0] = "";
		for(int j = 0;j<listName.size();j++){
			orderName[j+1] = listName.get(j).toString(); 
		}		
		comboBox = new JComboBox(orderName);
		comboBox.setBackground(new Color(210, 105, 30));
		comboBox.setSelectedItem(outDepot.getWname());
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		comboBox.setBounds(392, 33, 164, 21);
		contentPane.add(comboBox);
	}
	protected void do_closeButton_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
	}
}
