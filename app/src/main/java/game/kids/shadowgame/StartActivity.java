package game.kids.shadowgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import game.kids.shadowgame.data.database.DatabaseInitializer;
import game.kids.shadowgame.data.database.LevelsDatabase;
import game.kids.shadowgame.data.model.Level;

public class StartActivity extends AppCompatActivity {
    private List<Level> levels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new Thread(new Runnable() {
            @Override
            public void run() {
                levels = App.getAppDatabase().levelDao().getAllLevels();
                levels.get(3).setComplete(false);
                for (Level level : levels) {
                    Log.d("tag", level.getLevelNumber() + ", " + level.getDifficulty() + " " + level.isComplete() + " " + level.isOpen());
                }


                levels.get(3).setComplete(true);
                App.getAppDatabase().levelDao().updateLevel(levels.get(3));


                for (Level level : levels) {
                    Log.d("tag", level.getLevelNumber() + ", " + level.getDifficulty() + " " + level.isComplete() + " " + level.isOpen());
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        LevelsDatabase.destroyInstance();
        super.onDestroy();
    }
}
