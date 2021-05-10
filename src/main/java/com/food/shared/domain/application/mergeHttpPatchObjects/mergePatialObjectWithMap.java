package com.food.shared.domain.application.mergeHttpPatchObjects;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class mergePatialObjectWithMap<T> {

    private final Map<String, Object> fields;

    private final T sourceObject;

    public mergePatialObjectWithMap(Map<String, Object> patchFields, T entityMapper) {
        this.fields = patchFields;
        this.sourceObject = entityMapper;
    }

    public T handle()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        T objectMapperSource = (T) objectMapper.convertValue(this.fields, this.sourceObject.getClass());

        this.fields.forEach((propertyName, propertyValue) -> {
            Field field = ReflectionUtils.findField(this.sourceObject.getClass(), propertyName);
            field.setAccessible(true);

            Object newValue = ReflectionUtils.getField(field, objectMapperSource);

            ReflectionUtils.setField(field, this.sourceObject, newValue );
        });

        return this.sourceObject;
    }

}
