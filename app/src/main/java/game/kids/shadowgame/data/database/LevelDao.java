package game.kids.shadowgame.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import game.kids.shadowgame.data.model.Level;

@Dao
public interface LevelDao {

    @Query("SELECT * FROM levels")
    List<Level> getAllLevels();

    @Query("SELECT * FROM levels WHERE levelDifficulty = :levelDifficulty")
    List<Level> getLevelsByDifficulty(int levelDifficulty);

    @Query("SELECT * FROM levels WHERE levelNumber = :levelNumber")
    Level getLevel(int levelNumber);

    @Insert
    void insertLevels(Level... levels);

    @Insert
    void insertLevel(Level level);

    @Update
    void updateLevel(Level level);


}
