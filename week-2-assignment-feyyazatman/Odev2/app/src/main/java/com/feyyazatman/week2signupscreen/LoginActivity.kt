package com.feyyazatman.week2signupscreen

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    private var mIsShowPass = false // password icon durumunu tutar.
    private lateinit var etPass :EditText
    private lateinit var ivToggleButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // findViewById ile xml'deki componentlere ulasirim
        etPass = findViewById(R.id.etPassword)
        ivToggleButton = findViewById(R.id.ivToggleButton)

        val signUpButton = findViewById<Button>(R.id.btn_sign_up)

        // signUp butonuna bastığı zaman signUp sayfasına gider
        signUpButton.setOnClickListener {
            val forwardNavIntent = Intent(this, SignUpActivity::class.java) // intent oluşturup parametre signupactivty class verdim
            startActivity(forwardNavIntent) // intent başlatıldı.
        }

        // icon' a tıkladığında showPassword fonk. çalışır
        ivToggleButton.setOnClickListener{
            mIsShowPass = !mIsShowPass // icon durumu her tıklandığında değişir
            showPassword(mIsShowPass)
        }
    }

    // password görünümü kontrol etmek için fonk.
    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // password görünür olur ve icon degisir
            etPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivToggleButton.setImageResource(R.drawable.ic_visibility_off)
        } else {
            // password görünüm gizlenir ve icon degisir
            etPass.transformationMethod = PasswordTransformationMethod.getInstance()
            ivToggleButton.setImageResource(R.drawable.ic_visibility)
        }
        // cursor'ı edittext in sonuna koyar
        etPass.setSelection(etPass.text.toString().length)
    }
}


