package com.example.practical_6_mad_041_5a3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var flag=1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var playpause: FloatingActionButton =findViewById(R.id.playpause)
        var stop: FloatingActionButton =findViewById(R.id.stop)
        playpause.setOnClickListener {
            playPauseMusic()
        }

        stop.setOnClickListener {
            stopMusic()
        }
    }

    fun playPauseMusic()
    {
        var playpause: FloatingActionButton =findViewById(R.id.playpause)


        if(flag==1)
        {
            playpause.setImageResource(R.drawable.baseline_pause_24)
            flag=2
        }
        else
        {
            playpause.setImageResource(R.drawable.baseline_play_arrow_24)
            flag=1
        }
        Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY, MyService.PLAYERVALUE).apply {
            startService(this)
        }
    }

    fun stopMusic()
    {
        var playpause: FloatingActionButton =findViewById(R.id.playpause)
        playpause.setImageResource(R.drawable.baseline_play_arrow_24)
        flag=1
        Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY, MyService.PLAYERVALUE).apply { stopService(this)
        }

    }
}