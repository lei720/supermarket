package edu.cuit.DAOIMPL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cui.edu.BEAN.User;

import cuit.edu.DAO.UserDao;
import edu.cuit.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUser(String userName, String passWord) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from Users where userName=? and passWord=?");
		query.setString(0, userName);
		query.setString(1, passWord);
		List<User> list=query.list();
		while (list.iterator().hasNext()) {
			User User=(User) list.iterator().next();
			return User;
		}
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
		return null;
	}

}
