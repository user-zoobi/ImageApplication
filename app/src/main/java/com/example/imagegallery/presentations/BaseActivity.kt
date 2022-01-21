package com.example.imagegallery.presentations

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagegallery.R
import com.example.imagegallery.databinding.ActivityBaseBinding
import com.example.imagegallery.network.response.Pixabay
import com.example.imagegallery.presentations.adapter.BaseAdapter
import com.example.imagegallery.presentations.fragments.BottomSheetFragment
import com.example.imagegallery.presentations.viewmodel.BaseFactory
import com.example.imagegallery.presentations.viewmodel.BaseViewModel
import com.example.imagegallery.extensions.Constants.ERROR
import com.example.imagegallery.extensions.Constants.LOADING
import com.example.imagegallery.network.response.Status
import kotlinx.android.synthetic.main.activity_base.*

class BaseActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBaseBinding
    private lateinit var viewModel: BaseViewModel
    private lateinit var factory: BaseFactory
    private lateinit var list: ArrayList<Pixabay.Hit>
    private lateinit var adapter: BaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_base)
        list = ArrayList()
        adapter = BaseAdapter(list, object : BaseAdapter.OnItemClickListener {
            override fun onItemClick(item: Pixabay.Hit) {
                val bottomSheet = BottomSheetFragment(item, object : BottomSheetFragment.KnowMoreWebVersion{

                    override fun knowMore(url: String) {
                        val imageUrl = Intent(Intent.ACTION_VIEW)
                        imageUrl.data = Uri.parse(url)
                        startActivity(imageUrl)
                    }

                    override fun shareNow(urlData:String) {

                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, urlData)
                            type = "text/plain"
                        }
                        val shareIntent = Intent.createChooser(sendIntent, null)
                        startActivity(shareIntent)

                    }

                })
                bottomSheet.show(supportFragmentManager,"BottomSheet")
            }

        })


        listRecyclerView.adapter = adapter
        listRecyclerView.layoutManager = GridLayoutManager(this,2)
        factory = BaseFactory()
        viewModel = ViewModelProvider(this,factory)[BaseViewModel::class.java]
        viewModel.getImages()

        viewModel.images.observe(this, Observer {
            when(it.status) {
                Status.LOADING-> {
                    Log.i(LOADING,"LOADING STEP")
                }
                Status.SUCCESS-> {
                    list = it.data?.hits as ArrayList<Pixabay.Hit>
                    adapter.addItems(list)
                }
                Status.ERROR-> {
                    Log.i(ERROR,"Error Step")
                }
            }
        })
    }
}