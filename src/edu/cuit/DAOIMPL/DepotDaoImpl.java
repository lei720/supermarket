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
import edu.cuit.util.HibernateUtil;

public class DepotDaoImpl implements DepotDao {

	@Override
	public void deleteDepot(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete Depot as dp where dp.id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		/*session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public void insertDepot(Depot depot) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(depot);
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public List selectDepot() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Depot");
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
	public Depot selectDepotByid(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Depot where id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		List<Dept> list=query.list();
		ArrayList<Dept> arrayList=new ArrayList<Dept>();
		session.getTransaction().commit();
	for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
		Depot dept = (Depot) iterator.next();
		return dept;
	}
	
		/*session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public Depot selectDepotById(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Depot where id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		List<Dept> list=query.list();
		ArrayList<Dept> arrayList=new ArrayList<Dept>();
		session.getTransaction().commit();
	for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
		Depot dept = (Depot) iterator.next();
		return dept;
	}
	
		/*session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public List selectDepotByManage(String manage) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Depot where manage=?";
		Query query=session.createQuery(sql);
		query.setString(0, manage);
		List<Depot> list=query.list();
		ArrayList<Depot> arrayList=new ArrayList<Depot>();
		for (Depot depot : list) {
			arrayList.add(depot);
		}
		session.getTransaction().commit();
/*		session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public List selectDepotByManageAndId(int id, String manage) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Depot where manage=? and id=?";
		Query query=session.createQuery(sql);
		query.setString(0, manage);
		query.setInteger(1, id);
		List<Depot> list=query.list();
		ArrayList<Depot> arrayList=new ArrayList<Depot>();
		for (Depot depot : list) {
			arrayList.add(depot);
		}
		session.getTransaction().commit();
/*		session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public void updateDepot(Depot depot) {
		// TODO Auto-generated method stub
		//dont close the session factory
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(depot);
		//after committing the session shut down automatically
		session.getTransaction().commit();
		
	}

}
