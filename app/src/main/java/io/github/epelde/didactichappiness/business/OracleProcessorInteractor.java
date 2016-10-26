package io.github.epelde.didactichappiness.business;

import io.github.epelde.didactichappiness.data.IOracleRepository;
import io.github.epelde.didactichappiness.data.OracleRepository;

/**
 * Created by Gorka on 03/10/2016.
 */
public class OracleProcessorInteractor implements IOracleProcessorInteractor{

    private IOracleRepository oracleRepo;

    public OracleProcessorInteractor(){
        setOracleRepo(new OracleRepository());
    }
    @Override
    public int processQuestion(String question){
        return getOracleRepo().getResponseIdentifier();
    }

    public IOracleRepository getOracleRepo() {
        return oracleRepo;
    }

    public void setOracleRepo(IOracleRepository oracleRepo) {
        this.oracleRepo = oracleRepo;
    }
}
