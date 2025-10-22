package com.example.osintcrud.dto;

public class SearchResponse {

    private String status;
    private String query;
    private Object result;
    private String message;
    public SearchResponse(String status, String query, Object result, String message) {
        this.status = status;
        this.query = query;
        this.result = result;
        this.message = message;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getQuery(){
        return query;
    }
    public void setQuery(String query){
        this.query = query;
    }
    public Object getResult(){
        return result;
    }
    public void setResult(Object result){
        this.result = result;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
