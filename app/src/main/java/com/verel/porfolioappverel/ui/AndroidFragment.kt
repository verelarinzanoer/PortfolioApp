package com.verel.porfolioappverel.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.verel.porfolioappverel.Adapter.RVAndroidAdapter
import com.verel.porfolioappverel.R
import com.verel.porfolioappverel.data.PortfolioData
import com.verel.porfolioappverel.databinding.FragmentAndroidBinding

private const val PORTOFOLIO_LINK = "https://www.dzakyhdr.my.id"

class AndroidFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentAndroidBinding? = null
    private val binding get() =  _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAndroidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val androidAdapter = RVAndroidAdapter()
        androidAdapter.setData(PortfolioData.listAppAndroid)

        androidAdapter.onItemClicked = { selectedData ->
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(selectedData.link))
        }
        with(binding.rvAndroid){
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = androidAdapter
        }

        binding.btnAndroid.text = getString(
            R.string.app_android_btn,
            PortfolioData.listAppAndroid.size.toString()
        )

        binding.txtDokumentasi.setOnClickListener {
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(PORTOFOLIO_LINK))
        }
    }


}