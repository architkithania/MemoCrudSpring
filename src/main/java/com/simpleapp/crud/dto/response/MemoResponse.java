package com.simpleapp.crud.dto.response;

import com.simpleapp.crud.modals.Memo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class MemoResponse implements ModalResponseGeneric<Memo, MemoResponse> {
    private String name;
    private String content;

    @Override
    public MemoResponse fromModal(Memo entry) {
        return this
                .setName(entry.getName())
                .setContent(entry.getContent());
    }

    @Override
    public List<MemoResponse> fromModal(List<Memo> entries) {
        return entries
                .stream()
                .map(entry -> new MemoResponse().fromModal(entry))
                .collect(Collectors.toList());
    }
}
