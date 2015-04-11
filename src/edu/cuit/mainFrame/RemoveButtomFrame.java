package edu.cuit.mainFrame;
import static javax.swing.BorderFactory.createTitledBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;




import com.sun.org.apache.bcel.internal.generic.NEW;

















import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import edu.cuit.bean.User;
import edu.cuit.model.OutDepotModel;

import edu.cuit.panel.DepotPanel;
import edu.cuit.panel.DeptPanel;
import edu.cuit.panel.FeelWarePanel;
import edu.cuit.panel.JoinDepotPanel;
import edu.cuit.panel.MyJPanel;
import edu.cuit.panel.OutDepotPanel;
import edu.cuit.panel.PersonnelPanel;
import edu.cuit.panel.SellPanel;
import edu.cuit.panel.StockPanel;
import edu.cuit.panel.TimerShow;
import edu.cuit.panel.WarePanel;
import edu.cuit.panel.myBackPanel;
import edu.cuit.widget.CalendarPanel;


import edu.cuit.widget.CalendarPop;
import edu.cuit.widget.DayPanel;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Rectangle;
import java.net.URL;
import java.util.Calendar;

import javax.swing.JTextPane;

import sun.awt.IconInfo;
public class RemoveButtomFrame extends JFrame {
	private MyJPanel contentPane;
	private JPanel backPanel;
	private JScrollPane moduleButtonGroup = null;
	private JTree tree;
	private JPanel panel;
	FeelWarePanel panelFeel = new FeelWarePanel();
	JPanel panel_1 = new JPanel();
	//JLabel fristLabel = new JLabel();
	private JPanel jPanel = null;
	private ButtonGroup buttonGroup = null;
	private JButton workSpaceButton = null;
	//private GlassButton progressButton = null;
	private JButton progressButton = null;
	private JTable table_1;
	private JButton bookProjectButton = null;
	private JButton chukuButton = null;
	private JButton personnelManagerButton = null;
	private JButton deptManagerButton = null;
	final OutDepotModel model = new OutDepotModel();
	private JTextPane textPane;
	private myBackPanel myBackPanel;
	//JLabel label_1 = new JLabel("����ǰ��λ���ǣ�");
	/**
	 * Create the frame.
	 */
	public RemoveButtomFrame() {
		setBackground(new Color(160, 82, 45));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 625);
		contentPane = new MyJPanel();
		contentPane.setBackground(new Color(160, 82, 45));
				//contentPane=(MyJPanel) new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(getModuleButtonGroup());
		setTitle("���й���ϵͳ");
		contentPane.setLayout(null);
		setResizable(false);
		JPanel clockpanel = new JPanel();
		clockpanel.setBackground(new Color(160, 82, 45));
	clockpanel.setBounds(23, 366, 178, 35);
		contentPane.add(clockpanel);
	//	clockpanel.setLayout(null);

