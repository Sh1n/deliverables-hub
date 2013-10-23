package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.entities.SystemUser;
import com.gmail.shinsensei.deliverablesHub.logic.utils.HibernateUtil;
import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.SystemUserType;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;

/**
 * Authorization Bean
 * @author Francesco Bux
 */
@Stateless
public class Auth implements AuthRemote, AuthLocal {
    
    
    @Override
    public boolean login(String emailAddress, String password) {
        System.out.println("Chiamata metodo login dell'ejb");
        Random r = new Random();
        return r.nextBoolean();
    }

    @Override
    public SystemUserTO login(SystemUserTO user) {
        String email = user.getEmail();
        String password = user.getPassword();
        System.out.println("Chiamata metodo ejb");
        if(!email.equals("") && !password.equals("")){
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Property emailProp = Property.forName(SystemUser.EMAIL), passProp = Property.forName(SystemUser.PASSWORD);
            List users = session.createCriteria(SystemUser.class).add(emailProp.eq(email)).add(passProp.eq(password)).setMaxResults(1).list();
            session.getTransaction().commit();
            if(users.size() == 1){
                System.out.println("Result found, build the user");
                SystemUser tmp = (SystemUser) users.get(0);
                user = new SystemUserTO(tmp.getUserId(), "", "", tmp.getEmail(), tmp.getRegistrationDate(), SystemUserType.lookup(tmp.getType()));
            }else{
                System.out.println("Results not found " + users.size());
                user = null;
            }
                //user = new SystemUserTO(1, "", "", "sh1n@live.it", null, SystemUserType.ADMIN);
            return user;
        }
        return null;
    }

    @Override
    public SystemUserTO addSystemUser(SystemUserTO user) {
        SystemUser userTmp = new SystemUser();
        userTmp.setEmail(user.getEmail());
        userTmp.setPassword(user.getPassword());
        userTmp.setType(user.getType().toString().toUpperCase());
        java.util.Date today = new java.util.Date();
        java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
        userTmp.setRegistrationDate(ts1);
        System.out.println("la registration date è " + ts1);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(userTmp);
        session.refresh(userTmp);
        session.flush();
        tx.commit();
        session.close();
        return new SystemUserTO(userTmp);
    }

    /**
     * Used to edit a system user
     * @param user
     * @return 
     */
    @Override
    public boolean editSystemUser(SystemUserTO user) {
        SystemUser tmp = new SystemUser();
        tmp.setEmail(user.getEmail());
        tmp.setPassword(user.getPassword());
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(tmp);
            session.flush();
            tx.commit();
            session.close();
            return true;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

}
