package cuit.edu.DAO;

import java.util.List;

import cuit.edu.BEAN.Sell;

public interface SellDao {
	public void insertSell(Sell sell);
	public List selectSell();
	public Sell selectProvideByid(int id);
	public List selectsellByAddress(String address);
	public List selectsellByName(String name) ;
	public List selectSellByNameAddress(String address, String name);
	public void updateSell(Sell sell);
	public void deleteSell(int id);
	
}
