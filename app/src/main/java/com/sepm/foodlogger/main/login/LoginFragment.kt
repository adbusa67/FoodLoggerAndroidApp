package com.gojek.gojekbeta.main.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gojek.gojekbeta.HOMEPAGE_HEADER
import com.gojek.gojekbeta.databinding.FragmentLoginBinding
import com.gojek.gojekbeta.home.HomeActivity1
import com.gojek.gojekbeta.main.MainActivity
import com.gojek.gojekbeta.main.MainContract
import com.gojek.gojekbeta.main.TOAST_TEXT

private const val ARG_PARAM1 = "param1"

class LoginFragment : Fragment(), LoginContract.View {

    private var param1: Welcome? = null
    private lateinit var binding: FragmentLoginBinding
    private lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(LayoutInflater.from(this.context))
        binding.header.text = param1?.header.orEmpty()

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter = LoginPresenter(this, LoginModel(context))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(activity, TOAST_TEXT, duration)
            toast.show()

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            presenter.saveData(email, password)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Welcome) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)
                }
            }
    }

    override fun openHomePage(email: String) {
        (activity as MainActivity).openHomePage(email)
    }
}
