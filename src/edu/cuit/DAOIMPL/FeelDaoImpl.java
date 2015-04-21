package edu.cuit.DAOIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cuit.edu.BEAN.OutDepot;
import cuit.edu.BEAN.Provide;
import cuit.edu.DAO.FeelDao;
import edu.cuit.util.HibernateUtil;

public class FeelDaoImpl implements FeelDao {

	@Override
	public void deleteProvide(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete Provide as pro where pro.id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public void insertProvide(Provide provide) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(provide);
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public List selectProvide() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Provide");
		List<Provide> list=query.list();
		ArrayList<Provide> arrayList=new ArrayList<Provide>();
		for (Provide provide : list) {
			arrayList.add(provide);
		}
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public List selectProvideByAddress(String address) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Provide where address=?";
		Query query=session.createQuery(sql);
		query.setString(0, address);
		List<Provide> list=query.list();
		ArrayList<Provide> arrayList=new ArrayList<Provide>();
		for (Provide provide : list) {
			arrayList.add(provide);
		}
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public Provide selectProvideByid(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Provide where id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		List<Provide> list=query.list();
		ArrayList<Provide> arrayList=new ArrayList<Provide>();
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		Provide provide = (Provide) iterator.next();
		return provide;
	}
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public List selectProvideByName(String name) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Provide where cname=?";
		Query query=session.createQuery(sql);
		query.setString(0, name);
		List<Provide> list=query.list();
		ArrayList<Provide> arrayList=new ArrayList<Provide>();
		for (Provide provide : list) {
			arrayList.add(provide);
		}
		session.getTransaction().commit();
/*		session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public List selectProvideByNameAddress(String address, String name) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Provide where cname=? and address=?";
		Query query=session.createQuery(sql);
		query.setString(0, name);
		query.setString(1, address);
		List<Provide> list=query.list();
		ArrayList<Provide> arrayList=new ArrayList<Provide>();
		for (Provide provide : list) {
			arrayList.add(provide);
		}
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public void updateProvide(Provide provide) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(provide);
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
	}

}
