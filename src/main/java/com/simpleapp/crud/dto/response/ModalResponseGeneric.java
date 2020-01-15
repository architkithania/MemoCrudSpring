package com.simpleapp.crud.dto.response;

import com.simpleapp.crud.modals.DataBaseModal;

import java.util.List;

interface ModalResponseGeneric<T extends DataBaseModal, R extends ModalResponseGeneric> extends ModalResponse {
    R fromModal(T entry);
    List<R> fromModal(List<T> listOfEntries);
}
