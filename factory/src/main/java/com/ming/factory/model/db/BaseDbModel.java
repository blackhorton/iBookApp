package com.ming.factory.model.db;

import com.ming.factory.utils.DiffUiDataCallback;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * @author Hortons
 * on 2020/3/17
 */


public abstract class BaseDbModel<Model> extends BaseModel implements DiffUiDataCallback.UiDataDiffer<Model> {
}
