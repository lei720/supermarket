package edu.cuit.panel;
import static javax.swing.BorderFactory.createTitledBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JScrollPane;

import edu.cuit.bean.BasicMessage;
import edu.cuit.bean.Contact;
import edu.cuit.bean.Dept;
import edu.cuit.dao.DeptDao;
import edu.cuit.dao.PersonnelDao;
import edu.cuit.model.JoinDepotModel;
import edu.cuit.subframe.InsertPersonnelFrame;
import edu.cuit.subframe.UpdatePersonnelFrame;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JRadioButton;
public class PersonnelPanel extends JPanel {
	final JoinDepotModel model = new JoinDepotModel();
	private final PersonnelDao perdao = new PersonnelDao();
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JComboBox pNameComboBox = new JComboBox();
	JPanel contactpanel;
	private Contact contact = new Contact();
	JPanel panel_1 = new JPanel();	
	JPanel contentPanel = new JPanel();
	private BasicMessage message = new BasicMessage();
	private JRadioButton manRadioButton;
	private JRadioButton wradioButton ;
	private JTextField deptField;
	private JTextField headshipField ;
	private JTextField pnoneTextField;
	private JTextField officeTextField;
	private JTextField faxTextField;
	private JTextField emailtextField;
	private JTextField addressTextField;
	private int pId;
	public PersonnelPanel() {
		this.setBorder(createTitledBorder(null, "��Ա����",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, new Font(
						"sansserif", Font.BOLD, 12), new Color(59, 59, 59)));
		setSize(631, 427);
		setLayout(null);
		this.setBackground(new Color(160, 82, 45));
		panel_1.setBackground(new Color(160, 82, 45));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 82, 45));
		panel.setBorder(BorderFactory.createTitledBorder(null, "Ա����Ϣ",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.ABOVE_TOP,
				new Font("sansserif", Font.BOLD, 12), new Color(59, 59, 59)));
		panel.setBounds(29, 25, 572, 71);
		add(panel);
		panel.setLayout(null);
		JLabel dNameLabel = new JLabel("��  �ţ�");
		dNameLabel.setBackground(new Color(210, 105, 30));
		dNameLabel.setBounds(70, 35, 54, 15);
		panel.add(dNameLabel);
		final DeptDao dao = new DeptDao();
List list = dao.selectDept();					//���ò�ѯ���в�����Ϣ����
String dName[] = new String[list.size() + 1];	//���ݲ�ѯ��������ַ����������
dName[0] = "";
for (int i = 0; i < list.size(); i++) {			//ѭ��������ѯ�����
	Dept dept = (Dept) list.get(i);
	dName[i + 1] = dept.getdName();				//��ȡ��ѯ����в�������
}		
final JComboBox dNamecomboBox = new JComboBox(dName);	//ʵ���������б����
dNamecomboBox.setBackground(new Color(210, 105, 30));
	dNamecomboBox.addActionListener((new ActionListener() {		//��������б�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {			
				pNameComboBox.removeAllItems();
				String dName = dNamecomboBox.getSelectedItem().toString();	//��ȡ�û�ѡ��Ĳ�������
				DeptDao deptDao = new DeptDao();				//���屣���в������ݿ������
				int id = deptDao.selectDeptIdByName(dName);		//���û�ȡ���ű�ŷ���
				List<String> listName = perdao.selectBasicMessageByDept(id);	//���ð����ű�Ų�ѯ����Ա����Ϣ����				
				for (int i = 0; i < listName.size(); i++) {		//ѭ��������ѯ�����
					pNameComboBox.addItem(listName.get(i));		//�����������б������Ԫ��				
				}
				repaint();
		}
}));

		dNamecomboBox.setBounds(134, 32, 102, 21);
		panel.add(dNamecomboBox);

		JLabel pNameLabel = new JLabel("������");
		pNameLabel.setBackground(new Color(210, 105, 30));
		pNameLabel.setBounds(262, 35, 54, 15);
		panel.add(pNameLabel);	
		pNameComboBox.setBackground(new Color(210, 105, 30));

		
		pNameComboBox.setBounds(310, 32, 101, 21);
		panel.add(pNameComboBox);
		
		contentPanel.setLayout(null);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(null, "Ա����Ϣ",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.ABOVE_TOP,
				new Font("sansserif", Font.BOLD, 12), new Color(59, 59, 59)));
		panel_1.setBounds(29, 106, 572, 310);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(210, 105, 30));
		scrollPane.setBorder(createTitledBorder(null, "Ա����Ϣ",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, new Font(
						"sansserif", Font.BOLD, 12), new Color(59, 59, 59)));
		scrollPane.setBounds(21, 53, 109, 218);
		panel_1.add(scrollPane);
		String name[] = { "������Ϣ", "��ϵ��ʽ" };
		final JList jlist = new JList(name);
		jlist.setBackground(new Color(160, 82, 45));
		final JPanel bpanel =  basicPanel();
		final JPanel particular = particularPsnel();
