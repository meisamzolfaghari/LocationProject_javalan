package ir.javaland.projects.location.repos;

import ir.javaland.projects.location.model.Country;

public class CountryRepos extends CrudRepos<Country,Long> {
    @Override
    protected Class<Country> getEntityClass() {
        return Country.class;
    }

    private static CountryRepos countryRepos = null;

    private CountryRepos() {
    }

    public static CountryRepos getInstance() {
        if (countryRepos == null)
            countryRepos = new CountryRepos();
        return countryRepos;
    }
}
