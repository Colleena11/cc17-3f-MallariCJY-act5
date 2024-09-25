package com.example.artapp
import com.example.artspaceapp.R


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val images = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5
    )

    private val titles = arrayOf(
        "The Starry Night (June 1889)",
        "Poets And Lovers (1888 - 1990)",
        "The Poet (1888)",
        "Sunflowers (1888)",
        "Wheatfield With Crows (1890)"
    )

    private val descriptions = arrayOf(
        "The Dutch Post-Impressionist traveled to the south of France.",
        "Faces and features are obscured.",
        "We want to show the artist rather than the tortured soul.",
        "Getting the three paintings together was no small feat.",
        "A dramatic, cloudy sky filled with crows over wheat field."
    )

    private val authors = arrayOf(
        "Vincent Van Gogh",
        "Vincent Van Gogh",
        "Vincent Van Gogh",
        "Vincent Van Gogh",
        "Vincent Van Gogh"
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView)
        val titleText: TextView = findViewById(R.id.titleText)
        val descriptionText: TextView = findViewById(R.id.descriptionText)
        val authorText: TextView = findViewById(R.id.authorText)
        val previousButton: Button = findViewById(R.id.previous_button)
        val nextButton: Button = findViewById(R.id.next_button)

        updateUI(imageView, titleText, descriptionText, authorText)

        previousButton.setOnClickListener {
            currentIndex = if (currentIndex > 0) currentIndex - 1 else images.size - 1
            updateUI(imageView, titleText, descriptionText, authorText)
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % images.size
            updateUI(imageView, titleText, descriptionText, authorText)
        }
    }

    private fun updateUI(imageView: ImageView, titleText: TextView, descriptionText: TextView, authorText: TextView) {
        imageView.setImageResource(images[currentIndex])
        titleText.text = titles[currentIndex]
        descriptionText.text = descriptions[currentIndex]
        authorText.text = authors[currentIndex]
    }
}