package com.generousstudio.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.generousstudio.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : ColorPickerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            adapter = ColorPickerAdapter(
                onClicked = { color, position, lastPosition ->
                    adapter.selectedColor = color
                    adapter.notifyItemChanged(position)
                    adapter.notifyItemChanged(lastPosition)
                }
            )
            adapter.submitList(listOf(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.GRAY))
            recyclerView.adapter = adapter
            recyclerView.setHasFixedSize(true)
        }

        setContentView(binding.root)
    }
}