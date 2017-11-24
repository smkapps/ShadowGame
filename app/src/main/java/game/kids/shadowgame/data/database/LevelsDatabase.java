package game.kids.shadowgame.data.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import game.kids.shadowgame.data.model.Level;

@Database(entities = {Level.class}, version = 1)
public abstract class LevelsDatabase extends RoomDatabase {
    private static LevelsDatabase INSTANCE;
    public abstract LevelDao levelDao();

    private static RoomDatabase.Callback rdc = new RoomDatabase.Callback(){
        public void onCreate (SupportSQLiteDatabase db){
            new DatabaseManager(INSTANCE).populateDb();
        }
    };

    public static LevelsDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), LevelsDatabase.class, "levels_db")
                            .addCallback(rdc)
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
