package com.example.yandre.kubsau.academicperfomance;

import android.app.Fragment;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.yandre.kubsau.R;
import com.rmondjone.locktableview.DisplayUtil;
import com.rmondjone.locktableview.LockTableView;
import com.rmondjone.xrecyclerview.ProgressStyle;

import java.util.ArrayList;

public class AcademicPerfomanceFrag extends android.support.v4.app.Fragment {
    private LinearLayout mContentView;
    ArrayList<EntityAcademicPerfomance> academicPerfomancesList = new ArrayList<EntityAcademicPerfomance>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_academic_perfomance, null);
        mContentView = (LinearLayout) v.findViewById(R.id.contentView);

        initDisplayOpinion();


        ArrayList<ArrayList<String>> TableDataList = new ArrayList<ArrayList<String>>();
        // mfristData отвечает за первую строку (заголовок)синим
        ArrayList<String> headerData = new ArrayList<String>();

        //вычислить средний балл и добавить(в presentere)
        headerData.add("Предметы ср. балл 4.75");
        for (int i = 0; i < 4; i++) {
            headerData.add("Ат."+(i + 1));
        }
        headerData.add("Преподаватель");
        TableDataList.add(headerData);

        getAcademicPerfomanceList();

        //количество строк(тк лист создается каждую итерацию )
        for (int i = 0; i < academicPerfomancesList.size(); i++) {
            ArrayList<String> mRowData = new ArrayList<String>();
            //берем название предмета
            mRowData.add(academicPerfomancesList.get(i).subjectNameAcPerf);
            // for (int j = 0; j < 5; j++) {
            //оценка и перпод
            mRowData.add(academicPerfomancesList.get(i).ratingFirstAt);
            mRowData.add(academicPerfomancesList.get(i).ratingSecondAt);
            mRowData.add(academicPerfomancesList.get(i).ratingThridAt);
            mRowData.add(academicPerfomancesList.get(i).ratingFourthtAt);
            mRowData.add(academicPerfomancesList.get(i).teacherNameAcPerf);
            //  }
            TableDataList.add(mRowData);
        }

        final LockTableView mLockTableView = new LockTableView(getContext(), mContentView, TableDataList);
        mLockTableView.setLockFristColumn(true) //是否锁定第一列
                .setLockFristRow(true) //блокировка первой строки
                //  .setMaxColumnWidth(110)
                .setMinColumnWidth(8)
                //.setColumnWidth(1, 80) //设置指定列文本宽度
//            .setColumnWidth(2, 20)
                .setMinRowHeight(20)//行最小高度
                // .setMaxRowHeight(80)//行最大高度
                .setTextViewSize(12) //单元格字体大小
                .setFristRowBackGroudColor(R.color.beijin)//Цвет фона заголовка
                .setTableHeadTextColor(R.color.white)//Цвет шрифта заголовка
                .setTableContentTextColor(R.color.border_color)//Цвет шрифта ячейки
                .setNullableString("N/A") //пустые ячейки
                .setTableViewListener(new LockTableView.OnTableViewListener() {
                    @Override
                    public void onTableViewScrollChange(int x, int y) {
//                        Log.e("значение прокрутки","["+x+"]"+"["+y+"]");
                    }
                })//Значение настройки горизонтального прокрутки горизонтального прокрутки
                .setTableViewRangeListener(new LockTableView.OnTableViewRangeListener() {
                    @Override
                    public void onLeft(HorizontalScrollView view) {
                    }

                    @Override
                    public void onRight(HorizontalScrollView view) {
                    }
                })//Настройка горизонтального контроля полосы прокрутки

                .setOnItemClickListenter(new LockTableView.OnItemClickListenter() {
                    @Override
                    public void onItemClick(View item, int position) {
                    }
                })
                .setOnItemLongClickListenter(new LockTableView.OnItemLongClickListenter() {
                    @Override
                    public void onItemLongClick(View item, int position) {
                    }
                })
                .setOnItemSeletor(R.color.tabtitle_color)//цвет выбраной строки
                .show();
        mLockTableView.getTableScrollView().setPullRefreshEnabled(false);
        mLockTableView.getTableScrollView().setLoadingMoreEnabled(false);
        mLockTableView.getTableScrollView().setRefreshProgressStyle(ProgressStyle.SquareSpin);

        return v;

    }


    private void initDisplayOpinion() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenWidthPx = dm.widthPixels;
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(getContext(), dm.widthPixels);
        DisplayUtil.screenHightDip = DisplayUtil.px2dip(getContext(), dm.heightPixels);

    }

    public void getAcademicPerfomanceList() {

        //из рума брать

        academicPerfomancesList.add(new EntityAcademicPerfomance("Стандартизация, сертификация и управление качеством информационных систем",
                "5","5","4","5","Ефанова Н.В."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Корпоративные информационные системы",
                "5","5","4","5","Вострокнутов А.Е."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Защита информации",
                "5","5","4","5","Мурлин А.Г."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Основы теории управления",
                "5","5","4","5","Орлянская Н.П."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Админитрирование информационных систем",
                "5","5","4","5","Бурда Г.П."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Инструментальные средства информационных систем",
                "5","5","4","5","Грубич Т.Ю."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Инструментальные средства информационных систем",
                "5","5","4","5","Иванова Е.А."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Безопасность жизнидеятельности",
                "5","5","4","5","Мурлин А.Г."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Информационный менеджмент",
                "5","5","4","5","Мурлин А.Г."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Разработка крсплатформенных приложений",
                "5","5","4","5","Мурлин А.Г."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Разработка крсплатформенных приложений",
                "5","5","4","5","Мурлин А.Г."));
        academicPerfomancesList.add(new EntityAcademicPerfomance("Разработка крсплатформенных приложений",
                "5","5","4","5","Мурлин А.Г."));
    }
}
