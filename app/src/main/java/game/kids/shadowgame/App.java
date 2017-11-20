package game.kids.shadowgame;

import android.app.Application;

import game.kids.shadowgame.data.database.DatabaseInitializer;
import game.kids.shadowgame.data.database.LevelsDatabase;


public class App extends Application {
    private static LevelsDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = LevelsDatabase.getAppDatabase(getApplicationContext());
        DatabaseInitializer.populateAsync(database);
    }

    public static LevelsDatabase getAppDatabase(){
        return database;
    }
}
