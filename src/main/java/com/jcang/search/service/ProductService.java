package com.jcang.search.service;

import com.jcang.search.dao.ProductDao;
import com.jcang.search.entity.ProductEntity;
import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.elasticsearch.ElasticsearchQueries;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.engine.spi.QueryDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;


@Service
public class ProductService {

    private EntityManager entityManager;
    private ProductDao dao;

    public ProductService(final EntityManagerFactory entityManagerFactory, final ProductDao dao) {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.dao = dao;
    }

    public List<ProductEntity> search(String text){
        /*FullTextEntityManager fullTextEntityManager = Search.getFullTextSession(entityManager.unwrap(Session.class));

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
                .forEntity(ProductEntity.class).get();

        Query query = queryBuilder
                .keyword()
                .onFields("name")
                .matching(text)
                .createQuery();

        org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, ProductEntity.class);

        return jpaQuery.getResultList();*/
        FullTextSession fullTextSession = Search.getFullTextSession(entityManager.unwrap(Session.class));
        QueryDescriptor query = ElasticsearchQueries.fromQueryString(text);
        List<?> result = fullTextSession.createFullTextQuery(query, ProductEntity.class).list();
        return null;
    }

    @Transactional
    public void create(ProductEntity productEntity){
        productEntity.setId(UUID.randomUUID().toString());
        dao.save(productEntity);
    }
}
