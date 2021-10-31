package com.example.mytest

import android.content.res.AssetManager
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Type

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [mainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class mainFragment : Fragment(),TransactionInterface {
    // TODO: Rename and change types of parameters


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
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val lessons:String = resources.openRawResource(R.raw.udemycourses).bufferedReader().use { it.readText() }
        Log.d("log",lessons)
        val collectionType = object : TypeToken<ArrayList<Lesson>>() {}.type
        val list = Gson().fromJson<ArrayList<Lesson>>(lessons,collectionType)
        for (i in list.indices ){
          val  item =list[i]
            when(i){
                0 -> item.imageRes = R.drawable.image2
                1 -> item.imageRes = R.drawable.image6
                2 -> item.imageRes = R.drawable.image7
                3 -> item.imageRes = R.drawable.image8
                4 -> item.imageRes = R.drawable.image9

            }
        }
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(view.context)

        val adapter =  RecyclerviewAdapter(list,this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = layoutManager

        val shared = this.activity?.getSharedPreferences(SHARED, AppCompatActivity.MODE_PRIVATE)
        val userName =view.findViewById<TextView>(R.id.user_name)
        if (shared != null) {
           userName.text = shared.getString(USER_NAME, "hellow")
        }


        return view

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment mainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            mainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun transaction(
        fragment: Fragment,
        _id: Int,
        function: (() -> FragmentTransaction?)?
    ) {
        val id = R.id.main_activity
        super.transaction(fragment, id) { return@transaction parentFragmentManager.beginTransaction() }
    }
}