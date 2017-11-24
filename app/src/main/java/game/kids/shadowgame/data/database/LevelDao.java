package game.kids.shadowgame.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


import game.kids.shadowgame.data.model.Level;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface LevelDao {

    @Query("SELECT * FROM levels")
    Flowable<List<Level>> getAllLevels();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLevels(List<Level> levels);

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertLevel(Level level);
//
//    @Query("SELECT * FROM levels WHERE levelDifficulty = :levelDifficulty")
//    List<Level> getLevelsByDifficulty(int levelDifficulty);
//
//    @Query("SELECT * FROM levels WHERE levelNumber = :levelNumber")
//    Single<Level> getLevel(int levelNumber);
}
