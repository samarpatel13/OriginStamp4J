package com.originstamp.client;

import org.glassfish.jersey.client.rx.rxjava.RxObservable;
import rx.Observable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Created by Thomas on 10.01.17.
 */
public class RestClient {

    private Client client = ClientBuilder.newClient();

    public <T> Observable<T> createRestCallObservable(Class<T> clazz, String uri) {
        return
                RxObservable.from(client)
                        .target(uri)
                        .request()
                        .rx()
                        .get(clazz)
                ;
    }
}
