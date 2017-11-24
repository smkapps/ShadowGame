package game.kids.shadowgame;

import android.app.Application;
import android.provider.ContactsContract;

import game.kids.shadowgame.data.database.DatabaseManager;
import game.kids.shadowgame.data.database.LevelsDatabase;


public class App extends Application {
    private static LevelsDatabase database;
    private static DatabaseManager databaseManager;

    @Override
    public void onCreate() {
        super.onCreate();
        database = LevelsDatabase.getAppDatabase(getApplicationContext());
        databaseManager = new DatabaseManager(database);

    }

//    public static LevelsDatabase getAppDatabase(){
//        return database;
//    }

    public static DatabaseManager getDatabaseManager(){
        return databaseManager;
    }
}
