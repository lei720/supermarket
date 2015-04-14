package cuit.edu.DAO;

import java.util.List;

import cuit.edu.BEAN.BasicMessage;
import cuit.edu.BEAN.Contact;
import cuit.edu.BEAN.Dept;

public interface PersonalDao {
	public void insertBasicMessage(BasicMessage message);
	public void insertContact(Contact contact) ;
	public List selectHeadship() ;
	public int selectIdByHeadship(String hName);
	public List selectBasicMessageByDept(int dept);
	public Dept selectDepotById(int id);
	public String selectHeadshipById(int id) ;
	public BasicMessage selectBNameById(String dept,String name) ;
	public Contact selectContactById(int hid);
	public BasicMessage selectMessageById(int hid);
	public void updatertMessage(BasicMessage message);
	public void updatertContact(Contact contact) ;
	public void deleteBasicMessage(int id);
	
}
