package game.kids.shadowgame.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import game.kids.shadowgame.data.model.Level;

@Database(entities = {Level.class}, version = 1)
public abstract class LevelsDatabase extends RoomDatabase {
    private static LevelsDatabase INSTANCE;
    public abstract LevelDao levelDao();

    public static LevelsDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), LevelsDatabase.class, "levels_db")
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
