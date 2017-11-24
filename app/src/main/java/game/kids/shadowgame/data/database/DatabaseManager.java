package game.kids.shadowgame.data.database;

import android.util.Log;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import game.kids.shadowgame.data.model.Level;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static game.kids.shadowgame.GameConstants.DIFFICULTIES_COUNT;
import static game.kids.shadowgame.GameConstants.LEVELS_COUNT;


public class DatabaseManager {
    private LevelsDatabase db;

    public DatabaseManager(LevelsDatabase db) {
        this.db = db;
    }

    public void populateDb() {
        final List<Level> levels = generateLevels();
        Single<List<Level>> observable = Single.just(levels);
        observable.observeOn(Schedulers.io())
                .subscribe(new Consumer<List<Level>>() {
                    @Override
                    public void accept(List<Level> levels) throws Exception {
                        db.levelDao().insertLevels(levels);

                    }
                });
    }

    public void getAllLevels() {
        final List<Level> levels = new ArrayList<>();
        Flowable<List<Level>> listFlowable = db.levelDao().getAllLevels();
        listFlowable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Level>>() {
                    @Override
                    public void accept(List<Level> levelsFromIO) throws Exception {
                        levels.addAll(levelsFromIO);
                        for (Level level1 : levels) {
                            Log.d("tag1", level1.getLevelNumber() + ", " + level1.getDifficulty() + " " + level1.isComplete() + " " + level1.isOpen());
                        }
                    }
                });

    }


    private List<Level> generateLevels() {
        final List<Level> levels = new ArrayList<>();
        for (int i = 1; i <= LEVELS_COUNT; i++) {
            Level level = new Level();
            level.setLevelNumber(i);
            level.setDifficulty((i - 1) / (DIFFICULTIES_COUNT - 1));
            level.setComplete(false);
            level.setOpen(true);
            levels.add(level);
        }
        return levels;
    }

}