	//	JPanel panel_1 = new JPanel();
	//	panel_1.setBounds(0, 210, 276, 1);
	//	clockpanel.add(panel_1);
	//	panel_1.setLayout(null);
//User user =	Session.getUser();					
/*String info = "<html><body>" + "<font color=#FFFFFF>�� �ã�</font>"
		+ "<font color=yellow><b>" + user.getUserName() + "</b></font>"
		+ "<font color=#FFFFFF>                �� ӭ �� ¼</font>"*/ //���崰����ʾ����
   clockpanel.add(getPanel());
//JLabel label = new JLabel(info);			//������ʾָ�����ݵı�ǩ����
//		label.setBackground(Color.yellow);
	//	label.setBounds(45, 210, 128, 35);
	//	clockpanel.add(label);
		CalendarPop panel_2=new CalendarPop();
	//	calendarPop.addDayClickListener(CalendarPopTest.this);
		//calendarPop.addDayCreateListener(CalendarPopTest.this);
		panel_2.updateDate(Calendar.getInstance());
		panel_2.setVisible(true);
	//	CalendarPanel panel_2 = new CalendarPanel();
		panel_2.setForeground(new Color(210, 105, 30));
		panel_2.setBackground(new Color(160, 82, 45));
		panel_2.setBounds(23, 149, 178, 207);
		contentPane.add(panel_2);
		myBackPanel backPanel=new myBackPanel();
		JButton jButton=new JButton();
		//ImageIcon imageIcon=new ImageIcon(getClass().getResource("/edu/cuit/frame/buttonIcons/sp.jpg"));
		//jButton.setIcon(imageIcon);
		//jButton.setBounds(11, 73, imageIcon.getIconWidth(), imageIcon.getIconHeight());
		//System.out.println(imageIcon.getIconWidth()+":"+imageIcon.getIconHeight());
	//	contentPane.add(jButton);
		//�����ô��⣿����
		contentPane.add(getContentPanel()); // �������������
		
		
	/*	JTextPane textPane = new JTextPane();
		textPane.setText("superMarket");
		textPane.setBackground(new Color(32, 178, 170));
		textPane.setBounds(10, 71, 258, 68);
		contentPane.add(textPane);*/
		//Container contentPane2= getContentPane();
	}

	private JPanel getContentPanel() {
		if (backPanel == null) {
			backPanel = new JPanel();
			backPanel.setBackground(new Color(160, 82, 45));
			backPanel.setSize(629, 416); // ������ʾ�������
			backPanel.setLocation(279, 149);
			backPanel.setLayout(null);

			//label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		//	label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		//	label_1.setBounds(38, 38, 96, 15);
			backPanel.setBorder(createTitledBorder(null, "������������",
							TitledBorder.DEFAULT_JUSTIFICATION,
							TitledBorder.TOP, new Font("sansserif", Font.BOLD,
									12), new Color(59, 59, 59)));
			// add new JLabel("����ǰ��λ���ǣ�");
		//	backPanel.add(label_1);
		//	fristLabel.setBounds(133, 38, 123, 15);
			//add  new JLabel("������������");
	//		backPanel.add(fristLabel);
			panel_1.setBounds(10, 63, 611, 343);
			panel_1.setLayout(null);
			backPanel.add(panel_1);
		//	JScrollPane scrollPane = new JScrollPane();
			//panel_1.add(scrollPane);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(new Rectangle(0, 0, 0, 343));
			scrollPane.setBackground(new Color(160, 82, 45));
			//scrollPane���������һ�����
			scrollPane.setBounds(0, 0, 138, 343);
			panel_1.add(scrollPane);
		/**/	DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
				 "��������");
			
			DefaultMutableTreeNode childNode1 = new DefaultMutableTreeNode(
					"������");
		/*	*/DefaultMutableTreeNode childNode2 = new DefaultMutableTreeNode(
					"������");
			DefaultMutableTreeNode childNode3 = new DefaultMutableTreeNode(
					"��Ʒ����");
		/*	JTree childtre=new JTree(childNode3);
			DefaultTreeCellRenderer renderer2 = (DefaultTreeCellRenderer) childtre
			        .getCellRenderer();
			URL url2 = getClass().getResource("/edu/cuit/frame/buttonIcons/ware.png");
			ImageIcon leafIcon2 = new ImageIcon(url2);
			renderer2.setOpenIcon(leafIcon2);
			renderer2.setClosedIcon(leafIcon2);*/
			DefaultMutableTreeNode childNode4 = new DefaultMutableTreeNode(
					"�ֿ����Ա");
		/*	IconNode rootNode=new IconNode(new ImageIcon("/edu/cuit/frame/buttonIcons/filedocument.png"),"��������");
			IconNode childNode1=new IconNode(new ImageIcon("/edu/cuit/frame/buttonIcons/filedocument.png"),"��������");
			IconNode childNode2=new IconNode(new ImageIcon("/edu/cuit/frame/buttonIcons/filedocument.png"),"��������");
			IconNode childNode3=new IconNode(new ImageIcon("/edu/cuit/frame/buttonIcons/filedocument.png"),"��������");
			*/
			rootNode.add(childNode1);
		/**/rootNode.add(childNode2);
			rootNode.add(childNode3);
			rootNode.add(childNode4);
			tree = new JTree(rootNode);
		/*	DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree
			        .getCellRenderer();
			URL url = getClass().getResource("/edu/cuit/frame/buttonIcons/provider.png");
			ImageIcon leafIcon = new ImageIcon(url);
			renderer.setLeafIcon(leafIcon);*/
		tree.setCellRenderer(new TreeRenderer());
			//DefaultMutableTreeNode dTreeNode=new DefaultMutableTreeNode(rootNode);
	/*		tree = new JTree(rootNode);
			TreeCellRenderer renderer = new IconCellRenderer();
			tree.setCellRenderer(renderer);
			tree.putClientProperty("JTree.lineStyle", "Angled");
			tree.setShowsRootHandles(true);
			tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);*/
		/*	tree.putClientProperty("JTree.lineStyle", "Angled");
			TreeCellRenderer renderer = new IconCellRenderer();
			tree.setCellRenderer(renderer);
			///tree.addTreeExpansionListener(new DirExpansionListener());
		//	tree.addTreeSelectionListener(new DirSelectionListener());
			tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			tree.setShowsRootHandles(true);
			tree.setEditable(false);*/
			tree.setBounds(new Rectangle(0, 0, 0, 343));
			tree.setBackground(new Color(160, 82, 45));
			
			scrollPane.setColumnHeaderView(tree);
		scrollPane.setBackground(new Color(71,201,223));
			final JPanel sellPanel = new JPanel();
			
			table_1 = new JTable(model);
			
			table_1.setBounds(new Rectangle(10, 129, 611, 174));
		
			table_1.setBackground(new Color(210, 105, 30));
			//sellPanel.setIgnoreRepaint(true);
			sellPanel.setForeground(new Color(210, 105, 30));
			//how to set te sellpanel's backimage?
			sellPanel.setBackground(new Color(160, 82, 45));
			sellPanel.setBounds(138, 0, 473, 343);
			sellPanel.setLayout(null);
			panel_1.add(sellPanel);
			panel_1.setBackground(new Color(160, 82, 45));
			//���ʹ��java tree ���󷽷�
			
			tree.getSelectionModel().setSelectionMode(
					TreeSelectionModel.SINGLE_TREE_SELECTION);
			TreeSelectionModel treeSelectionModel = tree.getSelectionModel();
			treeSelectionModel
					.setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
			tree.addTreeSelectionListener(new TreeSelectionListener() {
				@Override
				public void valueChanged(TreeSelectionEvent e) {
					if (!tree.isSelectionEmpty()) {
						TreePath selectionPaths = tree.getSelectionPath();
						Object path = selectionPaths.getLastPathComponent();
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) path;
						String userObject = (String) node.getUserObject();
						repaint();
						if (userObject.equals("������")) {
						//	fristLabel.setText("�����̹���");
							sellPanel.removeAll();
							panelFeel.setBackground(new Color(210, 105, 30));
							sellPanel.add(panelFeel.getMessage());

						} else if (userObject.equals("������")) {
						//	fristLabel.setText("�����̹���");
							sellPanel.removeAll();
							SellPanel sell = new SellPanel();
							sellPanel.add(sell.getMessage());
							repaint();
						} else if (userObject.equals("��Ʒ����")) {
						//	fristLabel.setText("��Ʒ��������");
							sellPanel.removeAll();
							WarePanel warePanel = new WarePanel();
							sellPanel.add(warePanel.getMessage());
							repaint();
						} else if (userObject.equals("�ֿ����Ա")) {
						//	fristLabel.setText("�ֿ����");
							sellPanel.removeAll();
							DepotPanel depotPanel = new DepotPanel();
							sellPanel.add(depotPanel.getMessage());
							repaint();
						}
					}
				}
			});

		}
		return backPanel;
	}

	private JScrollPane getModuleButtonGroup() {
		if (moduleButtonGroup == null) {
			moduleButtonGroup = new JScrollPane();// �������
		//�޸İ�����峤�Ϳ�
			moduleButtonGroup.setBounds(308, 71, 600, 68);
			moduleButtonGroup.setBackground(new Color(160, 82, 45));
			moduleButtonGroup.setOpaque(false);
			// ����ť�������Ϊ�ƶ�������ͼ
			moduleButtonGroup.setViewportView(getJPanel());
		/*	moduleButtonGroup.getAlphaScrollPanel()
					.setViewportView(getJPanel());*/
			// �������¼�������
		}
		return moduleButtonGroup;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new TimerShow();
			//panel.setBounds(null);
			panel.setBackground(new Color(160, 82, 45));
		}
		return panel;
	}
	/*public void IconData(Icon icon, Icon expandedIcon, Object data)

	{
		m_icon = icon;
		m_expandedIcon = expandedIcon;
		m_data = data;
	}*/
