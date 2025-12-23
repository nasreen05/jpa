package com.xworkz.novel.repository;

import com.xworkz.novel.entity.NovelEntity;
import java.util.List;

public interface NovelRepository {

    String saveNovelInfo(NovelEntity entity);

    boolean updatePricePagesYearById(double price, int pages, String year, int id);

    NovelEntity updateAllDetailsById(NovelEntity entity);

    boolean deleteById(int id);

    NovelEntity findNovelById(int id);

    List<NovelEntity> findAllNovelDetails();
}
