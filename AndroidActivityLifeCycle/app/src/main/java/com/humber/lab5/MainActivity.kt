package com.humber.lab5

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {

    private var txtLogin: EditText? = null;
    private var txtPassword: EditText? = null;
    private var btnLogin: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Main Activity", "onCreate");
        setContentView(R.layout.activity_main);
        txtLogin = findViewById(R.id.login);
        txtPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.btn_login);

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Main Activity", "onRestart");

    }

    override fun onStart() {
        super.onStart()
        Log.d("Main Activity", "onStart");

    }

    override fun onResume() {
        super.onResume()
        Log.d("Main Activity", "onResume");

    }

    override fun onPause() {
        super.onPause()
        Log.d("Main Activity", "onPause");

    }

    override fun onStop() {
        super.onStop()
        Log.d("Main Activity", "onStop");

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main Activity", "onDestroy");

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("Main Activity", "onConfigurationChanged");
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("Main Activity", "onSaveInstanceState");
        outState.putString("login", txtLogin?.text.toString());
        outState.putString("password", txtPassword?.text.toString());
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d("Main Activity", "onResumeInstanceState");
        var login = savedInstanceState?.getString("login");
        var password = savedInstanceState?.getString("password");
        txtLogin?.setText(login);
        txtPassword?.setText(password);
    }



}