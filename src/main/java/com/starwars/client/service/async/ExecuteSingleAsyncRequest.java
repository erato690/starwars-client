package com.starwars.client.service.async;

import com.starwars.client.exception.SingleLoadRequestAsync;
import com.starwars.client.utils.SingleExecutionEnum;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Service
public class ExecuteSingleAsyncRequest {

    private HashMap<SingleExecutionEnum, CompletableFuture<Void>> listMethodSingleExecute = new HashMap<>();


    public void isStarExecute(SingleExecutionEnum type, Supplier<CompletableFuture> startSingle){

        if(listMethodSingleExecute.get(type) == null || listMethodSingleExecute.get(type).isDone()){
            listMethodSingleExecute.put(type,startSingle.get());
        }else{
            throw  new SingleLoadRequestAsync("Existe um processo do type="+type.name()+"em execução");
        }


    }
}
