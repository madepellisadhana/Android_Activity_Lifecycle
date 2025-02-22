package com.humber.lab5

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.View.*
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.humber.lab5.model.LoginModel

class LoginViewActivity : ComponentActivity(), OnClickListener {

    private var login_view: TextView? = null;
    private var online_view:TextView? = null;
    private var back_btn: Button? = null;
    private var profile_btn: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login_view)
        Log.d("LoginViewActivity", "onCreate");
        login_view = findViewById(R.id.login_view);
        online_view = findViewById(R.id.online_view);
        back_btn = findViewById(R.id.back_btn);
        back_btn?.let {button -> button.setOnClickListener(this) }
        profile_btn = findViewById(R.id.profile_btn);





    }

    override fun onStart() {
        super.onStart()
        Log.d("LoginViewActivityActivity", "onStart");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LoginViewActivityActivity", "onRestart");
    }

    override fun onResume() {
        super.onResume()
        Log.d("LoginViewActivityActivity", "onResume");
        var model =  intent.getParcelableExtra<LoginModel>("login_model");
        login_view?.setText(model?.getLogin());
        var online = when(model?.getOnline())
        {
            true -> "Online"
            false -> "Offline"
            else -> "Unknown"
        }
        online_view?.setText(online);
    }

    override fun onPause() {
        super.onPause()
        Log.d("LoginViewActivityActivity", "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.d("LoginViewActivityActivity", "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LoginViewActivityActivity", "onDestroy");
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("LoginViewActivityActivity", "onSaveInstanceState");
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d("LoginViewActivityActivity", "onRestoreState");
    }

    override fun onClick(p0: View?) {

        when(p0?.id)
        {
            R.id.back_btn -> {
                val model: LoginModel = LoginModel();
                model.setLogin(login_view?.text.toString())
                val online = when(online_view?.text.toString())
                {
                    "Online" -> true
                    "Offline" -> false
                    else -> false
                }
                model.setOnline(online);
                val intent: Intent = Intent(this,MainActivity::class.java);
                intent.putExtra("login_view", model);
                startActivity(intent);

            }
            R.id.profile_btn ->
            {

            }
        }

    }
}