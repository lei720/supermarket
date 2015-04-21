package edu.cuit.jbutton;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import edu.cuit.DAOIMPL.StockDaoImpl;
import edu.cuit.bean.JoinDepot;
import edu.cuit.bean.Stock;
import edu.cuit.dao.DepotDao;
import edu.cuit.dao.JoinDepotDao;
import edu.cuit.dao.StockDao;
import edu.cuit.mainFrame.RemoveButtomFrame;
import edu.cuit.util.GetDate;

public class ButtionEditorNull extends DefaultCellEditor {
	  protected JButton button;
	  private String    label;
	  private boolean   isPushed;
	  private cuit.edu.DAO.StockDao dao=new StockDaoImpl();;
	  public ButtionEditorNull(JCheckBox checkBox) {
	    super(checkBox);
	    button = new JButton();
	    button.setOpaque(true);
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	 
	   	        
	   	    }
	      
	      
	    });
	  }

	  public Component getTableCellEditorComponent(JTable table, Object value,
	                   boolean isSelected, int row, int column) {
	    if (isSelected) {
	      button.setForeground(table.getSelectionForeground());
	      button.setBackground(table.getSelectionBackground());
	    } else{
	      button.setForeground(table.getForeground());
	      button.setBackground(table.getBackground());
	    }
	    label = (value ==null) ? "" : value.toString();
	    button.setText( label );
	    isPushed = true;
	    return button;
}
}
