package game.kids.shadowgame.data.database;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import game.kids.shadowgame.data.model.Level;

import static game.kids.shadowgame.GameConstants.DIFFICULTIES_COUNT;
import static game.kids.shadowgame.GameConstants.LEVELS_COUNT;


public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getSimpleName();

    public static void populateAsync(@NonNull final LevelsDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();

    }

    private static Level addLevel(final LevelsDatabase db, Level level) {
        db.levelDao().insertLevel(level);
        return level;
    }

    private static void populateData(LevelsDatabase db) {
        for (int i = 1; i <= LEVELS_COUNT; i++) {
            Level level = new Level();
            level.setLevelNumber(i);
            level.setDifficulty((i - 1) / (DIFFICULTIES_COUNT - 1));
            level.setComplete(false);
            level.setOpen(true);
            addLevel(db, level);
        }
        List<Level> levels = db.levelDao().getAllLevels();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + levels.size());

    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final LevelsDatabase mDb;

        PopulateDbAsync(LevelsDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            if (mDb.levelDao().getAllLevels().size() == 0)
                populateData(mDb);
            return null;
        }

    }
}
