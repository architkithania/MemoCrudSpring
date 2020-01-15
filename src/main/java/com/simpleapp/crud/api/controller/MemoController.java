package com.simpleapp.crud.api.controller;

import com.simpleapp.crud.dto.response.ModalResponse;
import com.simpleapp.crud.dto.response.MemoResponse;
import com.simpleapp.crud.repository.MemoRepository;
import com.simpleapp.crud.modals.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/memos")
public class MemoController {
    private final MemoRepository memoRepository;

    public MemoController(@Autowired MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @GetMapping("/byId/{memoId}")
    public ModalResponse getUserById(@PathVariable String memoId) {
        Optional<Memo> entry = memoRepository.findById(memoId);
        return entry.map(memo -> new MemoResponse().fromModal(memo)).orElse(null);
    }

    @GetMapping("/byName/{name}")
    public List<? extends ModalResponse> getUserByFirstName(@PathVariable String name) {
        List<Memo> memoList = memoRepository.findAllByName(name);
        return new MemoResponse().fromModal(memoList);
    }

    @GetMapping("/bycontent/{content}")
    public ModalResponse getMemoByContent(@PathVariable String content) {
        return new MemoResponse().fromModal(memoRepository.findByContent(content));
    }
}
