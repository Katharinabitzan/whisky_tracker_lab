package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Autowired
    DistilleryRepository distilleryRepository;

    @Transactional
    public List<Whisky> findWhiskiesByYear( int year){
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("this.year", year));

            result = cr.list();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Transactional
    public List<Whisky> findWhiskiesByDistilleryAndAge(String distillery, int age){
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distilleryAlias");
            cr.add(Restrictions.eq("distilleryAlias.name", distillery));
            cr.add(Restrictions.eq("age", age));

            result = cr.list();
        }
        catch(Exception ex){
        ex.printStackTrace();
    }
        return result;
    }

    @Transactional
    public List<Whisky> findWhiskiesByRegion(String region){
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distilleryAlias");
            cr.add(Restrictions.eq( "distilleryAlias.region", region));

            result = cr.list();

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }


}
