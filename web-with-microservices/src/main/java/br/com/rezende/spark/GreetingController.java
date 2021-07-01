package br.com.rezende.spark;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import static br.com.rezende.spark.JsonParsingFilter.REQUEST_DATA;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class GreetingController
{
    private final AtomicReference<String> name = new AtomicReference<>("World");

    public Object simpleGreeting( final Request request, final Response response )
    {
        return "Hello, " + name.get();
    }

    public Object withName( final Request request, final Response response )
    {
        return "Hello, " + request.params( "name" );
    }

    public Object pageWithName( final Request request, final Response response )
    {
        var model = Map.of( "name", request.params( "name" ) );
        return new ModelAndView( model, "views/welcome" );
    }

    public Object complexGreeting( final Request request, final Response response )
    {
        var body = (GreetingInput) request.attribute( REQUEST_DATA );
        response.header( "content-type", "application/json" );
        return new Greeting( "Hello, " + body.name, System.currentTimeMillis() );
    }

    public Object updateName( final Request request, final Response response )
    {
        this.name.set( request.queryMap("name").value() );
        response.status( 204 );
        return "";
    }
}
