package com.example.webserviceexample;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.example.webserviceexample.configuration.CassandraConfig;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CassandraConfig.class)
public class BookRepositoryIntegrationTest {

    @BeforeClass
    public static void startCassandraEmbedded() {
      //  EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        Cluster cluster = Cluster.builder()
                .addContactPoints("127.0.0.1").withPort(9142).build();
        Session session = cluster.connect();
    }
}


