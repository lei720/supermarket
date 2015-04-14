package cuit.edu.DAO;

import java.util.List;

import cuit.edu.BEAN.Ware;;

public interface WareDao {
	public void insertWare(Ware ware);
	public List selectWare();
	public Ware selectWareByid(int id);
	public List selectWareByName(String name) ;
	public void updateWare(Ware ware);
	public void deleteWare(int id);
	
	
}
