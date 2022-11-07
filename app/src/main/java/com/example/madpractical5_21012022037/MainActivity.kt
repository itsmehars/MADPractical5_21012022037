package com.example.madpractical5_21012022037

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPlay: FloatingActionButton =findViewById(R.id.btn_play)
        val btnStop:FloatingActionButton=findViewById(R.id.btn_stop)
        val btnNext:FloatingActionButton=findViewById(R.id.btn_next)
        val btnPrevious:FloatingActionButton=findViewById(R.id.btn_previous)

        val txtSong: TextView =findViewById(R.id.song_text)
        txtSong.text="Pause song"
        var i=0;
        btnPlay.setOnClickListener {
            txtSong.text="Now Song Is Playing"
            play()
            if(i==0)
            {
                btnPlay.setImageResource(android.R.drawable.ic_media_pause)
                i=1
            }
            else{
                btnPlay.setImageResource(android.R.drawable.ic_media_play)
                i=0
            }

        }
        btnStop.setOnClickListener {
            txtSong.text="Pause song"
            stop()
            if(i==1)
            {
                btnPlay.setImageResource(android.R.drawable.ic_media_play)
                i=0
            }
        }


    }
    fun play()
    {
        Intent(applicationContext,MyService::class.java).putExtra(MyService.DATA_KEY,MyService.DATA_VALUE).apply {
            startService(this)
        }
    }
    fun stop()
    {
        Intent(applicationContext,MyService::class.java).apply {
            stopService(this)
        }
    }
}