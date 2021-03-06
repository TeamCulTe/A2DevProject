package com.imie.a2dev.teamculte.readeo.Providers;

import android.net.Uri;

import com.imie.a2dev.teamculte.readeo.DBManagers.AuthorDBManager;

import static com.imie.a2dev.teamculte.readeo.DBSchemas.AuthorDBSchema.TABLE;

/**
 * Content provider used to access to the authors.
 */
public final class AuthorContentProvider extends ReadeoContentProvider {
    /**
     * Stores the content provider's uri.
     */
    public static final Uri URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE);

    @Override
    public boolean onCreate() {
        this.manager = new AuthorDBManager(this.getContext());
        this.table = TABLE;

        return true;
    }
}
