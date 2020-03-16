package ir.javaland.projects.location.repos;

import ir.javaland.projects.location.model.Location;

public class LocationRepos extends CrudRepos<Location,Long> {
    @Override
    protected Class<Location> getEntityClass() {
        return Location.class;
    }

    private static LocationRepos locationRepos = null;

    private LocationRepos() {
    }

    public static LocationRepos getInstance() {
        if (locationRepos == null)
            locationRepos = new LocationRepos();
        return locationRepos;
    }
}
