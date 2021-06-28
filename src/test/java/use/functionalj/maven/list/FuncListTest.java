package use.functionalj.maven.list;
import static org.junit.Assert.assertEquals;
import static use.functionalj.maven.list.Employee.theEmployee;

import java.time.LocalDate;

import org.junit.Test;

import functionalj.list.FuncList;
import lombok.val;

public class FuncListTest {

    @Test
    public void test() {        val employees = FuncList.of(
            new Employee("Kailyn Kerenza", LocalDate.of(1970,  8, 10), 59000),
            new Employee("Randi Kathlyn",  LocalDate.of(1971, 10, 13), 43000),
            new Employee("Layla Darrin",   LocalDate.of(1976,  2, 25), 63000),
            new Employee("Bambi Vianne",   LocalDate.of(1998,  7, 20), 64000),
            new Employee("Lila Rowina",    LocalDate.of(1999,  3, 22), 82000)
        );
        
        val Jan_1st_2019 = LocalDate.of(2019, 1, 1);
        double averageCompensationOfOldEmplyees = employees
                .filter  (theEmployee.birthday.until(Jan_1st_2019).getYears().thatGreaterThan(40))
                .mapToInt(theEmployee.compensation)
                .average()
                .orElse(0.0);
        
        assertEquals("55000.0", "" + averageCompensationOfOldEmplyees);
    }

}
