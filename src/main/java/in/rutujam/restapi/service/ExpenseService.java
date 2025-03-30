package in.rutujam.restapi.service;

import in.rutujam.restapi.dto.ExpenseDTO;

import java.util.List;
/**
 * Service interface for expense module
 * */
public interface ExpenseService {

    /**
     * It will fetch expenses from database
     * @return list
     * */
    List<ExpenseDTO> getAll();
}

