package com.sopt.seminar9.korail.data.remote.dataadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.seminar9.korail.data.remote.model.response.Show_Train
import com.sopt.seminar9.korail.data.remote.model.response.Show_Train_Info
import com.sopt.seminar9.korail.databinding.FragmentShowTrainBinding
import com.sopt.seminar9.korail.databinding.ItemShowTrainInfoBinding


class TrainInfoAdapter(Item: List<Show_Train>, context: Context) : RecyclerView.Adapter<TrainInfoAdapter.TrainViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var trainList: List<Show_Train> = emptyList()
    lateinit var binding: ItemShowTrainInfoBinding

    class TrainViewHolder(
        private var binding: ItemShowTrainInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Show_Train) {
            binding.txtTrain.text = data.TrainName
            binding.txtTimeDepart.text = data.StartTime
            binding.txtTimeArrive.text = data.LastTime
            binding.txtPrice.text = data.NormalPrice + "₩"
            binding.txtSpecialPrice.text = data.SpecialPrice + "₩"
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