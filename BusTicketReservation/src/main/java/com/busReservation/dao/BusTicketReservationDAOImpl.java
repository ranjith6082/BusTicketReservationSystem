package com.busReservation.dao;

import com.busReservation.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BusTicketReservationDAOImpl implements BusTicketReservationDao {
	
	private final SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	
	
	public BusTicketReservationDAOImpl() {
		
		
		
	}
	
	//--------------------------ADD NEW USER-----------------------------//
	@Override
	public void addUser(User user) {
		try(Session session = sf.openSession()){
			Transaction t = session.beginTransaction();
			session.save(user);
			t.commit();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	//--------------------------ADD BUS INFO-----------------------------//
	@Override
	public void addBus(BusInfo busInfo) {
		
		try(Session session = sf.openSession()){
			Transaction t = session.beginTransaction();
			session.save(busInfo);
			t.commit();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	//--------------------------CREATE A LIST AND STORING ALL ADMIN DETAILS-----------------------------//
	@Override
		public List<Admin> getAllAdmins() {
	        try (Session session = sf.openSession()) {
	            Query<Admin> query = session.createQuery("FROM Admin", Admin.class);
	            return query.list();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ArrayList<>(); 
	        }
	    }
	
	//--------------------------VALIDATING ADMIN-----------------------------//
	@Override
    public boolean isValidAdmin(String adminName,String password) {
		try (Session session = sf.openSession()) {
			
			List<Admin> admins = getAllAdmins();

			return admins.stream().anyMatch(admin ->  admin.getAdminName().equals(adminName) && admin.getPassword().equals(password) );
	    }
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	
	}
	
	//--------------------------CREATE A LIST AND STORING ALL USER DETAILS-----------------------------//
	@Override
	public List<User> getAllUsers() {
        try (Session session = sf.openSession()) {
            Query<User> query = session.createQuery("FROM User", User.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
	
	//--------------------------VALIDATING USER-----------------------------//
	@Override
	public boolean isValidUser(String userName,String password) {
		try (Session session = sf.openSession()) {
			
			List<User> users = getAllUsers();
	
			return users.stream().anyMatch(user ->  user.getUserName().equals(userName) && user.getPassword().equals(password) );
	    }
		catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}
	
	//--------------------------GET USER ID BY EMAIL-----------------------------//
	@Override
	public List<User> getByEmail(String email) {
		 try (Session session = sf.openSession()) {
			 String hql = "FROM User WHERE email = :email";
	         Query<User> query = session.createQuery(hql, User.class);
	         query.setParameter("email", email);
	         return query.getResultList();
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		return null;
	}
	
	//--------------------------ADD BOOKING DETAILS-----------------------------//
	@Override
	public void addBooking(BookingInfo bookingInfo) {
		try(Session session = sf.openSession()){
			Transaction t = session.beginTransaction();
			session.save(bookingInfo);
			t.commit();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	//--------------------------GET SPECIFIC BUS DETAILS-----------------------------//
	public BusInfo getBusByNo(int busNo) {
		 try (Session session = sf.openSession()) {
	            return session.get(BusInfo.class, busNo);
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		return null;
		
	}
	
	//--------------------------UPDATING BUS DETAILS-----------------------------//
	 @Override
	 public void updateBus(BusInfo busInfo) {
	        try (Session session = sf.openSession()) {
	            Transaction t = session.beginTransaction();
	            session.update(busInfo);
	            t.commit();
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        }
	 }
	 
	//--------------------------DISPLAYING ALL BUS DETAILS-----------------------------//
	 @Override
	 public List<BusInfo> displayAllBuses(){
		 try (Session session = sf.openSession()) {
	            Query<BusInfo> query = session.createQuery("FROM BusInfo", BusInfo.class);
	            return query.list();
	        }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		return null;
	 }
	 
	//--------------------------DELETING BUS DETAILS-----------------------------//
	 public void deleteBus(BusInfo busInfo) {
	        try (Session session = sf.openSession()) {
	            session.beginTransaction();
	            session.delete(busInfo);
	            session.getTransaction().commit();
	        } 
	        catch (Exception e) {
	            System.out.println("Error deleting bus: " + e.getMessage());
	        }
	 }
	 
	 
	 
}
