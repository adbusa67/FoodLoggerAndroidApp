package com.gojek.gojekbeta.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.gojek.gojekbeta.HOMEPAGE_HEADER
import com.gojek.gojekbeta.R
import com.gojek.gojekbeta.databinding.ActivityHome1Binding
import com.gojek.gojekbeta.home.Dashboard.DashboardFragment
import com.gojek.gojekbeta.main.MainActivity

const val WELCOME = "Hello, "

class HomeActivity1 : AppCompatActivity(), HomeContract.View {

    private lateinit var binding: ActivityHome1Binding
    private lateinit var presenter: HomeContract.Presenter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHome1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = HomePresenter(this, HomeModel(this))
        binding.headerText.text = WELCOME + this.intent.extras?.get(HOMEPAGE_HEADER).toString()
        setFragment()

        binding.logout.setOnClickListener {
            presenter.logout()
        }
    }

    private fun setFragment() {
        val dashboardFragment: DashboardFragment = DashboardFragment.newInstance()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentRecycle, dashboardFragment)
        fragmentTransaction.commit()
    }

    override fun openLoginPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
