package com.picketlogia.picket.api.product.service.validator;

import com.picketlogia.picket.utils.BaseValidator;

public interface BaseProductValidator<T> extends BaseValidator<T> {
    @Override
    void validate(T target);
}
