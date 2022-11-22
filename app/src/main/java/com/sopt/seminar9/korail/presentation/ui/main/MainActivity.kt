package com.sopt.seminar9.korail.presentation.ui.main

import android.os.Bundle
import com.sopt.seminar9.korail.presentation.common.extensions.replace
import com.sopt.seminar9.korail.R
import com.sopt.seminar9.korail.databinding.ActivityMainBinding
import com.sopt.seminar9.korail.presentation.common.binding.BindingActivity
import com.sopt.seminar9.korail.presentation.ui.book.BookTicketFragment
import com.sopt.seminar9.korail.presentation.ui.check.CheckTicketFragment
import com.sopt.seminar9.korail.presentation.ui.discount.DiscountTicketFragment
import com.sopt.seminar9.korail.presentation.ui.tour.ShowTrainFragment
import com.sopt.seminar9.korail.presentation.ui.tour.TourProductFragment
import timber.log.Timber

class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        changeFragment(R.id.menu_book_ticket)

        binding.bnvMain.run {
            setOnItemSelectedListener {
                changeFragment(it.itemId)
                true
            }
        }
    }

    private fun changeFragment(menuItemId: Int) = when (menuItemId) {
        R.id.menu_book_ticket -> replace<BookTicketFragment>(R.id.fcv_main, BookTicketFragment::class.java.simpleName)
        R.id.menu_discount_ticket -> replace<ShowTrainFragment>(R.id.fcv_main) // 열차 조회 화면 테스트용 코드
        // R.id.menu_discount_ticket -> replace<DiscountTicketFragment>(R.id.fcv_main)
        R.id.menu_tour_product -> replace<TourProductFragment>(R.id.fcv_main)
        R.id.menu_check_ticket -> replace<CheckTicketFragment>(R.id.fcv_main)
        else -> Timber.e(IllegalArgumentException(getString(R.string.error_not_found_menu_item)))
    }
}