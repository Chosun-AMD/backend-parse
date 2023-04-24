package com.backend.parse.Domain.Service;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ReadingConverter
public class IsoDateToJavaDateConverter implements Converter<org.bson.types.ObjectId, Date> {

    @Override
    public Date convert(ObjectId source) {
        return source.getDate();
    }
}