package edu.cuit.DAOIMPL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import cuit.edu.DAO.WareDao;
import cuit.edu.BEAN.Ware;
import edu.cuit.util.HibernateUtil;

public class WareDaoImpl implements WareDao {

	@Override
	public void insertWare(Ware ware) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	/*	Query query=session.createQuery(sql);
		query.setString(1, ware.getWareName());	
		query.setString(2, ware.getWarBewrite());	
		query.setString(3, ware.getSpec());
		query.setFloat(4,  ware.getStockPrice());
		query.setFloat(5, ware.getRetailPrice());
		query.setFloat(6, ware.getAssociatorPrice());	*/
		session.save(ware);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public List selectWare() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Ware";
		Query query=session.createQuery(sql);
		List<Ware> list=query.list();
		ArrayList<Ware> arrayList=new ArrayList<Ware>();
		for (Ware ware : list) {
			arrayList.add(ware);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public Ware selectWareByid(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		String sql="from Ware where id=?";
		session.beginTransaction();
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		List<Ware> list=query.list();
		while (list.iterator().hasNext()) {
			Ware ware=(Ware) list.iterator().next();
			return ware;
		}
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
		return null;
	}

	@Override
	public List selectWareByName(String name) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Ware where wareName=?";
		Query query=session.createQuery(sql);
		query.setString(0, name);
		List<Ware> list=query.list();
		ArrayList<Ware> arrayList=new ArrayList<Ware>();
		for (Ware ware : list) {
			arrayList.add(ware);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public void updateWare(Ware ware) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(ware);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void deleteWare(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete Ware as w where w.id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	

}
