package shared.searcher.application;

public interface Searcher {

    void setNameFilter(String nameFilter);
    void setTypeFilter(String typeFilter);
    void removeNameFilter();
    void removeTypeFilter();
}
