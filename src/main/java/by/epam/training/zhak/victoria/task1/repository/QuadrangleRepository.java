package by.epam.training.zhak.victoria.task1.repository;

import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import by.epam.training.zhak.victoria.task1.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class QuadrangleRepository implements Repository <Quadrangle> {
    private static final Logger LOGGER = LogManager.getLogger();
    private Map <Long, Quadrangle> data = new HashMap<>();

    @Override
    public void add(Quadrangle quadrangle){
        data.put(quadrangle.getId(),quadrangle);
        LOGGER.info("Adding new quadrangle " + quadrangle.getId());
    }

    @Override
    public void remove(Quadrangle quadrangle){
        data.remove(quadrangle.getId(),quadrangle);
        LOGGER.info("Removing quadrangle " + quadrangle.getId());
    }

    @Override
    public void update(Quadrangle quadrangle){
       for (Map.Entry<Long, Quadrangle> record: data.entrySet()){
           if(record.getKey().equals(quadrangle.getId())){
               data.put(quadrangle.getId(),quadrangle);
               LOGGER.info("Updating is done!");
           }
       }
    }

      @Override
      public List <Quadrangle> sortBy(Comparator comparator){
            return data.values().stream().
                    sorted(comparator::compare).
          collect(Collectors.toList());
    }

    @Override
    public List <Quadrangle> find(Specification<Quadrangle>specification){
        return data.values().stream().
                filter(specification::specified).
                collect(Collectors.toList());
    }
}
