package edu.cuit.widget;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.Rectangle;

/**
 *@author �ο� email:wqjsir@foxmail.com
 *@version ����ʱ�䣺2010-12-6 ����05:21:44
 * @��������
 * ����ⲿ������ʾ�ĵ���public void updateDate(Calendar calendar)������
 * ���ʼ����������彫���õ�ǰ����������������ʾ����岻��ַ����ڶ��󴴽��¼�DayCompCreateListener��
 * ���Ҫ���״���ʾ�������ʱ�ַܷ�DayCompCreateListener�¼�����Ҫ���ⲿ��������Ӽ���֮������ʾ�ĵ���updateDate��Calendar calendar��������
 */
public class CalendarPop extends JPanel{
	//����壬���������Ĳ�����ť��塢�м��������塢�ײ�����Ϣ���
	private JPanel mainPanel;
	//������ť�Ķ������
	private ActionPanel actionPanel;
	// �������
	private JPanel calendarPanel; 
	//�ײ���Ϣ���
	private JPanel bottomPanel;
	//��ӵ��ײ����ı�ǩ�����������ֵײ�������Ϣ
	private JLabel bottomInfo;
	//�����������񲼾ֶ���
	private GridLayout gridLayout;
	//�򵥵����ڸ�ʽ�����û��ײ���ʾ������Ϣ
	private static SimpleDateFormat sipleDF = new SimpleDateFormat("EEE,yyyy-MM-dd");
	//�򵥵����ڸ�ʽ�����û�������ʾ��ǰ����������
	static  final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
	
