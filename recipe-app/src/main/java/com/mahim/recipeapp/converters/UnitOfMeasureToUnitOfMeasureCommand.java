package com.mahim.recipeapp.converters;

import com.mahim.recipeapp.commands.UnitOfMeasureCommand;
import com.mahim.recipeapp.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(unitOfMeasure.getId());
        unitOfMeasureCommand.setDescription(unitOfMeasure.getDescription());
        return unitOfMeasureCommand;
    }
}
