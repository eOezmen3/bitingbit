package com.bitingbit.news.mobileapp.fragments

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bitingbit.news.mobileapp.R
import com.bitingbit.news.mobileapp.models.News


class NewsFragment: Fragment() {


    companion object {
        fun newInstance(message: String): NewsFragment {
            val f = NewsFragment()
            val bdl = Bundle(1)
            f.setArguments(bdl)

            return f
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_news, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listView = view.findViewById<ListView>(R.id.news_list_view)

        //set adapter
        listView?.adapter = MyCustomAdapter(requireContext())
    }

    private class MyCustomAdapter(private val mContext: Context): BaseAdapter(){
        //do initiation here as it needs to be done only once
        private val layoutInflater: LayoutInflater = LayoutInflater.from(mContext)


        var newsFromSrc1: Array<News> = arrayOf(
                News(1L, "Johnny Depp in trouble",
                        "Johnny Depp lost his contracts after the scandal with his ex Amber Heard"),
                News(2L, "Elon Musk founds a interesting name for his new born son",  "Elon Musk named his son X Æ A-12"))
        var newsFromSrc2: Array<News> = arrayOf(
                News(1L, "Covid still a big issue in our lives",
                        "Despite tje lock down for almost a year, covid still in our lives" +
                                "Experts says that it's effect on world's finance will require many years in order to recover."),
                News(2L, "News from the fallen king",  "Jon Snow sends his regards from the real north." +
                        "Despite the cold and his lovers continuing dying, he enjoys being a free man in the wild"))

        var news: Array<News> = newsFromSrc1 + newsFromSrc2

        override fun getCount(): Int {
            return news.size
        }

        override fun getItem(position: Int): Any {

            return news[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowMain = layoutInflater.inflate(R.layout.fragment_news_item, parent, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.news_item_headline)
            nameTextView.setText(Html.fromHtml("<h2>${news[position].headline}</h2>"))
            nameTextView.extendedPaddingTop

            val positionTextView = rowMain.findViewById<TextView>(R.id.news_item_content)
            positionTextView.setText(Html.fromHtml("<p>${news[position].content}</p>"))

            return rowMain
        }
    }

}