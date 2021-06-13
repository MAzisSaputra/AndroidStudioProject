package com.example.uangkass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    var status : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        radioStatus.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.radioMasuk -> status = "MASUK"
                R.id.radioKeluar -> status = "KELUAR"
            }
            Log.e("_logStatus", status);
        }

        buttonSimpan.setOnClickListener {
            if (status.isNullOrBlank() || editJumlah.text.isNullOrBlank() || editKeterangan.text.isNullOrBlank()) {
                Toast.makeText(applicationContext, "Isi data dengan benar",
                    Toast.LENGTH_SHORT).show()
            } else {
               var id = App.db!!.inserData(status, editJumlah.text.toString(), editKeterangan.text.toString() )

                Log.e("_logId", id.toString());
                if (id > 0){
                    Toast.makeText(applicationContext, "Transaksi berhasil disimpan",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

        supportActionBar!!.setTitle("Tambah baru")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
