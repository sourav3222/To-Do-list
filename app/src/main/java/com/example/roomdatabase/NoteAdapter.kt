package com.example.roomdatabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.roomdatabase.databinding.ItemDesignBinding

class NoteAdapter:ListAdapter<Note,NoteviewHolder>(comperator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteviewHolder {

        return NoteviewHolder(ItemDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NoteviewHolder, position: Int) {

        getItem(position).let {
            holder.binding.apply {
                notetitle.text = it.titel
                date.text = it.date
                time.text = it.time

            }
        }
    }
    companion object {
        val comperator = object : DiffUtil.ItemCallback<Note>(){
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
}