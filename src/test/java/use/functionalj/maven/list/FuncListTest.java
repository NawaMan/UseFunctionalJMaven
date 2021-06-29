package use.functionalj.maven.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static use.functionalj.maven.list.Employee.theEmployee;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import functionalj.list.FuncList;

class FuncListTest {
    
    @Test
    void test() {
        var employees = FuncList.of(
            new Employee("Kailyn Kerenza", LocalDate.of(1970,  8, 10), 59000),
            new Employee("Randi Kathlyn",  LocalDate.of(1971, 10, 13), 43000),
            new Employee("Layla Darrin",   LocalDate.of(1976,  2, 25), 63000),
            new Employee("Bambi Vianne",   LocalDate.of(1998,  7, 20), 64000),
            new Employee("Lila Rowina",    LocalDate.of(1999,  3, 22), 82000)
        );
        
        var Jan_1st_2019 = LocalDate.of(2019, 1, 1);
        var oldAge       = 40;
        var averageCompensationOfOldEmplyees = employees
                .filter  (theEmployee.birthday.until(Jan_1st_2019).getYears().thatGreaterThan(oldAge))
                .mapToInt(theEmployee.compensation)
                .average()
                .orElse(0.0);
        
        assertEquals("55000.0", "" + averageCompensationOfOldEmplyees);
    }

}
