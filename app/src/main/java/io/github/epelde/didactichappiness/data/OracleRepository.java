package io.github.epelde.didactichappiness.data;

/**
 * Created by Gorka on 27/09/2016.
 */
public class OracleRepository implements IOracleRepository {
    @Override
    public int getResponseIdentifier() {
        return new Double(Math.random()*5).intValue();
    }
}
