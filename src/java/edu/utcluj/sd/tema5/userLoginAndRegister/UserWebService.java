/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcluj.sd.tema5.userLoginAndRegister;

import edu.utcluj.sd.tema5.entity.Appusers;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Eniko
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class UserWebService {
    @PersistenceContext(unitName = "Tema5PU")
    private EntityManager em;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public Appusers login(@WebParam(name = "username") final String username, @WebParam(name = "password") final String password) {
          Query query = em.createNamedQuery("Appusers.findByUsername").setParameter("username", username);
        List<Appusers> result = query.getResultList();
        if(!result.isEmpty()) {
            Appusers user = result.get(0);
                if(password.equals(user.getPassword())) {
                    return user;
            }
        }
        return null; 
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "register")
    public Boolean register(@WebParam(name = "id") final Integer id, @WebParam(name = "name") final String name, @WebParam(name = "username") final String username, @WebParam(name = "password") final String password, @WebParam(name = "address") final String address) {
       Appusers user = new Appusers();
       user.setId(id);
       user.setName(name);
       user.setUsername(username);
       user.setPassword(password);
       user.setAddress(address);
       user.setType("simple");
       em.persist(user);
       return true;
      
    }

}
