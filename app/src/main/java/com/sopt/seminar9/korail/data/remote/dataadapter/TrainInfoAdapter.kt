package com.sopt.seminar9.korail.data.remote.dataadapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.seminar9.korail.R
import com.sopt.seminar9.korail.data.remote.model.response.Show_Train
import com.sopt.seminar9.korail.databinding.ItemShowTrainInfoBinding
import java.text.DecimalFormat
import kotlin.math.abs


class TrainInfoAdapter(Item: List<Show_Train>, context: Context) : RecyclerView.Adapter<TrainInfoAdapter.TrainViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var trainList: List<Show_Train> = emptyList()
    lateinit var binding: ItemShowTrainInfoBinding
    private var selectedPosition = -1
    private var nextflag = 0

    inner class TrainViewHolder(
        private var binding: ItemShowTrainInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun onBind(data: Show_Train) {
            binding.txtTrain.text = data.TrainName
            binding.txtTimeDepart.text = data.StartTime
            binding.txtTimeArrive.text = data.LastTime
/*            if(data.NormalPrice == "0"){ // 매진 상태 감지 시 뷰 설정 변경
                binding.txtTrain.setTextColor(R.color.gray_2_8A8A8A)
                binding.txtTimeDepart.setTextColor(R.color.gray_2_8A8A8A)
                binding.txtTimeArrive.setTextColor(R.color.gray_2_8A8A8A)
                binding.txtPrice.setBackgroundResource(R.drawable.bg_price_button)
            }*/
            binding.txtPrice.text = if (data.NormalPrice == "0") { "   매진   " } else { DecimalFormat("#,###").format(data.NormalPrice.toInt()) + "₩" }
            if(data.SpecialPrice == "0"){
                binding.txtSpecialPrice.text = "-"
                binding.txtSpecialPrice.setBackgroundResource(R.drawable.item_bg_color_selector)
                binding.txtSpecialPrice.setTextColor(Color.BLACK)
            } else {
               binding.txtSpecialPrice.text= DecimalFormat("#,###").format(data.SpecialPrice.toInt()) + "₩"
            }
            binding.showItemView.isSelected = (selectedPosition == absoluteAdapterPosition)
            binding.showItemView.isEnabled = (data.NormalPrice != "0") // 매진 아이템은 Enabled false로 구별

            binding.showItemView.setOnClickListener {
                if(binding.showItemView.isEnabled) {
                    if (selectedPosition == absoluteAdapterPosition) {
                        Log.d("tag", "fragment 전환")
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