package com.abc.pojoDao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.hibernateUtil.HibernateUtil;
import com.abc.pojo.Orders;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public Orders getOrders(int id) {
		Session s= null;
		try {
			s= HibernateUtil.openSession();
			Orders ord= (Orders) s.get(Orders.class, id);
			return ord;
			
		} finally {
			s.close();
		}

	}

	@Override
	public Orders updateOrders(Orders ord) {
		Session s= null;
		Transaction transaction = null;
		try {
			s= HibernateUtil.openSession();
			transaction = s.beginTransaction();
			s.update(ord);
			transaction.commit();
			return ord;
		} catch (Exception e) {
			transaction.rollback();
		}
		finally {
			s.close();
		}
		return null;
	}

	@Override
	public Orders createOrders(Orders ord) {
		Session s= null;
		Transaction transaction = null;
		try {
			s= HibernateUtil.openSession();
			transaction = s.beginTransaction();
			s.save(ord);
			System.out.println(ord + "Dao Orders");
			transaction.commit();
			return ord;
		} catch (Exception e) {
			transaction.rollback();
		}
		finally {
			s.close();
		}
		return null;
	}

	@Override
	public boolean deleteOrders(int id) {
		Session s= null;
		Transaction t= null;
		
		try {
			s= HibernateUtil.openSession();
			t= s.beginTransaction();
			Orders c = (Orders) s.get(Orders.class, id);
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
