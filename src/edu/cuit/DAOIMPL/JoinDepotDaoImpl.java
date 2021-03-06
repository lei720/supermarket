package edu.cuit.DAOIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.loader.plan.spi.Join;
import org.hibernate.loader.plan.spi.QuerySpace;

import com.sun.org.apache.regexp.internal.recompile;

import cuit.edu.BEAN.Depot;
import cuit.edu.BEAN.JoinDepot;
import cuit.edu.DAO.JoinDepotDao;
import edu.cuit.util.HibernateUtil;

public class JoinDepotDaoImpl implements JoinDepotDao {

	@Override
	public void deleteJoinDepot(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("delete JoinDepot as jd where jd.id=?");
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		
	}

	@Override
	public void insertJoinDepot(JoinDepot joinDepot) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(joinDepot);
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public List selectDepotByOid(String oId) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from JoinDepot where oid=?");
		query.setString(0, oId);
		List<JoinDepot> list=query.list();
		ArrayList<JoinDepot> arrayList=new ArrayList<JoinDepot>();
		for (JoinDepot joinDepot : list) {
			arrayList.add(joinDepot);
		}
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public List selectDepotId() {
		// TODO Auto-generated method stub
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query=session.createQuery("select id from Depot ");
			List<Integer> list=query.list();
			ArrayList<Integer> arrayList=new ArrayList<Integer>();
			for (Integer integer :list) {
				arrayList.add(integer);
			}
			session.getTransaction().commit();
		/*	session.close();
			HibernateUtil.closeSessionFactory();*/
			return arrayList;
	}

	@Override
	public List selectJoinDepot() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from JoinDepot ");
		List<Depot> list=query.list();
		ArrayList<Depot> arrayList=new ArrayList<Depot>();
		for (Depot depot :list) {
			arrayList.add(depot);
		}
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public List selectJoinDepot(String joinTime) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from JoinDepot where joinTime=?");
		query.setString(0, joinTime);
		List<Depot> list=query.list();
		ArrayList<Depot> arrayList=new ArrayList<Depot>();
		for (Depot depot :list) {
			arrayList.add(depot);
		}
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public List selectJoinDepotAndDate(String oid, String joinTime) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from JoinDepot where joinTime=? and oid=?");
		query.setString(0, joinTime);
		query.setString(1, oid);
		List<Depot> list=query.list();
		ArrayList<Depot> arrayList=new ArrayList<Depot>();
		for (Depot depot :list) {
			arrayList.add(depot);
		}
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public JoinDepot selectJoinDepotByid(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from JoinDepot where id=?");
		query.setInteger(0, id);
		List<JoinDepot> list=query.list();
		session.getTransaction().commit();
		ArrayList<JoinDepot> arrayList=new ArrayList<JoinDepot>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			JoinDepot joinDepot = (JoinDepot) iterator.next();
			return joinDepot;
		}
	
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public List selectNameBydId(int did) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql=" select wareName from JoinDepot where  did=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, did);
		List<String> list=query.list();
		ArrayList<String> arrayList=new ArrayList<String>();
		for (String wareName : list) {
			arrayList.add(wareName);
		}
		session.getTransaction().commit();
/*		session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public List selectOidId() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("select orderId from Stock ");
		List<String> list=query.list();
		ArrayList<String> arrayList=new ArrayList<String>();
		for (String orderid :list) {
			arrayList.add(orderid);
		}
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public String selectOidId(String oid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql=" select sname from Stock where  orderId=?";
		Query query=session.createQuery(sql);
		query.setString(0, oid);
		List<String> list=query.list();
		ArrayList<String> arrayList=new ArrayList<String>();
		session.getTransaction().commit();
	for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
		String string = (String) iterator.next();
		return string;
	}
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public void updateJoinDepot(JoinDepot depot) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(depot);
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
	}


}