public JPanel getJPanel() {
	if (jPanel == null) {
		GridLayout gridLayout = new GridLayout();	//�������񲼾ֹ�����
		gridLayout.setRows(1);						//�������񲼾ֹ�����������
		gridLayout.setHgap(0);						//���������ˮƽ���
		gridLayout.setVgap(0);						//��������䴹ֱ���
		jPanel = new JPanel();						//
		jPanel.setBackground(new Color(160, 82, 45));
		// ���ò��ֹ�����
		jPanel.setLayout(gridLayout);
		// ���ó�ʼ��С
		jPanel.setPreferredSize(new Dimension(500, 30));
		jPanel.setOpaque(false);
		// ��Ӱ�ť
		jPanel.add(getWorkSpaceButton(), null);
		jPanel.add(getProgressButton(), null);
		jPanel.add(getrukuButton(), null);
		jPanel.add(getchukuButton(), null);
		jPanel.add(getPersonnelManagerButton(), null);
		jPanel.add(getDeptManagerButton(), null);
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		// �����а�ť��ӵ�һ����ؼ���
		buttonGroup.add(getProgressButton());
		buttonGroup.add(getWorkSpaceButton());
		buttonGroup.add(getrukuButton());
		buttonGroup.add(getchukuButton());
		buttonGroup.add(getPersonnelManagerButton());
		buttonGroup.add(getDeptManagerButton());
	}
	return jPanel;
}

	// ������������ť
