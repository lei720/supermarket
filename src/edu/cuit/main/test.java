package edu.cuit.main;

import cuit.edu.BEAN.BasicMessage;
import cuit.edu.DAO.PersonalDao;
import edu.cuit.DAOIMPL.PersonalDaoImpl;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	PersonalDao personalDao=new PersonalDaoImpl();
	BasicMessage basicMessage=personalDao.selectBNameById("��������", "С��");
	 System.out.println(basicMessage.getAge());
	}

}
