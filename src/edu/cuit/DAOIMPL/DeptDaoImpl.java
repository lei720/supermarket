package edu.cuit.DAOIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cuit.edu.BEAN.Depot;
import cuit.edu.BEAN.Dept;
import cuit.edu.BEAN.Provide;
import cuit.edu.DAO.DepotDao;
import cuit.edu.DAO.DeptDao;
import edu.cuit.util.HibernateUtil;

public class DeptDaoImpl implements DeptDao {

	@Override
	public void deleteDept(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete Dept as dp where dp.id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		/*session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public void insertDept(Dept dept) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(dept);
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public Dept selectDepotById(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Dept where id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		List<Dept> list=query.list();
		ArrayList<Dept> arrayList=new ArrayList<Dept>();
		session.getTransaction().commit();
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		Dept dept = (Dept) iterator.next();
		return dept;
	}
		
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public Dept selectDeptByName(String name) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Dept where dname=?";
		Query query=session.createQuery(sql);
		query.setString(0, name);
		List<Dept> list=query.list();
		ArrayList<Dept> arrayList=new ArrayList<Dept>();
		session.getTransaction().commit();
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		Dept dept = (Dept) iterator.next();
		return dept;
	}
		
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public Dept selectDeptByid(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Dept where id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		List<Dept> list=query.list();
		ArrayList<Dept> arrayList=new ArrayList<Dept>();
		session.getTransaction().commit();
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		Dept dept = (Dept) iterator.next();
		return dept;
	}
	
		/*session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public List selectDept() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Dept");
		List< Dept> list=query.list();
		session.getTransaction().commit();
		ArrayList<Dept> arrayList=new ArrayList<Dept>();
		for (Dept dept : list) {
			arrayList.add(dept);
		}
	
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public Dept selectDeptByPrincipal(String manage) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Dept where principal=?";
		Query query=session.createQuery(sql);
		query.setString(0, manage);
		List<Dept> list=query.list();
		ArrayList<Dept> arrayList=new ArrayList<Dept>();
		session.getTransaction().commit();
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		Dept dept = (Dept) iterator.next();
		return dept;
	}
		
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public int selectDeptIdByName(String name) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="select id from Dept where dname=?";
		Query query=session.createQuery(sql);
		query.setString(0, name);
		List<Dept> list=query.list();
		ArrayList<Dept> arrayList=new ArrayList<Dept>();
		session.getTransaction().commit();
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		Integer id = (Integer) iterator.next();
		return id;
	}
		
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return -1;
	}

	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(dept);
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
	}


}
