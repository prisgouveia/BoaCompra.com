/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author NandaPC
 */
public class ConexaoMongo {
    
    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DB_NAME = "bdnc-loja";

    private static ConexaoMongo uniqInstance;
    private static int mongoInstance = 1;

    private MongoClient mongo;
    private MongoDatabase db;

    private ConexaoMongo() {
    }

    //uma unica instancia
    public static synchronized ConexaoMongo getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new ConexaoMongo();
        }
        return uniqInstance;
    }

    //unico objeto mongo
    public MongoDatabase getDB() {
        if (mongo == null) {
            mongo = new MongoClient(HOST, PORT);
            db = mongo.getDatabase(DB_NAME);
            System.out.println("Mongo instance equals :> " + mongoInstance++);
        }
        return db;
    }
    
}
