package hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DataFilterTest {

    @Autowired EntityManager entityManager;

    @Test
    void testGeFilter() {
        var f = new GeFilter<>("date", "2010-01-01");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<A> q = cb.createQuery(A.class);
        Root<A> root = q.from(A.class);
        Predicate p = f.toPredicate(root, cb);
        q.select(root);
        q.where(p);
        entityManager.createQuery(q).getResultList();
    }

    @Test
    void testEqFilter() {
        var f = new EqFilter<>("id", 1);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<A> q = cb.createQuery(A.class);
        Root<A> root = q.from(A.class);
        Predicate p = f.toPredicate(root, cb);
        q.select(root);
        q.where(p);
        entityManager.createQuery(q).getResultList();
    }
}