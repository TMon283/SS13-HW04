package com.example.ss13h04.p2;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class MedicineRepository {

    private Session session;

    public MedicineRepository(Session session) {
        this.session = session;
    }

    public List<Medicine> findByName(String name) {
        String hql = "FROM Medicine m WHERE m.name = :name";
        Query<Medicine> query = session.createQuery(hql, Medicine.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Medicine> findByPriceLessThan(Double price) {
        String hql = "FROM Medicine m WHERE m.price < :price";
        Query<Medicine> query = session.createQuery(hql, Medicine.class);
        query.setParameter("price", price);
        return query.getResultList();
    }
}
