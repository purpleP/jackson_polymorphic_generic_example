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
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ConditionalTest {

    @Autowired EntityManager entityManager;

    @Test
    void testEqFilterDate() {
        var f = new GreaterOrEqual<>("date", "2010-01-01");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<A> q = cb.createQuery(A.class);
        Root<A> root = q.from(A.class);
        Predicate p = f.toPredicate(root, cb);
        q.select(root);
        q.where(p);
        entityManager.createQuery(q).getResultList();
    }

    @Test
    void testIsNull() {
        var f = new IsNull("id");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<A> q = cb.createQuery(A.class);
        Root<A> root = q.from(A.class);
        Predicate p = f.toPredicate(root, cb);
        q.select(root);
        q.where(p);
        entityManager.createQuery(q).getResultList();
    }

    @Test
    void testInFilter() {
        var f = new In<>("id", List.of());
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
        var f = new Equal<>("id", 1);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<A> q = cb.createQuery(A.class);
        Root<A> root = q.from(A.class);
        Predicate p = f.toPredicate(root, cb);
        q.select(root);
        q.where(p);
        entityManager.createQuery(q).getResultList();
    }
}