package com.example.uangkass

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper : SQLiteOpenHelper {

    companion object {
        val DBName = "millenialUangkasKotlin"
        val DBVersion = 1
        val tableName = "transaksi"
        val transaksiId = "transaksi_id"
        val status = "status"
        val jumlah = "jumlah"
        val keterangan = "keterangan"
        val tanggal = "tanggal"
    }

    private val createTable = "CREATE TABLE $tableName ($transaksiId INTEGER PRIMARY KEY AUTOINCREMENT " +
            ", $status TEXT, $jumlah TEXT, $keterangan TEXT, $tanggal DATETIME DEFAULT CURRENT DATE)"

    var context: Context? = null
    var db: SQLiteDatabase
    constructor(context: Context) : super (context, DBName, null, DBVersion) {
        this.context = context
        db = this.writableDatabase
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $tableName")
    }
        fun inserData(stts: String, jmlh: String, ket: String) : Long{
            val values = ContentValues()
            values.put(status, stts)
            values.put(jumlah, jmlh)
            values.put(keterangan, ket)

            val transaksi_id = db.insert(tableName, null, values)

            db.close()

            return transaksi_id
        }
}