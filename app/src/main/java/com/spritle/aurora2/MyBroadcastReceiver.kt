package com.spritle.aurora2
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat


class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent){
        Log.d("intent" , intent.toString())
          if (intent !== null) {
            Log.d("inside func", "broadcast")
            val barcode = intent.getStringExtra("SCAN_BARCODE1")
           val barcodeType = intent.getIntExtra("SCAN_BARCODE_TYPE", -1)

            if (barcode != null) {
                Log.d("barcode" , barcode)
            } else {
                Toast.makeText(context, "Barcode Not getting.", Toast.LENGTH_LONG).show()

            }
        } else {
            Toast.makeText(context, "Scan Failed", Toast.LENGTH_LONG).show()

        }
    }

}
