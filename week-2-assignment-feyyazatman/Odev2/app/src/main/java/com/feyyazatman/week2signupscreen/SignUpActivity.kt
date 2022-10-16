package com.feyyazatman.week2signupscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView

class SignUpActivity : AppCompatActivity() {
    private var mIsShowPassSu = false // password icon durumunu tutar.
    private lateinit var etSuPass : EditText
    private lateinit var ivSuToggleButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // findViewById ile xml'deki componentlere ulasirim
        etSuPass = findViewById(R.id.etSuPassword)
        ivSuToggleButton = findViewById(R.id.ivSuToggleButton)

        val backButton = findViewById<ImageButton>(R.id.btn_ic_back)

        // back butonuna bastığı zaman login sayfasına gider
        backButton.setOnClickListener {
            val backNavIntent = Intent(this,LoginActivity::class.java) // intent oluşturup parametre loginactivty class verdim
            startActivity(backNavIntent) // intent başlatıldı.
        }

        // icon' a tıkladığında showPassword fonk. çalışır
        ivSuToggleButton.setOnClickListener {
            mIsShowPassSu = !mIsShowPassSu // icon durumu her tıklandığında değişir
            showPassword(mIsShowPassSu)

        }

    }

    // password görünümü kontrol etmek için fonk.
    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // password görünür olur ve icon degisir
            etSuPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivSuToggleButton.setImageResource(R.drawable.ic_visibility_off)
        } else {
            // password görünüm gizlenir ve icon degisir
            etSuPass.transformationMethod = PasswordTransformationMethod.getInstance()
            ivSuToggleButton.setImageResource(R.drawable.ic_visibility)
        }
        // cursor'ı edittext in sonuna koyar
        etSuPass.setSelection(etSuPass.text.toString().length)
    }
}