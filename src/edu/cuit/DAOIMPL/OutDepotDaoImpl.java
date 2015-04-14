package edu.cuit.DAOIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import sun.launcher.resources.launcher;
import cuit.edu.BEAN.JoinDepot;
import cuit.edu.BEAN.OutDepot;
import cuit.edu.DAO.OutDepotDao;
import edu.cuit.util.HibernateUtil;

public class OutDepotDaoImpl implements OutDepotDao {

	@Override
	public void deleteOutDepot(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete OutDepot as od where od.id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void insertOutDepot(OutDepot depot) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(depot);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
	// 定义按货品名称查询货品重量方法
	@Override
	public float selectJoinDepotAndDate(String wName, int did) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "select weight from joinDepot where wareName = ? and did =?";
		float float1=0;
		Query query=session.createQuery(sql);
		query.setString(0, wName);
		query.setInteger(1, did);
		List<Float> list=query.list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			float1 = (Float) iterator.next();
			return float1;
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return float1;
		
	}

	@Override
	public List selectOutDepot() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from OutDepot");
		List<OutDepot> list=query.list();
		ArrayList<OutDepot> arrayList=new ArrayList<OutDepot>();
		for (OutDepot outDepot : list) {
			arrayList.add(outDepot);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
		
	}

	@Override
	public List selectOutDepotByDid(int did) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from OutDepot where did=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, did);
		List<OutDepot> list=query.list();
		ArrayList<OutDepot> arrayList=new ArrayList<OutDepot>();
		for (OutDepot outDepot : list) {
			arrayList.add(outDepot);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public OutDepot selectOutDepotByid(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from OutDepot where id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		List<OutDepot> list=query.list();
		ArrayList<OutDepot> arrayList=new ArrayList<OutDepot>();
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
			OutDepot outDepot = (OutDepot) iterator.next();
			return outDepot;
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return null;
	}

	@Override
	public List selectOutDepotByTime(String outTime, int did) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql=" from OutDepot where outDate=? and did=?";
		Query query=session.createQuery(sql);
		query.setString(0, outTime);
		query.setInteger(1, did);
		List<OutDepot> list=query.list();
		ArrayList<OutDepot> arrayList=new ArrayList<OutDepot>();
		for (OutDepot outDepot : list) {
			arrayList.add(outDepot);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public List selectOutDepotNames(int did) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql=" select wareName from OutDepot where  did=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, did);
		List<String> list=query.list();
		ArrayList<String> arrayList=new ArrayList<String>();
		for (String wareName : list) {
			arrayList.add(wareName);
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		return arrayList;
	}

	@Override
	public void updateJoin(int did, String wName, float wight) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from JoinDepot where did=? and wareName=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, did);
		query.setString(1, wName);
		List<JoinDepot> list=query.list();
		JoinDepot joinDepot=null;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			joinDepot = (JoinDepot) iterator.next();
			
		}
		double w=joinDepot.getWeight();
		w=w-wight;
		joinDepot.setWeight(w);
		session.update(joinDepot);
		session.getTransaction().commit();
	/*	wight=-wight;
		query.setFloat(0, wight);
		query.setInteger(1, did);
		query.setString(3, wName);
		query.executeUpdate();*/
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void updateJoinAdd(int did, String wName, float wight) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="from JoinDepot where did=? and wareName=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, did);
		query.setString(1, wName);
		List<JoinDepot> list=query.list();
		JoinDepot joinDepot=null;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			joinDepot = (JoinDepot) iterator.next();
			
		}
		double w=joinDepot.getWeight();
		w=w+wight;
		joinDepot.setWeight(w);
		session.update(joinDepot);
		session.getTransaction().commit();
	/*	wight=-wight;
		query.setFloat(0, wight);
		query.setInteger(1, did);
		query.setString(3, wName);
		query.executeUpdate();*/
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void updateOutDepot(OutDepot depot) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(depot);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

}
