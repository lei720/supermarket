package edu.cuit.DAOIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javassist.bytecode.SignatureAttribute.NestedClassType;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import cuit.edu.BEAN.BasicMessage;
import cuit.edu.BEAN.Contact;
import cuit.edu.BEAN.Depot;
import cuit.edu.BEAN.Dept;
import cuit.edu.BEAN.Headship;
import cuit.edu.BEAN.Sell;
import cuit.edu.BEAN.Stock;
import cuit.edu.DAO.PersonalDao;
import edu.cuit.util.HibernateUtil;

public class PersonalDaoImpl implements PersonalDao {

	@Override
	public void insertBasicMessage(BasicMessage message) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(message);
		session.getTransaction().commit();
/*		session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public void insertContact(Contact contact) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(contact);
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public List selectHeadship() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		ArrayList<Headship> arrayList=new ArrayList<Headship>();
		session.beginTransaction();
		String sql="from Headship";
		Query query=session.createQuery(sql);
		List<Headship> list=query.list();
		for (Headship headship : list) {
			arrayList.add(headship);
		}
		session.getTransaction().commit();
/*		session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
	}

	@Override
	public int selectIdByHeadship(String hName) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql=" select id from Headship where headshipName=?";
		Query query=session.createQuery(sql);
		query.setString(0, hName);
		List<Integer> list=query.list();
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			return integer;
		}
		return -1;
	}

	@Override
	public List selectBasicMessageByDept(int dept) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql=" select name from BasicMessage where dept=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, dept);
		List<String> list=query.list();
		ArrayList<String> arrayList=new ArrayList<String>();
		for (String name : list) {
			arrayList.add(name);
		}
		session.getTransaction().commit();
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return arrayList;
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
		
		/*session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public String selectHeadshipById(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql=" select headshipName from Headship where id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		List<String> list=query.list();
		session.getTransaction().commit();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			return string;
		}
		
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public BasicMessage selectBNameById(String dept, String name) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "from BasicMessage where name = ? and dept = (select id from Dept where dname =?)";	//定义查询数据SQL语句
		Query query=session.createQuery(sql);
	
		query.setString(0, name);
		query.setString(1, dept);
		List<BasicMessage> list=query.list();
		session.getTransaction().commit();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			BasicMessage basicMessage = (BasicMessage) iterator.next();
			return basicMessage;
		}
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public Contact selectContactById(int hid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql=" from Contact where hid=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, hid);
		List<Contact> list=query.list();
		session.getTransaction().commit();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Contact contact = (Contact) iterator.next();
			return contact;
		}
		
	/*	session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public BasicMessage selectMessageById(int hid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql=" from BasicMessage where id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, hid);
		List<BasicMessage> list=query.list();
		session.getTransaction().commit();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			BasicMessage basicMessage = (BasicMessage) iterator.next();
			return basicMessage;
		}
	
/*		session.close();
		HibernateUtil.closeSessionFactory();*/
		return null;
	}

	@Override
	public void updatertMessage(BasicMessage message) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(message);
		session.getTransaction().commit();
		/*session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public void updatertContact(Contact contact) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("update Contact con set contact = ?,officePhone = ?,fax=?,email=?,faddress=? where hid =?");
		query.setString(0, contact.getContact());
		query.setString(1, contact.getOfficePhone());
		query.setString(2, contact.getFax());
		query.setString(3, contact.getEmail());
		query.setString(4, contact.getFaddress());
		query.setInteger(5, contact.getHid());
		query.executeUpdate();
//		session.update(contact);
		session.getTransaction().commit();
/*		session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public void deleteBasicMessage(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		System.out.println("id:"+id);
	/**/	String sql="delete from BasicMessage  where id=?";
		Query query=session.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();
		
	/*	BasicMessage basicMessage=new BasicMessage();
		basicMessage.setId(id);
		session.delete(basicMessage);*/
	/*	Contact contact=new Contact();
		contact.setId(id);
		session.delete(contact);*/
		session.getTransaction().commit();
		/*session.close();
		HibernateUtil.closeSessionFactory();*/
	}

	@Override
	public int selectBasicMessageByName(String name) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("select id from BasicMessage where name=?");
		query.setString(0, name);
		List<Integer> list=query.list();
		session.getTransaction().commit();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			return integer;
		}
		return -1;
	}

	@Override
	public void deleteContact(int hid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("delete from Contact  where hid=?");
		query.setInteger(0, hid);
		query.executeUpdate();
		session.getTransaction().commit();
	}

}
