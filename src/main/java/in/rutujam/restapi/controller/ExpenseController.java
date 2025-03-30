package in.rutujam.restapi.controller;

import in.rutujam.restapi.dto.ExpenseDTO;
import in.rutujam.restapi.io.ExpenseResponse;
import in.rutujam.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This is controller class for Expense module
 * @Author Rutuja Malvadkar...
 */

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    /**
     * It will fetch expenses from database
     * @return  list
     * */

    @GetMapping("expenses")
    public List<Object> getAllExpenses(){
        log.info("API GET /expenses called");
        //Call the service method
        List<ExpenseDTO> list= expenseService.getAll();
        log.info("Printing the data from service {}",list);
        //Convert expenseDTO to expenseResponse

        return list.stream().map(this::mapToExpenseResponse).collect(Collectors.toList());


    }
/**
 * Mapper method for converting expense dto object to expense respons
 * @return ExpenseResponse
 * */
    private Object mapToExpenseResponse(ExpenseDTO expenseDTO) {
        return modelMapper.map(expenseDTO,ExpenseResponse.class);
    }

}
