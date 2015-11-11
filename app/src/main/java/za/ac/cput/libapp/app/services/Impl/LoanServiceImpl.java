package za.ac.cput.libapp.app.services.Impl;

import za.ac.cput.libapp.app.domain.Impl.Loan;
import za.ac.cput.libapp.app.respositories.RestAPI;
import za.ac.cput.libapp.app.respositories.rest.RestLoanAPI;
import za.ac.cput.libapp.app.services.LoanService;

import java.util.List;

/**
 * Created by Yongama on 2015/10/04.
 */
public class LoanServiceImpl implements LoanService {

    final RestAPI<Loan,Long> rest = new RestLoanAPI();
    @Override
    public Loan findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(Loan entity) {

        return rest.post(entity);
    }

    @Override
    public String update(Loan entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(Loan entity) {
        return rest.delete(entity);
    }

    @Override
    public List<Loan> findAll() {
        return rest.getAll();
    }
}
