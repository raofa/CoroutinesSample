package com.raofa.coroutinessample.ui.area

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.raofa.coroutinessample.R
import com.raofa.coroutinessample.data.PlaceRepository
import com.raofa.coroutinessample.data.net.NetWorkManger
import kotlinx.android.synthetic.main.choose_area_fragment.*

class ChooseAreaFragment : Fragment() {

    private lateinit var adapter: PlaceAdapter
    private val viewModel by lazy{
        ViewModelProvider(this,ChooseAreaModelFactory(PlaceRepository.getInstance( NetWorkManger.getInstance()))).get(ChooseAreaViewModel::class.java)
    }
    private var progressDialog: ProgressDialog? = null
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.choose_area_fragment, container, false)
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManger = LinearLayoutManager(activity)
        recycleView.layoutManager = layoutManger
        adapter = PlaceAdapter(viewModel.placeList)
        recycleView.adapter = adapter
        observe()
        
        search_info.addTextChangedListener { editable -> 
            val content = editable.toString()
            if (content.isNotEmpty()){
                viewModel.searchPlace(content)
                bgImg.visibility = View.GONE
                recycleView.visibility = View.VISIBLE
            }else {
                bgImg.visibility = View.VISIBLE
                recycleView.visibility = View.GONE
                viewModel.placeList.clear()
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun observe() {

        viewModel.dataChanged.observe(viewLifecycleOwner, Observer {
            adapter.notifyDataSetChanged()
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            if (isLoading) showProgressDialog()
            else closeProgressDialog()
        })
        
    }

    /**
     * 显示进度对话框
     */
    private fun showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(activity)
            progressDialog?.setMessage("正在加载...")
            progressDialog?.setCanceledOnTouchOutside(false)
        }
        progressDialog?.show()
    }

    /**
     * 关闭进度对话框
     */
    private fun closeProgressDialog() {
        progressDialog?.dismiss()
    }
}
