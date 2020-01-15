package com.simpleapp.crud.modals;

import org.springframework.data.annotation.Id;

public abstract class DataBaseModal {
    @Id
    protected String id;
}
