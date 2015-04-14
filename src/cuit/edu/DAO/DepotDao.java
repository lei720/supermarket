package cuit.edu.DAO;

import java.util.List;

import cuit.edu.BEAN.Depot;

public interface DepotDao {
	public void deleteDepot(int id);
	public void insertDepot(Depot depot);
	public List selectDepot();
	// 编写按编号查询仓库信息方法
	public Depot selectDepotByid(int id) ;
	// 定义按仓库编号查询仓库信息方法
	public Depot selectDepotById(int id);
	public List selectDepotByManage(String manage) ;
	public List selectDepotByManageAndId(int id,String manage);
	public void updateDepot(Depot depot);
	
}
