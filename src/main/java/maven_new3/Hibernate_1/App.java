package maven_new3.Hibernate_1;

import java.time.LocalDate;
import java.sql.Date;

import com.abc.pojo.Address;
import com.abc.pojo.Customer;
import com.abc.pojo.OrderItem;
import com.abc.pojo.OrderItemId;
import com.abc.pojo.Orders;
import com.abc.pojoDao.CustomerDao;
import com.abc.pojoDao.CustomerDaoImpl;
import com.abc.pojoDao.OrderItemDao;
import com.abc.pojoDao.OrderItemDaoImpl;
import com.abc.pojoDao.OrdersDao;
import com.abc.pojoDao.OrdersDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
    	
    		Address add= new Address("2527 Louise Street", "Denton", "TX", "76201");
    		//adding customers to the database
    		Customer c= new Customer(null, "Akhil", Date.valueOf(LocalDate.of(1995, 05, 29)), add, null);
    		Customer c1= new Customer(null, "lfbr", Date.valueOf(LocalDate.of(1996, 06, 20)), add, null);
    		Customer c3= new Customer(null, "kuebf", Date.valueOf(LocalDate.of(1996, 06, 20)), add, null);
    		CustomerDao cd= new CustomerDaoImpl();
    		cd.createCustomer(c);
    		cd.createCustomer(c1);
    		cd.createCustomer(c3);
    		
    		
    		Customer c2= cd.getCustomer(1);
    		
    		Orders o = new Orders(null, 4328.0,3, Date.valueOf(LocalDate.of(2018, 07, 10)), null);
    		Orders o1 = new Orders(null, 837.0, 1, Date.valueOf(LocalDate.of(2018, 07, 10)), null);
    		OrdersDao od= new OrdersDaoImpl();
    		od.createOrders(o);
    		od.createOrders(o1);
    		Orders o2= od.getOrders(2);
    		System.out.println(o1 + "test 10");
    		
    		OrderItemId oid= new OrderItemId();
    		oid.setItem_id(1);
    		oid.setOrder_id(o1.getCust_id());
    		
    		OrderItem oi= new OrderItem(oid, 3);
    		OrderItemDao oiDao= new OrderItemDaoImpl();
    		oiDao.createOrderItem(oi);
    		
    		oiDao.createOrderItem (new OrderItem(new OrderItemId(2,100), 10));
    		oiDao.createOrderItem (new OrderItem(new OrderItemId(2,99), 9));
    		
    		
    		c.setName("Krishna");
    		cd.updateCustomer(c);    	
    		
    		Customer c4= cd.getCustomer(1);
    		System.out.println(c3);
    		
    		OrderItem oi2= oiDao.getOrderItem(new OrderItemId(2, 99));
 
    		oiDao.deleteOrderItem(oi2.getOrderItemID());
    		
    		
    		
        System.out.println( "Done" );
    }
}
