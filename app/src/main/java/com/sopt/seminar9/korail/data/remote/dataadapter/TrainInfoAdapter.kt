package com.sopt.seminar9.korail.data.remote.dataadapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        fun onBind(data: Show_Train) {
            binding.txtTrain.text = data.TrainName
            binding.txtTimeDepart.text = data.StartTime
            binding.txtTimeArrive.text = data.LastTime
            binding.txtPrice.text = if (data.NormalPrice == "0") {
                "   매진   "
            } else {
                DecimalFormat("#,###").format(data.NormalPrice.toInt()) + "₩"
            }
            binding.txtSpecialPrice.text = if (data.SpecialPrice == "0") {
                "-"
            } else {
                DecimalFormat("#,###").format(data.SpecialPrice.toInt()) + "₩"
            }
            binding.showItemView.setSelected((selectedPosition == absoluteAdapterPosition))
            binding.showItemView.setOnClickListener(View.OnClickListener {
               if(selectedPosition == absoluteAdapterPosition){
                    Log.d("tag", "fragment 전환")
              } else {
                   selectedPosition = absoluteAdapterPosition
                   notifyItemRangeChanged(0, itemCount)
               }
            })
        }
    }

/*                binding.showItemView.setOnClickListener {
                    if (selectedPosition != absoluteAdapterPosition) {
                        notifyItemChanged(selectedPosition)
                        selectedPosition = absoluteAdapterPosition
                        Log.d("pos", selectedPosition.toString())
                    }
                }*/
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