package game.kids.shadowgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import game.kids.shadowgame.data.database.LevelsDatabase;
import game.kids.shadowgame.data.model.Level;

public class StartActivity extends AppCompatActivity {
    List<Level> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        App.getDatabaseManager().getAllLevels();
    }

    @Override
    protected void onDestroy() {
        LevelsDatabase.destroyInstance();
        super.onDestroy();
    }
}