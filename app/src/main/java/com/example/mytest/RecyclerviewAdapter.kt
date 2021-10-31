package com.example.mytest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewAdapter
     (private val lessonList: List<Lesson>,val transactionInterface: TransactionInterface) :
        RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): RecyclerviewAdapter.ViewHolder {

            val view = LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.recycler_lesson_item,
                    parent, false
                )

            return ViewHolder(view)
        }

        override fun onBindViewHolder(
            holder: RecyclerviewAdapter.ViewHolder,
            position: Int
        ) {

            holder.viewHolder(lessonList[position])

        }

        override fun getItemCount(): Int {

            return lessonList.size
        }


        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


            @SuppressLint("ResourceType")
            fun viewHolder(item: Lesson) {
              val recyclerviewLessonItem =itemView.findViewById<ConstraintLayout>(R.id.recyclerview_lesson_item)
              val title = itemView.findViewById<TextView>(R.id.title)
              val imageView = itemView.findViewById<ImageView>(R.id.image)
              val ratingBar = itemView.findViewById<RatingBar>(R.id.ratingBar1)

            title.text = item.title
            imageView.setImageResource(item.imageRes)
            ratingBar.rating = item.stars.toFloat()
                recyclerviewLessonItem.setOnClickListener {
                    transactionInterface.transaction(LessonFragment.newInstance(item),555,null)
                }
            }
        }


     }