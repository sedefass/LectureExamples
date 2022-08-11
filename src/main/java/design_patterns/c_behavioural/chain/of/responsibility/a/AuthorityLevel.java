package design_patterns.c_behavioural.chain.of.responsibility.a;

public enum AuthorityLevel {

    PROGRAMMER(1),
    LEAD_PROGRAMMER(2),
    MANAGER(3);

    private final int level;

    AuthorityLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
