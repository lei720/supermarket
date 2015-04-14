package edu.cuit.main;

import cuit.edu.BEAN.BasicMessage;
import cuit.edu.DAO.PersonalDao;
import edu.cuit.DAOIMPL.PersonalDaoImpl;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	PersonalDao personalDao=new PersonalDaoImpl();
	BasicMessage basicMessage=personalDao.selectBNameById("收银部门", "小陈");
	 System.out.println(basicMessage.getAge());
	}

}
