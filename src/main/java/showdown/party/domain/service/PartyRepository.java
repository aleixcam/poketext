package showdown.party.domain.service;

import showdown.party.domain.Party;

public interface PartyRepository {

    String[] list();
    Party get(String ref);
}
