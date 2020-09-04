package co.basic.androidjetpackskeleton.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.basic.androidjetpackskeleton.R

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
    }
}