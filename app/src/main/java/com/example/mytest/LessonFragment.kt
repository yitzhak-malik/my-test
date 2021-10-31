package com.example.mytest

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_LESSON = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LessonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LessonFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var lesson: Lesson? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            lesson = it.getSerializable(ARG_LESSON) as Lesson?

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_lesson, container, false)

        view.findViewById<TextView>(R.id.title).text = lesson?.title ?: ""
        lesson?.let { view.findViewById<ImageView>(R.id.image).setImageResource(it.imageRes) }
        view.findViewById<TextView>(R.id.subtitle).apply {
            text = lesson?.Subtitle ?: ""
            movementMethod = ScrollingMovementMethod()
        }
        view.findViewById<TextView>(R.id.decription).text = lesson?.Description ?: ""
        view.findViewById<ImageView>(R.id.arrow).setOnClickListener {
            parentFragmentManager.popBackStack()
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
         * @return A new instance of fragment LessonFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(lesson: Lesson) =
            LessonFragment().apply {
                arguments = Bundle().apply {

                    putSerializable(ARG_LESSON,lesson)
                }
            }
    }
}