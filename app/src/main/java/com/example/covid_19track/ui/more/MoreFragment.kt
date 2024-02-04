package com.example.covid_19track.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19track.R
import com.example.covid_19track.databinding.FragmentMoreBinding
import java.util.*

class MoreFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments().getString(ARG_PARAM1)
            mParam2 = requireArguments().getString(ARG_PARAM2)
        }
    }

    var binding: FragmentMoreBinding? = null
    var moreAdapter: MoreAdapter? = null
    var moreModelList: MutableList<MoreModel>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        val view: View = binding!!.root
        requireActivity().title = "More"

        moreModelList = ArrayList()

        (moreModelList as ArrayList<MoreModel>).add(MoreModel(R.drawable.symptoms, "Symptoms"))
        (moreModelList as ArrayList<MoreModel>).add(MoreModel(R.drawable.avoid_touch, "Avoid Touch"))
        (moreModelList as ArrayList<MoreModel>).add(MoreModel(R.drawable.diarrhea, "Diarrhea"))
        (moreModelList as ArrayList<MoreModel>).add(MoreModel(R.drawable.dry_cough, "Dry Cough"))
        (moreModelList as ArrayList<MoreModel>).add(MoreModel(R.drawable.fever_icon, "Fever"))
        (moreModelList as ArrayList<MoreModel>).add(MoreModel(R.drawable.nasal, "Nasal"))
        (moreModelList as ArrayList<MoreModel>).add(MoreModel(R.drawable.paining, "Paining"))
        (moreModelList as ArrayList<MoreModel>).add(MoreModel(R.drawable.runny_noice, "Runny Nose"))
        moreAdapter = MoreAdapter(context, moreModelList as ArrayList<MoreModel>)
        //
        // on the below line we are setting layout manager to our recycler view.
        binding!!.moreRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // on the below line we are setting an adapter to our recycler view.
        binding!!.moreRecycler.adapter = moreAdapter

        // on the below line we are notifying our adapter as the data is updated.
        moreAdapter!!.notifyDataSetChanged()
        return view
    }

    companion object {

        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"


        fun newInstance(param1: String?, param2: String?): MoreFragment {
            val fragment = MoreFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}