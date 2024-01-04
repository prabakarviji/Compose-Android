package com.spritle.aurora2

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.ui.res.stringResource
import com.spritle.aurora2.ui.theme.Aurora2Theme
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
//import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.RECEIVER_EXPORTED
import androidx.core.content.ContextCompat.RECEIVER_NOT_EXPORTED
import androidx.compose.ui.platform.LocalContext as LocalContext
import androidx.core.content.ContextCompat.registerReceiver as registerReceiver

//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


@Composable
fun HomeScreen() {
val context = LocalContext.current
   DisposableEffect(context) {
       val br: BroadcastReceiver = MyBroadcastReceiver()
       val filter = IntentFilter("nlscan.action.SCANNER_RESULT")
       val listenToBroadcastsFromOtherApps = false
        Log.d("filter", filter.toString())
       val receiverFlags = if (listenToBroadcastsFromOtherApps) {
           RECEIVER_EXPORTED
       } else {
           RECEIVER_NOT_EXPORTED
       }
       Log.d("receiverFlags", receiverFlags.toString())
       registerReceiver(context, br, filter, receiverFlags)
       // Unregister the receiver when the effect is disposed (composable is removed)
        onDispose {
            Log.d("dispose", "dispose")
            context.unregisterReceiver(br)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(70.dp)
    ) {
        Button(
            onClick = {
                val intent = Intent("nlscan.action.SCANNER_TRIG")
                intent.putExtra("SCAN_TIMEOUT", 10)
                intent.putExtra("SCAN_TYPE", 1)
                context.sendBroadcast(intent)
                Log.d("000", intent.toString())
                },

            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),

        ) {
            Text(
                text = "Open Scanner"
            )
        }
    }





}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
     Aurora2Theme {
        Surface{
            HomeScreen()
        }
    }
}


