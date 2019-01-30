package com.lazday.retrofit.main;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainModel {

    @SerializedName("results")
    private List<Results> results;

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public class Results{

        @SerializedName("backdrop_path")
        private String backdrop_path;
        @SerializedName("title")
        private String title;
        @SerializedName("overview")
        private String overview;
        @SerializedName("release_date")
        private String release_date;

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }
    }

}
