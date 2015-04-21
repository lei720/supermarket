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
public class InserOutDepotFrame extends JFrame {
	private JPanel contentPane;
	private JLabel dateLabel;
	private JLabel joinTimeLabel;
	private JTextField joinTimeTextField;
	private JLabel remarkLabel;
	private JButton closeButton;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
//	OutDepotDao dao = new OutDepotDao();
	private cuit.edu.DAO.OutDepotDao dao=new OutDepotDaoImpl();
	private JComboBox dIdcomboBox;
	JTextArea remarkTextArea = new JTextArea();
	private JTextField wighttextField;
	private JLabel label_4;
	JButton button;
	 JComboBox comboBox;
	
	/**
	 * Create the frame.
	 */
	public InserOutDepotFrame() {
		setTitle("添加仓库出库窗体");	
		setBounds(100, 100, 689, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel dIdLabel = new JLabel("仓库编号：");
		dIdLabel.setBounds(37, 36, 74, 15);
		contentPane.add(dIdLabel);

		dateLabel = new JLabel(" 货品名称：");
		dateLabel.setBounds(328, 36, 70, 15);
		contentPane.add(dateLabel);

		joinTimeLabel = new JLabel("出库时间：");
		joinTimeLabel.setBounds(328, 77, 72, 15);
		contentPane.add(joinTimeLabel);

		joinTimeTextField = new JTextField();
		joinTimeTextField.setBackground(new Color(210, 105, 30));
		joinTimeTextField.setBounds(392, 72, 164, 25);
		contentPane.add(joinTimeTextField);
		joinTimeTextField.setColumns(10);

		remarkLabel = new JLabel("  备 注：");
		remarkLabel.setBounds(37, 158, 54, 15);
		contentPane.add(remarkLabel);
		
		
		JButton insertButton = new JButton("添加");
		insertButton.setBackground(new Color(210, 105, 30));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String did = dIdcomboBox.getSelectedItem().toString();				
				String joinTime = joinTimeTextField.getText();
				String wight = wighttextField.getText();
				String wName = comboBox.getSelectedItem().toString();
				float depotWight = 0;
				if((did.equals(""))|(joinTime.equals("")) ||(wight.equals(""))){
					JOptionPane.showMessageDialog(getContentPane(), "请将带星号的内容填写完整！",
							"信息提示框", JOptionPane.INFORMATION_MESSAGE);
					return;					
				}		
				try{
					depotWight = Float.parseFloat(wight);
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(getContentPane(), "请输出数值类型！",
							"信息提示框", JOptionPane.INFORMATION_MESSAGE);
					return;					
				}
				//OutDepotDao dao = new OutDepotDao();
				cuit.edu.DAO.OutDepotDao dao=new OutDepotDaoImpl();
				float wFloat = dao.selectJoinDepotAndDate(comboBox.getSelectedItem().toString(),Integer.parseInt(did));
				System.out.println("comboBox :"+comboBox.getSelectedItem().toString());
				System.out.println("INTEGER："+Integer.parseInt(did));
				if(wFloat<depotWight){
					JOptionPane.showMessageDialog(getContentPane(), "仓库中只有"+wFloat+"千克了！",
							"信息提示框", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				cuit.edu.BEAN.OutDepot outDepot = new cuit.edu.BEAN.OutDepot();
				int idid = Integer.parseInt(did);
				outDepot.setDid(idid);
				outDepot.setOutDate(joinTimeTextField.getText());
				outDepot.setWight(depotWight);
				outDepot.setRemark(remarkTextArea.getText());
				outDepot.setWname(wName);
				dao.insertOutDepot(outDepot);
				dao.updateJoin(idid,wName,depotWight);
				JOptionPane.showMessageDialog(getContentPane(), "数据添加成功！",
						"信息提示框", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		insertButton.setBounds(187, 273, 93, 23);
		contentPane.add(insertButton);

		closeButton = new JButton("退出");
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
		contentPane.add(remarkTextArea);
		List listDid = jDao.selectDepotId();
		Integer[] did = new Integer [listDid.size()]; 
		for(int j = 0;j<listDid.size();j++){
			did[j] = (Integer)listDid.get(j);
		}
		dIdcomboBox = new JComboBox(did);

		
		String str = dIdcomboBox.getSelectedItem().toString();
		JoinDepotDao dao2 = new JoinDepotDao();
		List list2 = dao2.selectNameBydId(Integer.parseInt(str));
		String[] date=new String[list2.size()];
		for (int i = 0; i < list2.size(); i++) {		//循环遍历查询结果集
			date[i]=(String) list2.get(i);
			//comboBox.addItem(list2.get(i));		//像姓名下拉列表中添加元素				
			
		}
		comboBox=new JComboBox(date);
		comboBox.setBackground(new Color(210, 105, 30));
		
		
	//	comboBox.removeAllItems();
	
	//	this.repaint();
		//comboBox.setVisible(true);
	//	comboBox.setSelectedIndex(0);
		//contentPane.add(comboBox);
	/*new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < list2.size(); i++) {		//循环遍历查询结果集
				//comboBox.removeAllItems();
			
				comboBox.addItem(list2.get(i));		//像姓名下拉列表中添加元素				
			
			}
			repaint();
		}
	}).start();*/
	//System.out.println(comboBox.toString());
	//repaint();
	//repaint();
		
		dIdcomboBox.setBackground(new Color(210, 105, 30));
		dIdcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				System.out.println("didselect: "+dIdcomboBox.getSelectedItem().toString());	
				String str = dIdcomboBox.getSelectedItem().toString();
				JoinDepotDao dao = new JoinDepotDao();
				List list = dao.selectNameBydId(Integer.parseInt(str));
				for (int i = 0; i < list.size(); i++) {		//循环遍历查询结果集
					comboBox.addItem(list.get(i));		//像姓名下拉列表中添加元素				
				}
				
		
			}
		});
		dIdcomboBox.setBounds(101, 33, 164, 21);
		contentPane.add(dIdcomboBox);
		
		JLabel wightlabel = new JLabel("重量： ");
		wightlabel.setBounds(59, 76, 44, 15);
		contentPane.add(wightlabel);
		
		wighttextField = new JTextField();
		wighttextField.setBackground(new Color(210, 105, 30));
		wighttextField.setBounds(101, 73, 164, 25);
		contentPane.add(wighttextField);
		wighttextField.setColumns(10);
		
		JLabel label = new JLabel("千克");
		label.setBounds(275, 77, 31, 15);
		contentPane.add(label);
		
		label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(311, 77, 7, 15);
		contentPane.add(label_4);
		
		button = new JButton("现在");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button.getText().equals("清除")){
					joinTimeTextField.setText("");
					button.setText("现在");
				}
				else{GetDate getDate = new GetDate();
				String strDate = getDate.getDateTime();
				joinTimeTextField.setText(strDate);
				button.setText("清除");
				}
			}
		});
		button.setBounds(566, 73, 71, 23);
		contentPane.add(button);	
	/*	List listName = dao.selectOutDepotNames(Integer.parseInt(dIdcomboBox.getSelectedItem().toString()));
		String [] orderName = new String[listName.size()+1];
		orderName[0] = "";
		for(int j = 0;j<listName.size();j++){
			orderName[j+1] = listName.get(j).toString(); 
		}		*/
	//	comboBox = new JComboBox(orderName);
		comboBox.setBackground(new Color(210, 105, 30));
	/*	comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			}
		});*/
		comboBox.setBounds(392, 33, 164, 21);
		contentPane.add(comboBox);
		this.setVisible(true);
	}
	protected void do_closeButton_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
	}
}
