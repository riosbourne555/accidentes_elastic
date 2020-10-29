package com.example.demo.repository;

import java.util.Collection;
import com.example.demo.model.WConditions;

public interface AccidentRepositoryMod {

    Collection<WConditions> findWConditions();

    Float findPromDistance();

}
