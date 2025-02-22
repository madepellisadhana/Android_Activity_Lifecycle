package com.humber.lab5

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View

import android.widget.Button
import android.widget.EditText
import android.view.View.OnClickListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.humber.lab5.model.LoginModel


class MainActivity : ComponentActivity(), View.OnClickListener {

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
        btnLogin?.let { button ->
            button.setOnClickListener(this)
        }

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
        val login_model: LoginModel? = intent.getParcelableExtra("login_view");

        txtLogin?.setText(login_model?.getLogin());

        }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.btn_login -> {

                val loginModel: LoginModel = LoginModel();
                loginModel.setLogin(txtLogin?.text.toString());

                loginModel.setOnline(true);

                val intent: Intent = Intent(this, LoginViewActivity::class.java);

                intent.putExtra("login_model", loginModel);
                startActivity(intent);


            }
        }
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


