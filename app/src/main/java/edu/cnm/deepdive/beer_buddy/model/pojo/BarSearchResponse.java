/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.pojo;

import edu.cnm.deepdive.beer_buddy.model.entity.Bar;

import java.util.List;

/**
 * Custom built POJO to breakdown the hierarchical relationship of items nested in one another of the API.
 */
public class BarSearchResponse {

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
     * Nested class within BarSearchResponse to break down hierarchical item to retrieve a response of brewery.
     */
    public static class Response {

        private Brewery brewery;

        /**
         * @return returns the brewery of the hierarchical item.
         */
        public Brewery getBrewery() {
            return brewery;
        }

        /**
         * @param brewery sets the brewery of the hierarchical item.
         */
        public void setBrewery(Brewery brewery) {
            this.brewery = brewery;
        }
    }

    /**
     * Nested class within BarSearchResponse to break down hierarchical item to retrieve a response of listed items.
     */
    public static class Brewery {

        private List<Item> items;

        /**
         * @return returns the items of the hierarchical item.
         */
        public List<Item> getItems() {
            return items;
        }

        /**
         * @param items sets the items of the hierarchical item.
         */
        public void setItems(List<Item> items) {
            this.items = items;
        }

    }

    /**
     * Nested class within BarSearchResponse to break down hierarchical item to retrieve a response of brewery.
     */
    public static class Item {

        private Bar brewery;

        /**
         * @return returns the brewery of the hierarchical item.
         */
        public Bar getBrewery() {
            return brewery;
        }

        /**
         * @param brewery sets the brewery of the hierarchical item.
         */
        public void setBrewery(Bar brewery) {
            this.brewery = brewery;
        }

    }

}
