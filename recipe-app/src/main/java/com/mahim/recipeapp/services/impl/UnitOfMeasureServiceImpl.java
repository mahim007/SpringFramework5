package com.mahim.recipeapp.services.impl;

import com.mahim.recipeapp.commands.UnitOfMeasureCommand;
import com.mahim.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.mahim.recipeapp.repositories.UnitOfMeasureRepository;
import com.mahim.recipeapp.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand toUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
                                    UnitOfMeasureToUnitOfMeasureCommand toUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.toUnitOfMeasureCommand = toUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(), false)
                .map(toUnitOfMeasureCommand::convert)
                .collect(Collectors.toSet());
    }
}
