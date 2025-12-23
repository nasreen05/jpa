package com.xworkz.novel.service;

import com.xworkz.novel.entity.NovelEntity;
import com.xworkz.novel.repository.*;

import java.util.List;

public class NovelServiceImpl implements NovelService {

    NovelRepository repository = new NovelRepositoryImpl();

    @Override
    public String validateAndSave(NovelEntity entity) {
        if (entity != null) {
            return repository.saveNovelInfo(entity);
        }
        return "Entity is null";
    }

    @Override
    public boolean validateAndUpdatePricePagesYearById(double price, int pages, String year, int id) {
        if (price > 0 && pages > 0 && year != null && id > 0) {
            return repository.updatePricePagesYearById(price, pages, year, id);
        }
        return false;
    }

    @Override
    public NovelEntity validateAllDetailsById(NovelEntity entity) {
        if (entity != null) {
            return repository.updateAllDetailsById(entity);
        }
        return null;
    }

    @Override
    public boolean validateDeleteById(int id) {

        return id > 0 && repository.deleteById(id);
    }

    @Override
    public NovelEntity validateAndFindById(int id) {
        if (id > 0) {
            return repository.findNovelById(id);
        }
        return null;
    }

    @Override
    public List<NovelEntity> validateAndFindAll() {

        return repository.findAllNovelDetails();
    }
}
