package org.caringbridge.services.config;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.mongo.tests.MongodForTestsFactory;

/**
 * Configuration class to enable the source of the data for our application
 * (MongoDB will be used for this app).
 * 
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
@Configuration
@EnableMongoRepositories
@Profile("integration-tests2")
public class DataSourceConfigTest extends DataSourceConfig {

    @Override
    public MongoDbFactory mongoDbFactory() throws Exception {
	
//	MongodStarter starter = MongodStarter.getDefaultInstance();
//	IMongodConfig config = new MongodConfigBuilder().version(Version.Main.V3_1).net(new Net(12345, Network.localhostIsIPv6()))
//	.build();
	MongodForTestsFactory factory = MongodForTestsFactory.with(Version.Main.V3_1);
	MongoClient client = factory.newMongo();
	DB db = client.getDB("test-" + UUID.randomUUID());
	DBCollection col = db.createCollection(super.getDatabaseName(), new BasicDBObject());
	System.out.println("messages collection was created in test database" + col);

	return new SimpleMongoDbFactory(client, super.getDatabaseName());
    }

}
