package edu.cnm.deepdive.beer_buddy.model.pojo;

import edu.cnm.deepdive.beer_buddy.model.entity.Bar;

import java.util.List;

public class BarSearchResponse {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static class Response {

        private Brewery brewery;

        public Brewery getBrewery() {
            return brewery;
        }

        public void setBrewery(Brewery brewery) {
            this.brewery = brewery;
        }
    }

    public static class Brewery {

        private List<Item> items;

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

    }

    public static class Item {

        private Bar brewery;

        public Bar getBrewery() {
            return brewery;
        }

        public void setBrewery(Bar brewery) {
            this.brewery = brewery;
        }

    }

}
