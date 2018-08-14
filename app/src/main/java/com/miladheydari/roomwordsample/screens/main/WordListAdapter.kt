package com.miladheydari.roomwordsample.screens.main

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.miladheydari.roomwordsample.R
import com.miladheydari.roomwordsample.db.entities.Word

class WordListAdapter(private val context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mWords: List<Word>? = null // Cached copy of words

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        if (mWords != null) {
            val word = mWords!![position]


            holder.wordItemView.text = "${word.id} - ${word.name}"
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.text = "No Word"
        }
    }

    internal fun setWords(words: List<Word>) {
        mWords = words
        notifyDataSetChanged()
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    override fun getItemCount(): Int {
        return if (mWords != null)
            mWords!!.size
        else
            0
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var wordItemView: TextView = itemView.findViewById(R.id.textView)

    }
}