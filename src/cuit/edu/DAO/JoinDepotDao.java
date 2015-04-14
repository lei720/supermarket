package cuit.edu.DAO;

import java.util.List;

import cuit.edu.BEAN.JoinDepot;

public interface JoinDepotDao {
	public void deleteJoinDepot(int id);
	public void insertJoinDepot(JoinDepot joinDepot) ;
	public List selectDepotByOid(String oId) ;
	public List selectDepotId() ;
	public List selectJoinDepot() ;
	public List selectJoinDepot(String joinTime);
	public List selectJoinDepotAndDate(String oid,String joinTime) ;
	public JoinDepot selectJoinDepotByid(int id);
	public List selectNameBydId(int did);
	public List selectOidId();
	public String selectOidId(String oid);
	public void updateJoinDepot(JoinDepot depot);
}
