package com.generousstudio.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.generousstudio.myapplication.databinding.ColorItemBinding

class ColorPickerAdapter(private val onClicked: (Int, Int, Int) -> Unit) : ListAdapter<Int, ColorPickerAdapter.ColorPickerViewHolder>(ColorPickerDiffCallback) {

    var selectedColor: Int = Color.RED
    var lastSelectedItemPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorPickerViewHolder {
        return ColorPickerViewHolder(ColorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ColorPickerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ColorPickerViewHolder(private val binding: ColorItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(color: Int) {
            with(binding) {
                colorItemCard.setCardBackgroundColor(color)
                itemView.setOnClickListener {
                    onClicked(color, adapterPosition, lastSelectedItemPosition)
                    lastSelectedItemPosition = adapterPosition
                }
                colorItemImage.visibility = if (color == selectedColor) {
                    VISIBLE
                } else {
                    GONE
                }
            }
        }
    }

    object ColorPickerDiffCallback : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }

}