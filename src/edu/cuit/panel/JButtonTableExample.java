package edu.cuit.panel;
import javax.swing.*;
import javax.swing.table.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import edu.cuit.DAOIMPL.StockDaoImpl;
import edu.cuit.bean.Stock;
import edu.cuit.dao.StockDao;
import edu.cuit.jbutton.ButtonEditor;
import edu.cuit.jbutton.ButtonRenderer;
public class JButtonTableExample extends JPanel {
	  public JButtonTableExample(){	    
	    DefaultTableModel dm = new DefaultTableModel();
	
	    dm.setDataVector(new Object[][]{{"","","","","","","",""}},
                     new Object[]{"�Ƿ����","���","��Ʒ����","������","��������","������","���","����"});	                     
	    dm.removeRow(0);
	    JTable table = new JTable(dm);
	    cuit.edu.DAO.StockDao dao=new StockDaoImpl();
	    List list = dao.selectStock();
	    for(int i = 0;i<list.size();i++){
	    	Stock stock = (Stock)list.get(i);
	    	String oid = stock.getOrderId();
	    	int id = dao.selectJoinStockByOid(oid);	    	
	    	if(id <=0){
	    		 dm.addRow(new Object[]{"���",stock.getId(),stock.getsName(),stock.getOrderId(),stock.getConsignmentDate(),stock.getBaleName(),
	    				 stock.getMoney(),stock.getCount()});
	    		  File file = new File("files.txt");	    		  
	    		 try {	    				
	    				FileOutputStream out = new FileOutputStream(file);
	    				out.write(stock.getId());
	    				out.close();	    			
	    				repaint();			    				
	    			} catch (Exception ee) {
	    				ee.printStackTrace();
	    			}
	    	}
	    	else{
	    		 dm.addRow(new Object[]{"�Ѿ����",stock.getId(),stock.getsName(),stock.getOrderId(),stock.getConsignmentDate(),stock.getBaleName(),
	    				 stock.getMoney(),stock.getCount()});
	    	}
	    }	   
	    if (list.size()<=15) {
	    	dm.setRowCount(15);
		} else {

		}
	    JScrollPane scroll = new JScrollPane(table);	
	    table.getColumn("�Ƿ����").setCellRenderer(new ButtonRenderer());
	    table.getColumn("�Ƿ����").setCellEditor(new ButtonEditor(new JCheckBox()));
	    this.add(scroll);
	    this.setSize( 583, 230);
	    int row = table.getSelectedRow();  			   
		if (row < 0) {			
			return;
		} else {
			File file = new File("filedd.txt");
			
			try {
				String column = dm.getValueAt(row, 0).toString();	
				System.out.println("COLUMN��"+column);
				file.createNewFile();
				FileOutputStream out = new FileOutputStream(file);
				out.write((Integer.parseInt(column)));
				out.close();					
				repaint();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	    setVisible(true);
	  
	  }
	}
