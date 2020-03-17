package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.schema.Data;

public interface DataMapper<T> {

    T map(Data data);
}
