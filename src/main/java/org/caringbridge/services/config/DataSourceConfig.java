package org.caringbridge.services.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * Configuration class to enable the source of the data for our application
 * (MongoDB will be used for this app).
 * 
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
@Configuration
@EnableMongoRepositories
public class DataSourceConfig extends AbstractMongoConfiguration {

    /**
     * The port number where the mongo db instance is running.
     */
    private static final int MONGO_DB_PORT = 27017;

    /**
     * Returns the String database name for the application.
     * @return String with the value
     */
    @Override
    protected String getDatabaseName() {
	return "microservices";
    }
    
    /**
     * Returns the Mongo object to be configured in the app.
     * @return Mongo with the value
     * @throws Exception in case something bad happens
     */
    @Override
    public Mongo mongo() throws Exception {
	return null; //Not needed since we will override MongoDbFactory
    }
    
    /**
     * Returns the MongoDbFactory object that will be in charge of driving the 
     * connection objects for the MongoDb database in the app.
     * @return MongoDbFactory with the value
     * @throws Exception in case something bad happens
     */
    @Override
    public MongoDbFactory mongoDbFactory() throws Exception {
	MongoCredential credential = MongoCredential.createCredential("admin", "test", "admin".toCharArray());
	int port = MONGO_DB_PORT;
	ServerAddress seeds = new ServerAddress("server", port);
	MongoClient client = new MongoClient(seeds, Arrays.asList(credential));

	SimpleMongoDbFactory factory = new SimpleMongoDbFactory(client, getDatabaseName());
	return factory;
    }

}
