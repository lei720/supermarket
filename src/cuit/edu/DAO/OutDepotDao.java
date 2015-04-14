package cuit.edu.DAO;

import java.util.List;

import cuit.edu.BEAN.OutDepot;

public interface OutDepotDao {
	public void deleteOutDepot(int id);
	public void insertOutDepot(OutDepot depot) ;
	public float selectJoinDepotAndDate(String wName,int did);
	public List selectOutDepot() ;
	public List selectOutDepotByDid(int did);
	public OutDepot selectOutDepotByid(int id);
	public List selectOutDepotByTime(String outTime,int did) ;
	public List selectOutDepotNames(int did);
	public void updateJoin(int did,String wName,float wight);
	public void updateJoinAdd(int did,String wName,float wight) ;
	public void updateOutDepot(OutDepot depot);
}
