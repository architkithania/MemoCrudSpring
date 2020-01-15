package com.simpleapp.crud.modals;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Document(collection = "memos")
public class Memo extends DataBaseModal {
    private String name;
    private String content;
    private double dataAdded;
    private boolean isConfidential;

    public Memo(String name, String content, double dataAdded, boolean isConfidential) {
        this.name = name;
        this.content = content;
        this.dataAdded = dataAdded;
        this.isConfidential = isConfidential;
    }
}
