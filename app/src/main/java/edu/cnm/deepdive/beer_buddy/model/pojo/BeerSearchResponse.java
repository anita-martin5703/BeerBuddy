package edu.cnm.deepdive.beer_buddy.model.pojo;

import edu.cnm.deepdive.beer_buddy.model.entity.Beer;

import java.util.List;

public class BeerSearchResponse {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static class Response {

        private Beers beers;

        public Beers getBeers() {
            return beers;
        }

        public void setBeers(Beers beers) {
            this.beers = beers;
        }
    }

    public static class Beers {

        private List<Beer> items;

        public List<Beer> getItems() {
            return items;
        }

        public void setItems(List<Beer> items) {
            this.items = items;
        }

    }

}
