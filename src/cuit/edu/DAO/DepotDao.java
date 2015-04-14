package cuit.edu.DAO;

import java.util.List;

import cuit.edu.BEAN.Depot;

public interface DepotDao {
	public void deleteDepot(int id);
	public void insertDepot(Depot depot);
	public List selectDepot();
	// ��д����Ų�ѯ�ֿ���Ϣ����
	public Depot selectDepotByid(int id) ;
	// ���尴�ֿ��Ų�ѯ�ֿ���Ϣ����
	public Depot selectDepotById(int id);
	public List selectDepotByManage(String manage) ;
	public List selectDepotByManageAndId(int id,String manage);
	public void updateDepot(Depot depot);
	
}
