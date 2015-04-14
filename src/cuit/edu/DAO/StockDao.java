package cuit.edu.DAO;

import java.util.List;

import cuit.edu.BEAN.Stock;

public interface StockDao {
	public void insertStock(Stock stock);
	public List selectStock();
	public int selectJoinStockByOid(String oid);
	public List selectStockBySName(String sName) ;
	public List selectStockByOid(String oId);
	public List selectStockByDate(String cDate);
	public Stock selectStockByid(int id);
	public void updateStock(Stock stock);
	public void deleteStock(int id);
	
	
}
