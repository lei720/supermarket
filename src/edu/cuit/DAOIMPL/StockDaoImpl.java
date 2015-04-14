package edu.cuit.DAOIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import sun.launcher.resources.launcher;
import cuit.edu.BEAN.Stock;
import cuit.edu.DAO.StockDao;
import edu.cuit.util.HibernateUtil;

public class StockDaoImpl implements StockDao {

	@Override
	public void insertStock(Stock stock) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(stock);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	

	@Override
	public List selectStock() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		ArrayList<Stock> arrayList=new ArrayList<Stock>();
		session.beginTransaction();
		String sql="from Stock";
		Query query=session.createQuery(sql);
		List<Stock> list=query.list();
		for (Stock stock : list) {
			arrayList.add(stock);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public int selectJoinStockByOid(String oid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql=" select id from joinDepot where oid=?";
		Query query=session.createQuery(sql);
		query.setString(0, oid);
		List<Integer> list=query.list();
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return list.get(0);
		
		
	
	}

	@Override
	public List selectStockBySName(String sName) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Stock where sName=?";
		Query query=session.createQuery(sql);
		query.setString(0, sName);
		List<Stock> list=query.list();
		ArrayList<Stock> arrayList=new ArrayList<Stock>();
		for (Stock stock : list) {
			arrayList.add(stock);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public List selectStockByOid(String oId) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Stock where orderId=?";
		Query query=session.createQuery(sql);
		query.setString(0, oId);
		List<Stock> list=query.list();
		ArrayList<Stock> arrayList=new ArrayList<Stock>();
		for (Stock stock : list) {
			arrayList.add(stock);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public List selectStockByDate(String cDate) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Stock where consignmentDate=?";
		Query query=session.createQuery(sql);
		query.setString(0, cDate);
		List<Stock> list=query.list();
		ArrayList<Stock> arrayList=new ArrayList<Stock>();
		for (Stock stock : list) {
			arrayList.add(stock);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public Stock selectStockByid(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from Stock where id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		List<Stock> list=query.list();
		ArrayList<Stock> arrayList=new ArrayList<Stock>();
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
			Stock stock = (Stock) iterator.next();
			return stock;
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return null;
	}

	@Override
	public void updateStock(Stock stock) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(stock);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void deleteStock(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete Stock as s where s.id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	

}