	private List<DayClickListener> listeners = new ArrayList<DayClickListener>();
	private List<DayCompCreateListener> createListeners = new ArrayList<DayCompCreateListener>();
	private List<ActionButtonListener> actionListeners = new ArrayList<ActionButtonListener>();
	private DayPanel day_1;
	private DayPanel day_2;
	public CalendarPop() {
		setBounds(new Rectangle(71, 149, 171, 210));
		gridLayout = new GridLayout(0, 7, 3, 3);
		//setPreferredSize(new Dimension(170,210));
		calendarPanel = new JPanel(gridLayout);
	//	calendarPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		calendarPanel.setOpaque(false);
		calendarPanel.setBackground(new Color(210, 180, 140));
		bottomInfo = new JLabel("",JLabel.CENTER);
		bottomInfo.setBackground(new Color(210, 180, 140));
		//bottomInfo.setFont(new Font(Font.SERIF,Font.PLAIN,15));
		bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setPreferredSize(new Dimension(80,25));
		bottomPanel.setMinimumSize(new Dimension(100,30));
		bottomPanel.setMaximumSize(new Dimension(100,30));
		//set the bottom line
		bottomInfo.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
		bottomPanel.add(bottomInfo,BorderLayout.CENTER);
		bottomPanel.setOpaque(false);
		
		actionPanel = new ActionPanel();
		JPanel centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(new Color(210, 180, 140));
		centerPanel.setOpaque(false);
		centerPanel.add(buildWeekDayPanel(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(0, 2, 0, 0), 0, 0));
		centerPanel.add(calendarPanel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(0, 2, 0, 0), 0, 0));
		JLabel label = new JLabel();
		label.setBackground(new Color(210, 180, 140));
		centerPanel.add(label, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		centerPanel.setPreferredSize(new Dimension(160,160));
		centerPanel.setMinimumSize(new Dimension(160,160));
		centerPanel.setMaximumSize(new Dimension(160,160));
		mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(new Color(160, 82, 45));
		mainPanel.setBounds(71, 149, 171, 210);
		mainPanel.add(actionPanel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		mainPanel.add(centerPanel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		mainPanel.add(bottomPanel, new GridBagConstraints(0, 2, 1, 1,1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		//��ʼ�����õ�ǰ����
		Calendar initCalendar =Calendar.getInstance();
		buildCalendarPanel(initCalendar.get(Calendar.YEAR), initCalendar.get(Calendar.MONTH));
		
		setLayout(new GridBagLayout());
		add(mainPanel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
	}

	/**
	 * �������ڱ�ʶ��ǩ
	 * @return
	 */
	private JPanel buildWeekDayPanel() {
		JPanel weekDayPanel;
		weekDayPanel = new JPanel(new GridLayout(1, 7, 3, 3));
		weekDayPanel.setBackground(new Color(210, 180, 140));
		weekDayPanel.setOpaque(false);
		weekDayPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		
		DayPanel day = null;
		day_1 = new DayPanel("��");
		day_1.getLabel().setBackground(new Color(255, 127, 80));
		day_1.setBackground(new Color(255, 127, 80));
	//	day_1.getLabel().setBackground(new Color(210, 180, 140));
		//day_1.setForeground(Color.green);
		weekDayPanel.add(day_1);
		DayPanel dayPanel = new DayPanel("һ");
		//dayPanel.setBackground(new Color(210, 180, 140));
		dayPanel.getLabel().setBackground(new Color(210, 180, 140));
		weekDayPanel.add(dayPanel);
		DayPanel dayPanel_1 = new DayPanel("��");
		//dayPanel_1.setBackground(new Color(210, 180, 140));
		weekDayPanel.add(dayPanel_1);
		DayPanel dayPanel_2 = new DayPanel("��");
		//dayPanel_2.setBackground(new Color(210, 180, 140));
		dayPanel_2.getLabel().setBackground(new Color(210, 180, 140));
		weekDayPanel.add(dayPanel_2);
		DayPanel dayPanel_3 = new DayPanel("��");
		//dayPanel_3.setBackground(new Color(210, 180, 140));
		dayPanel_3.getLabel().setBackground(new Color(210, 180, 140));
		weekDayPanel.add(dayPanel_3);
		DayPanel dayPanel_4 = new DayPanel("��");
		//dayPanel_4.setBackground(new Color(210, 180, 140));
		dayPanel_4.getLabel().setBackground(new Color(210, 180, 140));
		weekDayPanel.add(dayPanel_4);
		day_2 = new DayPanel("��");
		day_2.getLabel().setBackground(new Color(255, 127, 80));
		day_2.setBackground(new Color(255, 127, 80));
	//	day_2.getLabel().setBackground(new Color(210, 180, 140));
		day_2.setForeground(Color.blue);
		weekDayPanel.add(day_2);
		return weekDayPanel;
	}

	/**
	 * ���������ؼ�
	 */
	//set the new calenda according to the new month
	private void buildCalendarPanel(int year, int month) {
		calendarPanel.removeAll();
		// ���õ�ǰ��������
		Calendar calender = Calendar.getInstance();
		calender.set(Calendar.YEAR, year);
		calender.set(Calendar.MONTH, month);
		calender.set(Calendar.DATE, 1);//����ʱ��Ϊ��ǰ�µĵ�һ��
		//����ǰ�µĵ�һ��֮ǰ�������ÿհ׵�DayPanel���
		int weekDay = calender.get(Calendar.DAY_OF_WEEK);
		for (int i = Calendar.SUNDAY; i < weekDay; i++) {
			calendarPanel.add(new DayPanel(""));
		}
		
		
		int i = 1;
		do {
			//����������һ��DayPanel����
			final DayPanel day = new DayPanel(calender);
			//���Ϊ��ǰ�����ڣ�����ʾһ���߿�
			if (Calendar.getInstance().get(Calendar.YEAR)==calender.get(Calendar.YEAR)&&
					Calendar.getInstance().get(Calendar.MONTH) == calender.get(Calendar.MONTH)&&
							Calendar.getInstance().get(Calendar.DAY_OF_MONTH)==calender.get(Calendar.DAY_OF_MONTH)) {
				day.setCurrentDay(true);
				//day.setBackground(new Color(210, 105, 30));
				//day.setForeground(Color.BLUE);
			}
		//	day.setBackground(new Color(210, 105, 30));
			day.setActionMoseEvent(true);
			day.getLabel().addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e){
					fireDayClicked(day,e);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					updateBottomInfo(sipleDF.format(day.getCalendar().getTime()));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					updateBottomInfo("");
				}
			});
			fireDayCreated(day);
			calendarPanel.add(day);
			
			//��������һ��������һ���day���󴴽�
			calender.add(Calendar.DAY_OF_MONTH, 1);
			i++;
		} while (calender.get(Calendar.MONTH) == month);
		for ( ;i<34; i++) {
			calendarPanel.add(new DayPanel(""));
		}
	}

	/**
	 * ���µײ������Ϣ
	 * @param text
	 */
	public void updateBottomInfo(String text){
		//bottomInfo.setFont(Font.getFont("yellow"));
		bottomInfo.setForeground(Color.BLACK);
		bottomInfo.setText(text);
		
	}
	
	/**
	 *��ָ�������ڶ����������������
	 * @param calendar
	 */
	public void updateDate(Calendar calendar) {
		String date = dateFormat.format(calendar.getTime());
		actionPanel.setDateInfo(date);
		buildCalendarPanel(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
	}

	/**
	 * ������ڵ������
	 * @param listener
	 */
	public void addDayClickListener(DayClickListener listener){
		listeners.add(listener);
	}
	
	/**
	 * �Ƴ����ڵ������
	 * @param listener
	 */
	public void removeDayClickListener(DayClickListener listener){
		listeners.remove(listener);
	}
	
	/**
	 * �������ڵ����¼�
	 * @param day
	 * @param e
	 */
	private void fireDayClicked(DayPanel day,MouseEvent e){
		for(DayClickListener listener:listeners){
			listener.dayClicked(day, e);
		}
	}
	
	/**
	 * ������ڴ���������
	 * @param createListener
	 */
	public void addDayCreateListener(DayCompCreateListener createListener){
         createListeners.add(createListener);
	}
	
	/**
	 * ɾ�����ڴ���������
	 * @param createListener
	 */
	public void removeCreateListener(DayCompCreateListener createListener){
		createListeners.remove(createListener);
	}
	
	/*
	 * �������ڴ����¼�
	 */
	private void fireDayCreated(DayPanel day){
		for(DayCompCreateListener listener:createListeners){
			listener.dayCompCreated(day);
		}
	}
	
	/**
	 * ��Ӷ�����ť������
	 * @param listener
	 */
	public void addActionButtonListener(ActionButtonListener listener){
		actionListeners.add(listener);		
	}
	
	/**
	 * �Ƴ�������ť������
	 * @param listener
	 */
	public void removeActionButtonListener(ActionButtonListener listener){
		actionListeners.remove(listener);
	}
	
	/**
	 * ����������ť�����¼�
	 * @param button
	 * @param e
	 */
	private void fireActionButtonActionPerfored(JButton button,ActionEvent e){
		for(ActionButtonListener listener:actionListeners){
			listener.actionButtonactionPerformed(button, e);
		}
	}
	class ActionPanel extends JPanel implements ActionListener{
		//������ʾ���ڵı�ǩ����
		private JLabel dateInfoLabel;
		//�����һ��İ�ť
		private JButton beforeYear;
		//�����һ���µİ�ť
		private JButton beforeMouth;
		//����һ���°�ť
		private JButton nextMouth;
		//����һ�갴ť
		private JButton nextYear;

		public ActionPanel(){
			setOpaque(false);
			beforeYear = new BasicArrowButton(SwingConstants.WEST){
				public void paintTriangle(Graphics g, int x, int y, int size, int direction, boolean isEnabled){
					super.paintTriangle(g, x, y, size, direction, isEnabled);
					super.paintTriangle(g, x-3, y, size, direction, isEnabled);
				} 
				 
			};
		    beforeYear.setBackground(new Color(255, 127, 80));
			beforeMouth = new BasicArrowButton(SwingConstants.WEST);
			beforeMouth.setBackground(new Color(255, 127, 80));
			nextMouth = new BasicArrowButton(SwingConstants.EAST);
			nextMouth.setBackground(new Color(255, 127, 80));
			nextYear = new BasicArrowButton(SwingConstants.EAST){
				public void paintTriangle(Graphics g, int x, int y, int size, int direction, boolean isEnabled){
					super.paintTriangle(g, x, y, size, direction, isEnabled);
					super.paintTriangle(g, x+3, y, size, direction, isEnabled);
				} 
				 
			};
			nextYear.setBackground(new Color(255, 127, 80));
			//��ʼ�������õ�ǰ����
			dateInfoLabel = new JLabel(dateFormat.format(Calendar.getInstance().getTime()));

			beforeYear.addActionListener(this);
			beforeMouth.addActionListener(this);
			nextMouth.addActionListener(this);
			nextYear.addActionListener(this);

			add(beforeYear, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(0, 8, 0, 0), 0, 0));
			add(beforeMouth, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			add(dateInfoLabel, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(0,5, 0, 5), 0, 0));
			add(nextMouth, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			add(nextYear, new GridBagConstraints(4, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(0, 0, 0,8), 0, 0));
		}
		
		/**
		 * ��õ�ǰ��ǩ����ʾ����������
		 * @return
		 */
		public Calendar getDate() {
			Calendar calendar = Calendar.getInstance();
			String date = dateInfoLabel.getText();
			String[] fields = date.split("-");
			calendar.set(Calendar.YEAR, Integer.parseInt(fields[0]));
			calendar.set(Calendar.MONTH, Integer.parseInt(fields[1]) - 1);
			return calendar;
		}
		
		/**
		 * ���ö�����������Ϣ
		 * @param text
		 */
		public void setDateInfo(String text) {
			this.dateInfoLabel.setText(text);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == beforeYear) {
				Calendar calendar = getDate();
				calendar.add(Calendar.YEAR, -1);
				fireActionButtonActionPerfored(beforeYear,e);
				updateDate(calendar);
			} else if (e.getSource() == beforeMouth) {
				Calendar calendar = getDate();
				calendar.add(Calendar.MONTH, -1);
				fireActionButtonActionPerfored(beforeMouth,e);
				updateDate(calendar);
			} else if (e.getSource() == nextMouth) {
				Calendar calendar = getDate();
				calendar.add(Calendar.MONTH, 1);
				fireActionButtonActionPerfored(nextMouth,e);
				updateDate(calendar);
			} else if (e.getSource() == nextYear) {
				Calendar calendar = getDate();
				calendar.add(Calendar.YEAR, 1);
				fireActionButtonActionPerfored(nextYear,e);
				updateDate(calendar);
			}

		}
		
	}
	
	
}
