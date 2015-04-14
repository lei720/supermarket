package cuit.edu.DAO;

import java.util.List;

import cuit.edu.BEAN.Provide;

public interface FeelDao {
	public void deleteProvide(int id);
	public void insertProvide(Provide provide) ;
	public List selectProvide() ;
	public List selectProvideByAddress(String address);
	public Provide selectProvideByid(int id);
	public List selectProvideByName(String name);
	public List selectProvideByNameAddress(String address, String name) ;
	public void updateProvide(Provide provide);
	
}
