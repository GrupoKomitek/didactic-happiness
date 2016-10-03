package io.github.epelde.didactichappiness.business;

import butterknife.BindArray;
import butterknife.ButterKnife;
import io.github.epelde.didactichappiness.R;
import io.github.epelde.didactichappiness.data.IOracleRepository;
import io.github.epelde.didactichappiness.data.OracleRepository;

/**
 * Created by Gorka on 03/10/2016.
 */
public class OracleProcessorInteractor {

    String[] oracle_responses;
    public IOracleRepository oracleRepo;

    public OracleProcessorInteractor(String[] oracle_responses){
        this.oracle_responses = oracle_responses;
        oracleRepo = new OracleRepository();
    }
    public String processQuestion(String question){
        return oracle_responses[oracleRepo.getResponseIdentifier()];
    }
}
