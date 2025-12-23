package com.xworkz.novel.service;

import com.xworkz.novel.entity.NovelEntity;
import java.util.List;

public interface NovelService {

    String validateAndSave(NovelEntity entity);

    boolean validateAndUpdatePricePagesYearById(double price, int pages, String year, int id);

    NovelEntity validateAllDetailsById(NovelEntity entity);

    boolean validateDeleteById(int id);

    NovelEntity validateAndFindById(int id);

    List<NovelEntity> validateAndFindAll();
}
