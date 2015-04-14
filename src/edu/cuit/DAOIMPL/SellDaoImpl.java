package edu.cuit.DAOIMPL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cuit.edu.BEAN.Sell;
import cuit.edu.BEAN.Stock;
import cuit.edu.BEAN.Ware;
import cuit.edu.DAO.SellDao;
import edu.cuit.util.HibernateUtil;

public class SellDaoImpl implements SellDao {

	@Override
	public void insertSell(Sell sell) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(sell);
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public List selectSell() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		ArrayList<Sell> arrayList=new ArrayList<Sell>();
		session.beginTransaction();
		String sql="from Stock";
		Query query=session.createQuery(sql);
		List<Sell> list=query.list();
		for (Sell Sell : list) {
			arrayList.add(Sell);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public Sell selectProvideByid(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		String sql="from Sell where id=?";
		session.beginTransaction();
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		List<Sell> list=query.list();
		while (list.iterator().hasNext()) {
			Sell sell=(Sell) list.iterator().next();
			return sell;
		}
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
		return null;
	}

	@Override
	public List selectsellByAddress(String address) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Sell where address=?";
		Query query=session.createQuery(sql);
		query.setString(0, address);
		List<Sell> list=query.list();
		ArrayList<Sell> arrayList=new ArrayList<Sell>();
		for (Sell sell : list) {
			arrayList.add(sell);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public List selectsellByName(String name) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Sell where sellName=?";
		Query query=session.createQuery(sql);
		query.setString(0, name);
		List<Sell> list=query.list();
		ArrayList<Sell> arrayList=new ArrayList<Sell>();
		for (Sell sell : list) {
			arrayList.add(sell);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public List selectSellByNameAddress(String address, String name) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Sell where sellName=? and emaillAddress=?";
		Query query=session.createQuery(sql);
		query.setString(0, name);
		query.setString(1, address);
		List<Sell> list=query.list();
		ArrayList<Sell> arrayList=new ArrayList<Sell>();
		for (Sell sell : list) {
			arrayList.add(sell);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public void updateSell(Sell sell) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(sell);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void deleteSell(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete Sell as s where s.id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

}