private JButton getWorkSpaceButton() {
	if (workSpaceButton == null) {
		workSpaceButton = new JButton();
		workSpaceButton.setBackground(new Color(160, 82, 45));
		workSpaceButton.setActionCommand("������������");		//���ð�ť�Ķ�������
//		workSpaceButton.setIcon(new ImageIcon(getClass().getResource(
//				"/edu/cuit/frame/buttonIcons/myWorkSpace.png")));	//���尴ť�ĳ�ʼ������
//		ImageIcon icon = new ImageIcon(getClass().getResource(
//				"/edu/cuit/frame/buttonIcons/myWorkSpace2.png"));	//����ͼƬ����
//		workSpaceButton.setRolloverIcon(icon);		//���ð�ť�ķ�תͼƬ
//		workSpaceButton.setSelectedIcon(icon);		//���ð�ť��ѡ��ʱ��ʾͼƬ
//		workSpaceButton.setSelected(true);			
		workSpaceButton.setText("��������");
		//workSpaceButton.setBounds(arg0, arg1, arg2, arg3);
		workSpaceButton.addActionListener(new toolsButtonActionAdapter());	//��ť�ļ�����
	} 
	return workSpaceButton;
}

	// �ɹ���������ť
	private JButton getProgressButton() {
		if (progressButton == null) {
			progressButton = new JButton();
			progressButton.setBackground(new Color(160, 82, 45));
			progressButton.setActionCommand("�ɹ�����");
		//	progressButton.setText("�ɹ�����");
			//progressButton.setTe
	//		progressButton.setIcon(new ImageIcon(getClass().getResource(
		//			"/edu/cuit/frame/buttonIcons/caigou1.png")));
		//	ImageIcon icon = new ImageIcon(getClass().getResource(
			//		"/edu/cuit/frame/buttonIcons/caigou2.png"));
		//	progressButton.setRolloverIcon(icon);
		//	progressButton.setSelectedIcon(icon);
			progressButton.setText("��������");
			progressButton.addActionListener(new toolsButtonActionAdapter());
		}
		return progressButton;
	}

	// �ֿ����
	private JButton getrukuButton() {
		if (bookProjectButton == null) {
			bookProjectButton = new JButton();
			bookProjectButton.setBackground(new Color(160, 82, 45));
			bookProjectButton.setActionCommand("�ֿ����");
			// bookProjectButton.setText("ͼ��ƻ�");
	//		ImageIcon icon = new ImageIcon(getClass().getResource(
	//				"/edu/cuit/frame/buttonIcons/ruku2.png"));
//			bookProjectButton.setSelectedIcon(icon);
		//	bookProjectButton.setRolloverIcon(icon);
			//bookProjectButton.setIcon(new ImageIcon(getClass().getResource(
				//	"/edu/cuit/frame/buttonIcons/ruku1.png")));
			bookProjectButton.setText("�ֿ����");
			bookProjectButton.addActionListener(new toolsButtonActionAdapter());
		}
		return bookProjectButton;
	}

	// �ֿ�������
	private JButton getchukuButton() {
		if (chukuButton == null) {
			chukuButton = new JButton();
			chukuButton.setBackground(new Color(160, 82, 45));
		//	MutableAttributeSet attr = new SimpleAttributeSet(); 
			chukuButton.setActionCommand("�ֿ����");
			chukuButton.setSize(500, 500);
			chukuButton.setText("�ֿ����");
			chukuButton.setHorizontalAlignment(SwingConstants.LEFT);
	//		ImageIcon icon = new ImageIcon(getClass().getResource(
		//			"/edu/cuit/frame/buttonIcons/chuku1.png"));
//			chukuButton.setSelectedIcon(icon);
//			chukuButton.setRolloverIcon(icon);
//			chukuButton.setIcon(new ImageIcon(getClass().getResource(
//					"/edu/cuit/frame/buttonIcons/chuku2.png")));
			chukuButton.addActionListener(new toolsButtonActionAdapter());
		}
		return chukuButton;
	}

	// ��Ա����ϵͳ
	private JButton getPersonnelManagerButton() {
		if (personnelManagerButton == null) {
			personnelManagerButton = new JButton();
			personnelManagerButton.setBackground(new Color(160, 82, 45));
			// personnelManagerButton.setText("��Ա����");
			personnelManagerButton.setActionCommand("��ѯ��ͳ��ϵͳ");
			// personnelManagerButton.setCursor(new
			 //Cursor(Cursor.DEFAULT_CURSOR));
//			ImageIcon imageIcon = new ImageIcon(getClass().getResource(
//					"/edu/cuit/frame/buttonIcons/person2.png"));
//			personnelManagerButton.setIcon(imageIcon);
//			ImageIcon icon = new ImageIcon(getClass().getResource(
//					"/edu/cuit/frame/buttonIcons/person1.png"));
//			personnelManagerButton.setRolloverIcon(icon);
//			personnelManagerButton.setSelectedIcon(icon);
			personnelManagerButton.setText("��Ա����");
			personnelManagerButton.setFocusPainted(false);
			personnelManagerButton
					.addActionListener(new toolsButtonActionAdapter());
		}
		return personnelManagerButton;
	}

	// ���Ź���ϵͳ
	private JButton getDeptManagerButton() {
		if (deptManagerButton == null) {
			deptManagerButton = new JButton();
			deptManagerButton.setBackground(new Color(160, 82, 45));

			deptManagerButton.setActionCommand("��ѯ��ͳ��ϵͳ");
			// personnelManagerButton.setCursor(new
			// Cursor(Cursor.DEFAULT_CURSOR));
//			ImageIcon imageIcon = new ImageIcon(getClass().getResource(
//					"/edu/cuit/frame/buttonIcons/deptButton.png"));
//			deptManagerButton.setIcon(imageIcon);
//			ImageIcon icon = new ImageIcon(getClass().getResource(
//					"/edu/cuit/frame/buttonIcons/deptButton2.png"));
//			deptManagerButton.setRolloverIcon(icon);
//			deptManagerButton.setSelectedIcon(icon);
			deptManagerButton.setText("���Ź���");
			deptManagerButton.setFocusPainted(false);
			deptManagerButton.addActionListener(new toolsButtonActionAdapter());
		}
		return deptManagerButton;
	}

	class toolsButtonActionAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == workSpaceButton) {
				backPanel.removeAll();
				backPanel.setBackground(new Color(160, 82, 45));

			//	backPanel.add(label_1);
			//	fristLabel.setBounds(133, 38, 123, 15);
		//		backPanel.add(fristLabel);
				panel_1.setBounds(10, 63, 611, 376);
				backPanel.add(panel_1);
				//fristLabel.setText("������������");
				repaint();
			}
			if (e.getSource() == progressButton) {
				backPanel.removeAll();
		//		backPanel.add(label_1);
			//	fristLabel.setBounds(133, 38, 123, 15);
			//	backPanel.add(fristLabel);
				backPanel.setBackground(new Color(160, 82, 45));

				panel_1.setBounds(10, 63, 611, 386);
				StockPanel stockPanl = new StockPanel();
			//	fristLabel.setText("�ɹ�����");
				backPanel.add(stockPanl);
				repaint();
			}
			if (e.getSource() == bookProjectButton) {
				backPanel.removeAll();
				backPanel.setBackground(new Color(71,201,223));

			//	backPanel.add(label_1);
				//fristLabel.setBounds(133, 38, 123, 15);
			//	backPanel.add(fristLabel);
				panel_1.setBounds(10, 63, 611, 386);
				JoinDepotPanel joinPanel = new JoinDepotPanel();
				backPanel.add(joinPanel);
			//	fristLabel.setText("�ֿ����");
				repaint();
			}
			if (e.getSource() == chukuButton) {
				backPanel.removeAll();
				backPanel.setBackground(new Color(71,201,223));

			//	backPanel.add(label_1);
			//	fristLabel.setBounds(133, 38, 123, 15);
			//	backPanel.add(fristLabel);
				panel_1.setBounds(10, 63, 611, 386);
				OutDepotPanel outPanel = new OutDepotPanel();
				backPanel.add(outPanel);
				//fristLabel.setText("�ֿ����");
				repaint();
			}
			if (e.getSource() == deptManagerButton) {
				backPanel.removeAll();
			//	backPanel.add(label_1);
				backPanel.setBackground(new Color(71,201,223));

			//	fristLabel.setBounds(133, 38, 123, 15);
			//	backPanel.add(fristLabel);
				panel_1.setBounds(10, 63, 611, 386);
				DeptPanel outPanel = new DeptPanel();
				backPanel.add(outPanel);
			//	fristLabel.setText("���Ź���");
				repaint();
			}
			if (e.getSource() == personnelManagerButton) {
				backPanel.removeAll();			
				panel_1.setBounds(10, 63, 611, 386);
				backPanel.setBackground(new Color(71,201,223));

				PersonnelPanel panel = new PersonnelPanel();
				backPanel.add(panel);				
				repaint();
			}
		}

	}
	private myBackPanel getTextPane() {
		if (myBackPanel == null) {
			myBackPanel = new myBackPanel();
			myBackPanel.setBounds(11, 73, 255, 64);
		}
		return myBackPanel;
	}


}