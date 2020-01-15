package com.simpleapp.crud.repository;

import com.simpleapp.crud.modals.Memo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemoRepository extends MongoRepository<Memo, String> {
    List<Memo> findAllByName(String MemoName);
    Memo findByContent(String content);
}
