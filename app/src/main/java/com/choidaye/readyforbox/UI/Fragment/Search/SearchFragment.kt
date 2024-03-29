package com.choidaye.readyforbox.UI.Fragment.Search


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.choidaye.readyforbox.DB.SearchSharedPreferenceController

import com.choidaye.readyforbox.R

import com.choidaye.readyforbox.UI.Adapter.SearchFragmentStatePagerAdapter
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search_new.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchFragment : Fragment() {
    lateinit var searchArray: ArrayList<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        configureToptab()
        configureSearch()

        et_ac_search_text.setOnClickListener {

            searchArray.add(et_ac_search_text.text.toString())

            SearchSharedPreferenceController.setSearchWord(context!!,"search",searchArray)
        }
    }

    private fun configureToptab() {
        vp_fg_search.adapter = SearchFragmentStatePagerAdapter(childFragmentManager, 2)
        tl_fg_search_toptab.setupWithViewPager(vp_fg_search)
        val topTabLayout: View = activity!!.layoutInflater.inflate(R.layout.top_tabbar_fg_search, null, false)

        tl_fg_search_toptab.getTabAt(0)!!.customView = topTabLayout.findViewById(R.id.rl_fg_search_new) as RelativeLayout
        tl_fg_search_toptab.getTabAt(1)!!.customView = topTabLayout.findViewById(R.id.rl_fg_search_recommend) as RelativeLayout
    }
    private fun configureSearch(){
        /*
        if(SearchSharedPreferenceController.getSearchWord(context!!,"search").isEmpty()){
            fg_not_search_word.visibility=View.VISIBLE
            rv_fg_search_list_new.visibility=View.INVISIBLE
        }else{
            fg_not_search_word.visibility=View.INVISIBLE
            rv_fg_search_list_new.visibility=View.VISIBLE
        }
*/
    }

    override fun onResume() {
        super.onResume()
        configureSearch()
    }
}
