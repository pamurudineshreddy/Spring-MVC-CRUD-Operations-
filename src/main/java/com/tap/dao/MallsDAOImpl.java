 package com.tap.dao;

import java.io.Serializable;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.entity.MallsEntity;
@Component
public class MallsDAOImpl implements MallsDAO {
	
	

	public MallsDAOImpl() {
		System.out.println("daoimpl obj created");
	}


	@Autowired
	private  SessionFactory sessionfactory;

	
	@Override
	public boolean insertData(MallsEntity entity) {
		 Session session=null;
		 Transaction beginTransaction;
		boolean isSaved = false;
		
		
		 try {
			 session = sessionfactory.openSession();
			 beginTransaction = session.beginTransaction();
			 Serializable save = session.save(entity);
			 isSaved = true;
			 beginTransaction.commit();
		} finally {
			if(session!=null) {
				session.close();
			}
		}
		return isSaved;
	}


	@Override
	public MallsEntity searchId(int id) {
		MallsEntity mallsEntity = null;
		Session openSession2  = null;
		try {
			
			 openSession2 = sessionfactory.openSession();
			 mallsEntity = openSession2.get(MallsEntity.class, id);
			 System.out.println(mallsEntity.getCity());
			 System.out.println(mallsEntity.getId());
			 System.out.println(mallsEntity.getMallname());
			 System.out.println(mallsEntity.getAddress());
			 System.out.println(mallsEntity.getState());
			 System.out.println(mallsEntity.getTotalfloors());
			 System.out.println(mallsEntity.getTotalshops());
			 System.out.println(mallsEntity.getTotalstaff());
			 if(mallsEntity!=null) {
				 
				 return mallsEntity;
			 }
			
			
		} finally {
			if(openSession2!=null) {
				System.out.println("searchId session closed");
				openSession2.close();
			}
		}
		
		return mallsEntity;
		
	}


	@Override
	public MallsEntity searchByName(String name) {
		System.out.println("searchname daoimpl");
		MallsEntity mallsEntity = null;
		Session openSession2  = null;
		
		try {
			 String hql = "from MallsEntity where mallname='"+name+"'";
			 openSession2 = sessionfactory.openSession();
			 org.hibernate.query.Query createQuery = openSession2.createQuery(hql);
			 mallsEntity =(MallsEntity) createQuery.uniqueResult();
			 System.out.println(mallsEntity);
			 
			 if(mallsEntity!=null) {
				 
				 return mallsEntity;
			 }
			
			
		} finally {
			if(openSession2!=null) {
				System.out.println("searchByName session closed");
				openSession2.close();
			}
		}
		return mallsEntity;
		
	}

	@Override
	public List<MallsEntity> searchByCity(String name) {
		List<MallsEntity> resultList = null;
		Session openSession2  = null;
		
		try {
			 String hql = "from MallsEntity where city='"+name+"'";
			 openSession2 = sessionfactory.openSession();
			 org.hibernate.query.Query createQuery = openSession2.createQuery(hql);
			 resultList = createQuery.getResultList();
			 System.out.println(resultList);
			 
			 if(resultList!=null) {
				 
				 return resultList;
			 }
			
			
		} finally {
			if(openSession2!=null) {
				System.out.println("searchByName session closed");
				openSession2.close();
			}
		}
		return resultList;
	}

	@Override
	public List<MallsEntity> getTableData() {
		Session openSession2 = null;
		List<MallsEntity> resultList2 = null;
		
		try {
			
			openSession2 = sessionfactory.openSession();
			String hql = "from MallsEntity";
			org.hibernate.query.Query createQuery = openSession2.createQuery(hql);
			 resultList2 = createQuery.getResultList();
			 return resultList2;
			
			
			
		} finally {
			if(openSession2!=null) {
				System.out.println("getTableData session closed");
			}
		}
	}



	@Override
	public boolean deleteDataById(int id) {
		Session openSession2  = null;
		String hql = "delete from MallsEntity where id='"+id+"'";
		
		
		try {
			
			openSession2 = sessionfactory.openSession();
			
			Transaction transaction = openSession2.beginTransaction();
			org.hibernate.query.Query createQuery = openSession2.createQuery(hql);
			int executeUpdate = createQuery.executeUpdate();
			transaction.commit();
			
			if(executeUpdate==1) {
				return true;
			}else {
				return false;
			}
			
			
			
		} finally {
			if(openSession2!=null) {
				openSession2.close();
			}
		}
		
	}


	@Override
	public boolean updateEntity(int id, String name, String state, String city, String address, int totalfloors,
			int totalshops, int totalstaff) {
		Session openSession= null;
		Transaction beginTransaction = null;
		
		boolean flag = false;
		try {
			openSession = sessionfactory.openSession();
			beginTransaction = openSession.beginTransaction();
		    String hql="update MallsEntity e set e.mallname='"+name+"', e.state="+state+",e.city='"+city+"',"
		    		+ "e.address='"+address+"',e.totalfloors='"+totalfloors+"',"
		    		+ "e.totalshops='"+totalshops+"',e.totalstaff ='"+totalstaff+"' where e.id="+id+"";  
		    
		    org.hibernate.query.Query query = openSession.createQuery(hql);
		    int executeUpdate = query.executeUpdate();

			
			beginTransaction.commit();
			
			if(executeUpdate==1) {
				flag = true;
			}
			
			
			
		} catch (HibernateException e) {
			String message = e.getMessage();
			System.out.println(message);
			beginTransaction.rollback();
		}
		finally {
			if(openSession!=null) {
				openSession.close();
			}
			
		}
		return flag;
	}


	


	
	
	
	
	


}
