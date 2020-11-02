package com.kuma.sampleapp2.listmyadapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kuma.sampleapp2.R;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListItem> data;
    private int resource;

    // コンストラクター(コンテキスト、データソース、レイアウトファイルを設定
    // リスト表示に必要な情報を受け取り、対応するフィールドにセット
    // 必要な情報は作成するアダプターによって異なるが、最低限
    // コンテキスト、リストの元となるデータ、項目表示のためのレイアウトは用意しておく必要がある
    MyListAdapter(Context context, ArrayList<ListItem> data, int resource) {
        this.context = context;
        this.data = data;
        this.resource = resource;
    }

    // データ項目の個数を取得
    // getCount(),getItem(),getItemId()メソッドではコンストラクターでセットとされたListItem配列から
    // それぞれ、要素数、指定の項目、id値を取得している
    @Override
    public int getCount() {
        return data.size();
    }

    // 指定された項目を取得
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    // 指定された項目を識別するためのid値を取得
    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    // リスト項目を表示するためのViewを取得
    // positionはリスト項目(インデックス番号)、convertViewは再利用可能な古いビュー、
    // parentはViewの親コンテナ(ListView)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Activity activity = (Activity) context;
        ListItem item = (ListItem) getItem(position);
        if(convertView == null) {
            // レイアウトファイルをViewオブジェクトに変換するには、LayoutInflater().inflateメソッドで取得できる
            // LayoutInflaterオブジェクトは、Activity.getLayoutInflaterメソッドで取得できる
            // 今回はlist_item.xmlを取得しているためinflateメソッドの戻り値も、そのルート要素であるLinearLayoutである
            // なお、inflateメソッドによるレイアウトファイルの解析はそれなりにオーバーヘッドの大きな処理である
            // 以前に利用したビューで再利用可能なものがgetViewメソッドの引数convertViewに渡されているため、
            // 呼び出す際にはこの値がnull出ないかを確認する必要がある
            // nullでない場合は、引数convertViewの値をそのまま利用できる(nullの場合にだけinflateメソッドを呼び出す)
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        // レイアウトを取得できたら、あとはfindViewByIdメソッドでウィジェットを取り出し、
        // データソース(ListItemオブジェクト)から必要な情報をセットするだけである。
        // ちなみに、任意のウィジェットの任意の属性に対して値をセットすることもできる
        ((TextView) convertView.findViewById(R.id.title)).setText(item.getTitle());
        ((TextView) convertView.findViewById(R.id.tag)).setText(item.getTag());
        ((TextView) convertView.findViewById(R.id.desc)).setText(item.getDesc());
        return convertView;
    }
}
