package com.artiow.moex.api.model.mapper.table;

import com.artiow.moex.api.model.schema.Data;

import java.util.List;

public interface TableMapper<T> {

    List<T> map(Data data);
}
