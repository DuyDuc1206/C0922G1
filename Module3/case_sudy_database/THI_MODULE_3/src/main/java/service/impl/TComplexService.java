package service.impl;

import model.TComplex;
import repository.ITComplexRepository;
import repository.impl.TComplexRepository;
import service.ITComplexService;

import java.util.List;

public class TComplexService implements ITComplexService {
    ITComplexRepository itComplexRepository = new TComplexRepository();
    @Override
    public List<TComplex> selectAllTComplex() {
        return itComplexRepository.selectAllTComplex();
    }
}
