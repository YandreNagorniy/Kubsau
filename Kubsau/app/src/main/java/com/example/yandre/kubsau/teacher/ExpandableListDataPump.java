package com.example.yandre.kubsau.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<>();

        List<String> infSistem = new ArrayList<String>();
        infSistem.add("Бардин Александр Константинович");
        infSistem.add("Кондратьев Валерий Юрьевич");
        infSistem.add("Ковалева Ксения Александровна");
        infSistem.add("Замотайлова Дарья Александровна");
        infSistem.add("Рассулов Антон Андреевич");

        List<String> sisAnaliza = new ArrayList<String>();
        sisAnaliza.add("Вострокнутов Александр Евгеньевич");
        sisAnaliza.add("Грубич Татьяна Юрьевна");
        sisAnaliza.add("Ефанова Наталья Владимировна");
        sisAnaliza.add("Иванова Елена Александровна");
        sisAnaliza.add("Мурлин Алексей Георгиевич");

        List<String> KTS = new ArrayList<String>();
        KTS.add("Анищик Татьяна Алексеевна");
        KTS.add("Аршинов Георгий Александрович");
        KTS.add("Креймер Алексей Семенович");
        KTS.add("Курносов Сергей Андреевич");
        KTS.add("Параскевов Александр Владимирович");

        List<String> kibernetici = new ArrayList<String>();
        kibernetici.add("Бурда Григорий Петрович");
        kibernetici.add("Бурда Григорий Петрович");
        kibernetici.add("Затонская Ирина Викторовна");
        kibernetici.add("Косников Сергей Николаевич");
        kibernetici.add("Ковалева Ксения Александровна");
        kibernetici.add("Осенний Виталий Витальеви");

        expandableListDetail.put("Системного анализа", sisAnaliza);
        expandableListDetail.put("Информационных систем", infSistem);
        expandableListDetail.put("Компьютерных технологий и систем", KTS);
        expandableListDetail.put("Экономической кибернетики", kibernetici);
        return expandableListDetail;

       /* infSistem.add("Нагорный Валерий Александрович");
        infSistem.add("Кравченко Александр Сергеевич");
        infSistem.add("Фоменко Дмитрий Максимович");
        infSistem.add("Цепилов Даниил Олегович");
        infSistem.add("Рассулов Антон Андреевич");

        List<String> sisAnaliza = new ArrayList<String>();
        sisAnaliza.add("Вострокнутов Александр Евгеньевич");
        sisAnaliza.add("Грубич Татьяна Юрьевна");
        sisAnaliza.add("Ефанова Наталья Владимировна");
        sisAnaliza.add("Иванова Елена Александровна");
        sisAnaliza.add("Мурлин Алексей Георгиевич");

        List<String> KTS = new ArrayList<String>();
        KTS.add("Анищик Татьяна Алексеевна");
        KTS.add("Аршинов Георгий Александрович");
        KTS.add("Креймер Алексей Семенович");
        KTS.add("Курносов Сергей Андреевич");
        KTS.add("Параскевов Александр Владимирович");

        List<String> kibernetici = new ArrayList<String>();
        kibernetici.add("Бурда Григорий Петрович");
        kibernetici.add("Бурда Григорий Петрович");
        kibernetici.add("Затонская Ирина Викторовна");
        kibernetici.add("Косников Сергей Николаевич");
        kibernetici.add("Ковалева Ксения Александровна");
        kibernetici.add("Осенний Виталий Витальеви");

        expandableListDetail.put("ИТ 1601", sisAnaliza);
        expandableListDetail.put("ИТ 1401", infSistem);
        expandableListDetail.put("ИТ 1501", KTS);
        expandableListDetail.put("ИТ 1421", kibernetici);
        return expandableListDetail;*/
    }
}
