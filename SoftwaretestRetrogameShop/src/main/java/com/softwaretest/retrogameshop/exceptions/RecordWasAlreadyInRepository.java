package com.softwaretest.retrogameshop.exceptions;

public class RecordWasAlreadyInRepository extends Exception{

    private Object record;

    public RecordWasAlreadyInRepository(Object obj){
        this.record = obj;
    }

    public Object getRecord() {
        return record;
    }
}
