package com.jcang.search.index;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

//@Component
public class SearchIndexer{}
/*public class SearchIndexer implements ApplicationListener<ApplicationReadyEvent>{

    Logger logger = LoggerFactory.getLogger(SearchIndexer.class);

    private EntityManager entityManager;

    public SearchIndexer(final EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        }catch(InterruptedException ex) {
            ex.printStackTrace();
            logger.error("Error creating indexer", ex);
        }
        return;
    }

}*/