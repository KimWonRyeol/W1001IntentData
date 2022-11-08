package kr.ac.kumoh.s20200252.w1001intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import kr.ac.kumoh.s20200252.w1001intentdata.databinding.ActivityImageBinding


class ImageActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityImageBinding
    private var image: String? = null

    companion object{
        const val imageName = "image"
        const val resultName = "result"

        const val LIKE = 10
        const val DISLIKE = 20
        const val NONE = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toast.makeText(this, intent.getStringExtra("image",),Toast.LENGTH_SHORT).show()
        image = intent.getStringExtra(MainActivity.keyName)
        val res = when(image)
        {
            "gundam" -> R.drawable.images1
            "zaku" -> R.drawable.images
            else -> R.drawable.ic_launcher_foreground
        }
        binding.imgGundam.setImageResource(res)

        binding.btnDislike.setOnClickListener(this)
        binding.btnLike.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        val value = when(v?.id){
            binding.btnLike.id -> LIKE
            binding.btnDislike.id -> DISLIKE
            else -> NONE
        }
        intent.putExtra(imageName, image)
        intent.putExtra(resultName, value)
        setResult(RESULT_OK, intent)
        finish()
    }
}