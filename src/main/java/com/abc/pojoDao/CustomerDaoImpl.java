package com.abc.pojoDao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.hibernateUtil.HibernateUtil;
import com.abc.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer getCustomer(int id) {
		Session s= null;
		try {
			s= HibernateUtil.openSession();
			Customer c= (Customer) s.get(Customer.class, id);
			return c;
			
		} finally {
			s.close();
		}

	}

	@Override
	public Customer updateCustomer(Customer cus) {
		// TODO Auto-generated method stub
		Session s= null;
		Transaction transaction = null;
		try {
			s= HibernateUtil.openSession();
			transaction = s.beginTransaction();
			s.update(cus);
			transaction.commit();
			return cus;
		} catch (Exception e) {
			transaction.rollback();
		}
		finally {
			s.close();
		}
		return null;
	}

	@Override
	public Customer createCustomer(Customer cus) {
		Session s= null;
		Transaction transaction = null;
		try {
			s= HibernateUtil.openSession();
			transaction = s.beginTransaction();
			s.save(cus);
			transaction.commit();
			return cus;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("create customer method");
			transaction.rollback();
		}
		finally {
			s.close();
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(int id) {
		Session s= null;
		Transaction t= null;
		
		try {
			s= HibernateUtil.openSession();
			t= s.beginTransaction();
			Customer c = (Customer) s.get(Customer.class, id);
			if(c!= null) {
				s.delete(c);
				t.commit();
				return true;
			}
		} catch (Exception e) {
			t.rollback();
		}
		finally {
			s.close();
		}
		return false;
	}

}
