package exem.fitness;

import java.time.LocalDate;

import static exem.fitness.Membership.dateOfRegistration;

public enum TypeOfMembership {
    ONETIMEMEMBERSHIP{
        public LocalDate dateEndOfRegistration = dateOfRegistration.plusDays(1);

    }
    , DAYMEMBERSHIP{
        public LocalDate dateEndOfRegistration = dateOfRegistration.plusMonths(1);

    }
    , FULLMEMBERSHIP{
        public LocalDate dateEndOfRegistration = dateOfRegistration.plusMonths(1);
    }

}

