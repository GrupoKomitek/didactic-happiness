package io.github.epelde.didactichappiness.business;

import butterknife.BindArray;
import butterknife.ButterKnife;
import io.github.epelde.didactichappiness.R;
import io.github.epelde.didactichappiness.data.IOracleRepository;
import io.github.epelde.didactichappiness.data.OracleRepository;

/**
 * Created by Gorka on 03/10/2016.
 */
public class OracleProcessorInteractor implements IOracleProcessorInteractor{

    public IOracleRepository oracleRepo;

    public OracleProcessorInteractor(){
        oracleRepo = new OracleRepository();
    }
    @Override
    public int processQuestion(String question){
        return oracleRepo.getResponseIdentifier();
    }
}
