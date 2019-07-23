/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.pojo;

import edu.cnm.deepdive.beer_buddy.model.entity.Beer;

import java.util.List;

/**
 * Custom built POJO to breakdown the hierarchical relationship of items nested in one another of the API.
 */
public class BeerSearchResponse {

    private Response response;

    /**
     * @return returns the response of the hierarchical item.
     */
    public Response getResponse() {
        return response;
    }

    /**
     * @param response sets the response of the hierarchical item.
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     * Nested class within BeerSearchResponse to break down hierarchical item to retrieve a response of beers.
     */
    public static class Response {

        private Beers beers;

        /**
         * @return returns the beers of the hierarchical item.
         */
        public Beers getBeers() {
            return beers;
        }

        /**
         * @param beers sets the beers of the hierarchical item.
         */
        public void setBeers(Beers beers) {
            this.beers = beers;
        }
    }

    /**
     * Nested class within BarSearchResponse to break down hierarchical item to retrieve a response of listed items.
     */
    public static class Beers {

        private List<Beer> items;

        /**
         * @return returns the response of the hierarchical item.
         */
        public List<Beer> getItems() {
            return items;
        }

        /**
         * @param items sets the response of the hierarchical item.
         */
        public void setItems(List<Beer> items) {
            this.items = items;
        }

    }

}
