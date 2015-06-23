package com.possiblelabs.contentprovidercursortest;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;

public class ContactListActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private ContactListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new ContactListAdapter(this, R.layout.list_item, null, 0);
        setListAdapter(mAdapter);

        getLoaderManager().initLoader(0, null, this);

    }

    static final String[] CONTACTS_ROWS = new String[]{Contacts._ID, Contacts.DISPLAY_NAME, Contacts.PHOTO_THUMBNAIL_URI};

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String select = String.format("((%s NOTNULL) AND (%s != '') AND ( %S != 1))", Contacts.DISPLAY_NAME, Contacts.DISPLAY_NAME, Contacts.STARRED);
        String sortOrder = Contacts._ID + " ASC";
        return new CursorLoader(this, Contacts.CONTENT_URI, CONTACTS_ROWS, select, null, sortOrder);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
