package com.example.mytest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(), TransactionInterface {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val userName = view.findViewById<EditText>(R.id.user_name)
        val password = view.findViewById<EditText>(R.id.password)
        val progress = view.findViewById<ProgressBar>(R.id.progress_circular)
        val loginButton = view.findViewById<TextView>(R.id.login_button)
        val shared = this.activity?.getSharedPreferences(SHARED, AppCompatActivity.MODE_PRIVATE)?.edit()
        loginButton.setOnClickListener {
            if (userName.text.isBlank()){
                userName.requestFocus()
            }
            else if (password.text.isEmpty())
                password.requestFocus()
            else{
                if (shared != null) {
                    shared.putString(USER_NAME,userName.text.toString()).apply()

                    progress.visibility =View.VISIBLE
                    Handler(Looper.getMainLooper()).postDelayed({
                    transaction(mainFragment.newInstance(),R.id.main_activity) { return@transaction parentFragmentManager.beginTransaction() }
                    },3000)
                }

            }
        }
        return view
    }


    companion object {



        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}