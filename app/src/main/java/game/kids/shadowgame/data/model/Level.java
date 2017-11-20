package game.kids.shadowgame.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "levels")
public class Level {

    @PrimaryKey
    @ColumnInfo(name = "levelNumber")
    private int levelNumber;

    @ColumnInfo(name = "levelDifficulty")
    private int difficulty;

    @ColumnInfo(name = "isLevelComplete")
    private boolean isComplete;

    @ColumnInfo(name = "isLevelOpen")
    private boolean isOpen;

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
