package com.gojek.gojekbeta.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.gojek.gojekbeta.*
import com.gojek.gojekbeta.databinding.ActivityMainBinding
import com.gojek.gojekbeta.home.HomeActivity1
import com.gojek.gojekbeta.main.login.LoginFragment
import com.gojek.gojekbeta.main.login.Welcome

const val TOAST_TEXT = "Logging In..."
const val HEADER = "Welcome"
const val DESCRIPTION = "This is the description"

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this, MainModel(this))
        presenter.loginCredentials()
    }

    override fun openHomePage(email: String) {
        val intent = Intent(this, HomeActivity1::class.java)
        intent.putExtra(HOMEPAGE_HEADER, email)
        startActivity(intent)
        finish()
    }

    override fun loadLoginFragment() {
        val welcome = Welcome(HEADER, DESCRIPTION)
        val fragment: LoginFragment = LoginFragment.newInstance(welcome)
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.dynamic_welcome, fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    override fun onStart() {
        Log.d("MainActivity", "On start")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity", "On resume")
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "On Destroy")
    }
}
