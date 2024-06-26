

public class Query{

    private String select;
    private String from;
    private String where;
    private String join;
    private String orderBy;
    private String groupBy;

    public Query(QueryBuilder queryBuilder){
        this.select = queryBuilder.getSelect();
        this.from = queryBuilder.getFrom();
        this.where = queryBuilder.getWhere();
        this.join = queryBuilder.getJoin();
        this.orderBy = queryBuilder.getOrderBy();
        this.groupBy = queryBuilder.getGroupBy();
    }

    
    public static class QueryBuilder{

    private String select;
    private String from;
    private String where;
    private String join;
    private String orderBy;
    private String groupBy;

    //So client will only have to call build method to create QueryBuilder object
    public static QueryBuilder getQueryBuilder(){
        return new QueryBuilder();
    }

    public QueryBuilder setSelect(String select){
        this.select = select;
        return this;
    }
    public String getSelect() {
        return select;
    }

    public QueryBuilder setFrom(String from){
        this.from = from;
        return this;
    }
    public String getFrom() {
        return from;
    }

    public QueryBuilder setWhere(String where){
        this.where = where;
        return this;
    }

    public String getWhere() {
        return where;
    }

    public QueryBuilder setJoin(String join){
        this.join = join;
        return this;
    }
    public String getJoin() {
        return join;
    }

    public QueryBuilder setGetOrderBy(String orderBy){
        this.orderBy = orderBy;
        return this;
    }
    public String getOrderBy() {
        return orderBy;
    }

    public QueryBuilder setGetGroupBy(String groupBy){
        this.groupBy = groupBy;
        return this;
    }
    
    public String getGroupBy() {
        return groupBy;
    }

    public Query build(){
        return new Query(this);
    }
    }

}