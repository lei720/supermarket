package cuit.edu.DAO;

import java.util.List;

import cuit.edu.BEAN.Dept;

public interface DeptDao {
	public void deleteDept(int id);
	public void insertDept(Dept dept);
	public Dept selectDepotById(int id);
	public Dept selectDeptByName(String name);
	public Dept selectDeptByid(int id) ;
	public List selectDept();
	public Dept selectDeptByPrincipal(String manage) ;
	public int selectDeptIdByName(String name);
	public void updateDept(Dept dept);
}