jlist.addListSelectionListener(new ListSelectionListener() {
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			if(dNamecomboBox.getSelectedItem() == null ||pNameComboBox.getSelectedItem()== null){
				JOptionPane.showMessageDialog(getParent(), "û��ѡ���ѯ��Ա����",
						"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			JList list = (JList) e.getSource();// ��ȡ�¼�Դ
			// ��ȡ�б�ѡ�ת��Ϊ�ַ���
			String value = (String) list.getSelectedValue();
			if(value.equals("������Ϣ")){									//�ж��û��Ƿ�ѡ���ˡ�������Ϣ��
				String name = pNameComboBox.getSelectedItem().toString();	//��ȡ�û�ѡ���Ա������
				panel_1.remove(particular);									//�Ƴ���ʾԱ����ϸ��Ϣ�����	
				panel_1.add(bpanel);					
				bpanel.setBounds(140, 53, 409, 208);
				message = perdao.selectBNameById(dNamecomboBox.getSelectedItem().toString(),name);			//���ò�ѯ���ݷ���
				pId = message.getId();										
				nameTextField.setText(message.getName());					//����Ա������ϵͳ�е��������
				ageTextField.setText(message.getAge()+"");
				String sex = message.getSex();										
				if(sex.equals("��")){
					manRadioButton.setSelected(true);						//���ô������Ա�ѡ��ť����ʾ����
				}
				else{
					wradioButton.setSelected(true);
				}
				int dept = message.getDept();
				Dept depts = dao.selectDepotById(dept);						//���ղ��ű�Ų�ѯԱ�����ڲ�����Ϣ
				deptField.setText(depts.getdName());						//����Ա����������
			    String hName =	perdao.selectHeadshipById(message.getHeadship());
			    headshipField.setText(hName);
			    repaint();
			}
			if(value.equals("��ϵ��ʽ")){
				panel_1.remove(bpanel);
				panel_1.add(particular);					
				contact = perdao.selectContactById(pId);
				pnoneTextField.setText(contact.getContact());
				officeTextField.setText(contact.getOfficePhone());
				faxTextField.setText(contact.getFax());
				emailtextField.setText(contact.getEmail());
				addressTextField.setText(contact.getFaddress());
				repaint();
			}
			doLayout();
		}

	}
});
		scrollPane.setViewportView(jlist);
		JButton insertButton = new JButton("���");
		insertButton.setBackground(new Color(210, 105, 30));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertPersonnelFrame frame = new InsertPersonnelFrame();
				frame.setVisible(true);
			}
		});
		insertButton.setBounds(179, 266, 62, 23);
		panel_1.add(insertButton);

		JButton updateButton = new JButton("�޸�");
		updateButton.setBackground(new Color(210, 105, 30));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				if(dNamecomboBox.getSelectedItem() == null || pNameComboBox.getSelectedItem()== null){
					JOptionPane.showMessageDialog(getParent(), "�������޸�������",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				message = perdao.selectBNameById(dNamecomboBox.getSelectedItem().toString(),pNameComboBox.getSelectedItem().toString());
				pId = message.getId();
				if (pId < 0) {
					JOptionPane.showMessageDialog(getParent(), "û��ѡ��Ҫ�޸ĵ����ݣ�",
							"��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					File file = new File("file.txt");
					try {						 
						file.createNewFile();
						FileOutputStream out = new FileOutputStream(file);					
						out.write(pId);
						out.close();									
						UpdatePersonnelFrame updateFrame = new UpdatePersonnelFrame();
						updateFrame.setVisible(true);
						repaint();
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		});
		updateButton.setBounds(275, 266, 62, 23);
		panel_1.add(updateButton);

JButton deleteButton = new JButton("ɾ��");
deleteButton.setBackground(new Color(210, 105, 30));
deleteButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		   int n = JOptionPane.showConfirmDialog(getParent(), 
                    "ȷ����ȷ��","ȷ�϶Ի���",	JOptionPane.YES_NO_CANCEL_OPTION); 
		   message = perdao.selectBNameById(dNamecomboBox.getSelectedItem().toString(),pNameComboBox.getSelectedItem().toString());
			pId = message.getId();
		   if(n == JOptionPane.YES_OPTION){ 			//����û�ȷ����Ϣ
			   perdao.deleteBasicMessage(pId);			//����ɾ�����ݷ���
			   pNameComboBox.removeAllItems();
			   repaint();
		   }
	}
});
		deleteButton.setBounds(362, 266, 62, 23);
		panel_1.add(deleteButton);		
			

	}
	public JPanel particularPsnel(){
		contactpanel = new JPanel();
		contactpanel.setBackground(new Color(210, 105, 30));
		contactpanel.setBounds(128, 53, 420, 208);		
		contactpanel.setLayout(null);
		
		JLabel phoneLabel = new JLabel("�ֻ���");
		phoneLabel.setBackground(new Color(210, 105, 30));
		phoneLabel.setBounds(25, 35, 54, 15);
		contactpanel.add(phoneLabel);
		
		pnoneTextField = new JTextField();
		pnoneTextField.setBackground(new Color(210, 105, 30));
		pnoneTextField.setBounds(60, 32, 133, 25);
		contactpanel.add(pnoneTextField);
		pnoneTextField.setColumns(10);
		
		JLabel officeLabel = new JLabel("�칫�绰��");
		officeLabel.setBackground(new Color(210, 105, 30));
		officeLabel.setBounds(204, 35, 69, 15);
		contactpanel.add(officeLabel);
		
		officeTextField = new JTextField();
		officeTextField.setBackground(new Color(210, 105, 30));
		officeTextField.setBounds(264, 32, 121, 25);
		contactpanel.add(officeTextField);
		officeTextField.setColumns(10);
		
		JLabel faxLabel = new JLabel("���棺");
		faxLabel.setBackground(new Color(210, 105, 30));
		faxLabel.setBounds(25, 82, 36, 15);
		contactpanel.add(faxLabel);
		
		faxTextField = new JTextField();
		faxTextField.setBackground(new Color(210, 105, 30));
		faxTextField.setBounds(61, 82, 133, 25);
		contactpanel.add(faxTextField);
		faxTextField.setColumns(10);
		
		JLabel emailLabel = new JLabel("���䣺");
		emailLabel.setBackground(new Color(210, 105, 30));
		emailLabel.setBounds(226, 82, 36, 25);
		contactpanel.add(emailLabel);
		
		emailtextField = new JTextField();
		emailtextField.setBackground(new Color(210, 105, 30));
		emailtextField.setColumns(10);
		emailtextField.setBounds(264, 82, 121, 25);
		contactpanel.add(emailtextField);
		
		JLabel addressLabel = new JLabel("��ͥסַ��");
		addressLabel.setBackground(new Color(210, 105, 30));
		addressLabel.setBounds(10, 145, 60, 15);
		contactpanel.add(addressLabel);
		
		addressTextField = new JTextField();
		addressTextField.setBackground(new Color(210, 105, 30));
		addressTextField.setColumns(10);
		addressTextField.setBounds(61, 140, 133, 25);
		contactpanel.add(addressTextField);
		contactpanel.setBorder(createTitledBorder(null, "��ϸ��Ϣ",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, new Font(
						"sansserif", Font.BOLD, 12), new Color(59, 59, 59)));
		return contactpanel;
	}
	public JPanel basicPanel(){		
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(210, 105, 30));
		JLabel nameLabel = new JLabel("������");
		nameLabel.setBackground(new Color(210, 105, 30));
		nameLabel.setBounds(25, 35, 54, 15);
		contentPanel.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBackground(new Color(210, 105, 30));
		nameTextField.setBounds(64, 32, 123, 25);
		contentPanel.add(nameTextField);
		nameTextField.setColumns(10);

		JLabel agelabel = new JLabel("���䣺");
		agelabel.setBackground(new Color(210, 105, 30));
		agelabel.setBounds(208, 35, 41, 15);
		contentPanel.add(agelabel);

		ageTextField = new JTextField();
		ageTextField.setBackground(new Color(210, 105, 30));
		ageTextField.setColumns(10);
		ageTextField.setBounds(250, 30, 123, 25);
		contentPanel.add(ageTextField);

		JLabel sexLabel = new JLabel("�Ա�");
		sexLabel.setBackground(new Color(210, 105, 30));
		sexLabel.setBounds(25, 82, 41, 15);
		contentPanel.add(sexLabel);

		manRadioButton = new JRadioButton("��");
		manRadioButton.setBackground(new Color(210, 105, 30));
		manRadioButton.setBounds(66, 78, 41, 23);
		contentPanel.add(manRadioButton);

		wradioButton = new JRadioButton("Ů");
		wradioButton.setBackground(new Color(210, 105, 30));
		wradioButton.setBounds(119, 78, 41, 23);
		contentPanel.add(wradioButton);
		ButtonGroup group = new ButtonGroup();
		group.add(manRadioButton);
		group.add(wradioButton);
		JLabel deptLabel = new JLabel("���ţ�");
		deptLabel.setBackground(new Color(210, 105, 30));
		deptLabel.setBounds(208, 82, 41, 15);
		contentPanel.add(deptLabel);

		deptField = new JTextField();
		deptField.setBackground(new Color(210, 105, 30));
		deptField.setBounds(250, 79, 123, 25);
		contentPanel.add(deptField);

		JLabel headshipLabel = new JLabel("ְ��");
		headshipLabel.setBackground(new Color(210, 105, 30));
		headshipLabel.setBounds(25, 123, 41, 15);
		contentPanel.add(headshipLabel);

		headshipField  = new JTextField();
		headshipField.setBackground(new Color(210, 105, 30));
		headshipField.setBounds(64, 120, 123, 25);
		contentPanel.add(headshipField);
		contentPanel.setBorder(createTitledBorder(null, "������Ϣ",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, new Font(
						"sansserif", Font.BOLD, 12), new Color(59, 59, 59)));
		return contentPanel;
	}	
}
