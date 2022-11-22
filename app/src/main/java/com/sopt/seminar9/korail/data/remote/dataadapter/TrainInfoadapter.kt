package com.sopt.seminar9.korail.data.remote.dataadapter

import com.sopt.seminar9.korail.data.remote.model.response.Show_Train_Info


/*class TrainInfoadapter(Item: Show_Train_Info, context: Context) : RecyclerView.Adapter<PersonAdapter.RepoViewHolder>() {
        private val inflater by lazy { LayoutInflater.from(context) }
        private var repoList: List<Person> = emptyList()
        lateinit var gitBinding: LayoutGithubRepoBinding

        class RepoViewHolder( // 레포 뷰홀더
            private val binding: LayoutGithubRepoBinding
        ) : RecyclerView.ViewHolder(binding.root) {
            fun onBind(data: Person) {
                Glide.with(binding.root)
                    .load(data.avatar) // 이 onBind 이내에 parameter가 data이므로 data.avatar가 맞다.
                    .circleCrop()
                    .into(binding.imgGithubRepo)
                binding.txtGithubRepoName.text = data.first_name
                binding.txtGithubRepoAuthor.text = data.email
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
            gitBinding = LayoutGithubRepoBinding.inflate(inflater, parent, false)
            return RepoViewHolder(gitBinding)
        }

        override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
            holder.onBind(repoList[position])
        }

        override fun getItemCount() = repoList.size

        fun setRepoList(repolist: List<Person>) {
            this.repoList = repolist.toList() // 원본이 바뀌어도 문제가 생기지 않도록 "얇은 복사" 처리
            // notifyDataSetChanged() // 새로운 데이터셋을 인식시켜 이를 기반으로 다시 리사이클러 뷰를 그리도록 함
            notifyItemRangeChanged(0, repoList.size)
        }
    }

}*/