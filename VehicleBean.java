package com.register.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.register.entity.User;
import com.register.entity.Vehicle;

/**
 * Session Bean implementation class VehicleBean
 */
@Stateless
@LocalBean
public class VehicleBean {

    /**
     * Default constructor. 
     */
    public VehicleBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="registry")
    private EntityManager em;
    
    public void addVehicle(Vehicle v, User u) {
    	
    	em.persist(v);
    	
    }
    
    public List<Vehicle> getVehicles() {
    	
    	TypedQuery<Vehicle> query = em.createQuery("SELECT v FROM Vehicle v" , Vehicle.class);
    	
    	List<Vehicle> results = query.getResultList();
    	
    	return results;
    }

}
