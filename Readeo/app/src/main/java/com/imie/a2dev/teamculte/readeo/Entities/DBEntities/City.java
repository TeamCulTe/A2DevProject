package com.imie.a2dev.teamculte.readeo.Entities.DBEntities;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.imie.a2dev.teamculte.readeo.DBManagers.DBManager;
import com.imie.a2dev.teamculte.readeo.DBSchemas.CityDBSchema;

/**
 * Final class representing a city from the application.
 */
public final class City extends DBEntity {
    /**
     * Stores the city name.
     */
    private String name;

    /**
     * City's default constructor.
     */
    public City() {
        super();
    }

    /**
     * City's full filled constructor providing all its attributes values.
     * @param id The id to set.
     * @param name The name to set.
     */
    public City(int id, String name) {
        super(id);

        this.name = name;
    }

    /**
     * City's full filled constructor providing all its attributes values from the result of a database query.
     * @param result The result of the query.
     */
    public City(Cursor result) {
        this.init(result, true);
    }

    /**
     * City's full filled constructor providing all its attributes values from the result of a database query,
     * closes the cursor if close is true.
     * @param result The result of the query.
     * @param close Defines if the cursor should be closed or not.
     */
    public City(Cursor result, boolean close) {
        this.init(result, false);
    }

    /**
     * Gets the name attribute.
     * @return The String value of name attribute.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name attribute.
     * @param newName The new String value to set.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    protected void init(Cursor result, boolean close) {
        try {
            if (result.getPosition() == -1) {
                result.moveToNext();
            }

            this.id = result.getInt(result.getColumnIndexOrThrow(CityDBSchema.ID));
            this.name = result.getString(result.getColumnIndexOrThrow(CityDBSchema.NAME));

            if (close) {
                result.close();
            }
        } catch (SQLiteException e) {
            Log.e(DBManager.SQLITE_TAG, e.getMessage());
        }
    }
}
