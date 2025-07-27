package service;

import model.Match;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OngoingMatchesService {
    private static final Map<UUID, Match> ongoingMatches = new HashMap<>();

    public static UUID createMatch(Match match) {
        UUID uuid = UUID.randomUUID();
        ongoingMatches.put(uuid, match);
        return uuid;
    }

    public static Match getMatch(UUID uuid) {
        return ongoingMatches.get(uuid);
    }

    public static void removeMatch(UUID uuid) {
        ongoingMatches.remove(uuid);
    }
}
