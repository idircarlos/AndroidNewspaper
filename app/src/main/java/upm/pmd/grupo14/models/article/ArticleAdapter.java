package upm.pmd.grupo14.models.article;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import upm.pmd.grupo14.R;

public class ArticleAdapter extends BaseAdapter {

    List<Article> articles = new LinkedList<Article>();

    public void addArticles(List<Article> newArticles){
        articles.addAll(newArticles);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Object getItem(int i) {
        return articles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null){
            view = inflater.inflate(R.layout.article_row_layout,null);
        }
        ((TextView)view.findViewById(R.id.txt_category)).setText(articles.get(i).getCategory().name());
        ((TextView)view.findViewById(R.id.txt_title)).setText(articles.get(i).getTitle());
        ((TextView)view.findViewById(R.id.txt_abstract)).setText(articles.get(i).getResume());
        ((ImageView)view.findViewById(R.id.img_thumbnail)).setImageBitmap(articles.get(i).getThubnail().getImg());
        return view;
    }
}
