package com.xworkz.novel.runner;
import com.xworkz.novel.entity.NovelEntity;
import com.xworkz.novel.service.*;

import java.util.List;

public class NovelRunner {

    public static void main(String[] args) {

        NovelService service = new NovelServiceImpl();

        // SAVE
        NovelEntity novel = new NovelEntity();
        novel.setTitle("The Alchemist");
        novel.setAuthor("Paulo Coelho");
        novel.setPrice(299);
        novel.setPages(208);
        novel.setPublishedYear("1988");

//        System.out.println(service.validateAndSave(novel));

        // UPDATE
//        boolean updated = service.validateAndUpdatePricePagesYearById(350, 220, "1993", 1);
//        System.out.println(updated);

        // FETCH ALL
        List<NovelEntity> list = service.validateAndFindAll();
        System.out.println(list);
    }
}
