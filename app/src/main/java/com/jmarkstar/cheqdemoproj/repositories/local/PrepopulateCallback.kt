package com.jmarkstar.cheqdemoproj.repositories.local

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class PrepopulateCallback : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)


    }

    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)


    }
}