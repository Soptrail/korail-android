package com.sopt.seminar9.korail.data.remote.dataadapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.seminar9.korail.R
import com.sopt.seminar9.korail.data.remote.model.response.Show_Train
import com.sopt.seminar9.korail.databinding.ItemShowTrainInfoBinding
import java.text.DecimalFormat

class TrainInfoAdapter(Item: List<Show_Train>, context: Context) : RecyclerView.Adapter<TrainInfoAdapter.TrainViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var trainList: List<Show_Train> = emptyList()
    lateinit var binding: ItemShowTrainInfoBinding
    private var selectedPosition = -1

    inner class TrainViewHolder(
        private var binding: ItemShowTrainInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        var isEnablecheck = true // 바인딩과 연결할 때 활용할 변수
        fun onBind(data: Show_Train) {
            binding.vh = this
            binding.showItemView.isSelected = (selectedPosition == absoluteAdapterPosition)
            binding.showItemView.isEnabled = (data.NormalPrice != "0") // 매진 아이템은 Enabled false 처리
            isEnablecheck = binding.showItemView.isEnabled
            if(data.SpecialPrice == "0"){
                binding.txtSpecialPrice.text = "-"
                binding.txtSpecialPrice.setBackgroundResource(R.drawable.item_bg_color_selector)
                binding.txtSpecialPrice.setTextColor(Color.BLACK)
            } else {
               binding.txtSpecialPrice.text= DecimalFormat("#,###").format(data.SpecialPrice.toInt()) + "₩"
            }
            binding.txtTrain.text = data.TrainName // 서버 값과 뷰 연결
            binding.txtTimeDepart.text = data.StartTime
            binding.txtTimeArrive.text = data.LastTime
            binding.txtPrice.text = if (data.NormalPrice == "0") { "   매진   " } else { DecimalFormat("#,###").format(data.NormalPrice.toInt()) + "₩" }

            binding.showItemView.setOnClickListener {
                if(binding.showItemView.isEnabled) {
                    if (selectedPosition == absoluteAdapterPosition) {
                        Log.d("tag", "fragment 전환")
                        // 동일한 아이템 두 번 클릭 시 fragment 전환 기능 필요
                    } else {
                        selectedPosition = absoluteAdapterPosition
                        notifyItemRangeChanged(0, itemCount)
                    }
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainViewHolder {
        binding = ItemShowTrainInfoBinding.inflate(inflater, parent, false)
        return TrainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainViewHolder, position: Int) {
        holder.onBind(trainList[position])
    }

    override fun getItemCount() = trainList.size

    fun setRepoList(list: List<Show_Train>) {
        this.trainList = list.toList() // 원본이 바뀌어도 문제가 생기지 않도록 "얇은 복사" 처리
        notifyItemRangeChanged(0, trainList.size)
    }
}