package in.rutujam.restapi.service.impl;

import in.rutujam.restapi.dto.ExpenseDTO;
import in.rutujam.restapi.entity.ExpenseEntity;
import in.rutujam.restapi.repository.ExpenseRepository;
import in.rutujam.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for Expense module
 * @Author Rutuja
 * */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    /**
     * It will fetch expenses from database
     * @return list
     * */
    @Override
    public List<ExpenseDTO> getAll() {
        List<ExpenseEntity> list = expenseRepository.findAll();
        log.info("Printing the data from repository {}",list);
        return list.stream()
                .map(this::mapToExpenseDTO)
                .collect(Collectors.toList());
    }


    /**
     * Mapper method to convert expense entity to
     * @return list
     * */
    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
