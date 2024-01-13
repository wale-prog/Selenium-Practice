package OPPConcept;

public enum DaysOfTheWeek {
    SUNDAY(100, 0),
    MONDAY(20, 1),
    TUESDAY(50, 2),
    WEDNESDAY(60, 3),
    THURSDAY(80, 4),
    FRIDAY(90, 5),
    SATURDAY(100, 6);

    final int favoriteDayLevel;
    final int index;
    DaysOfTheWeek(int favoriteDayLevel, int index) {
        this.favoriteDayLevel = favoriteDayLevel;
        this.index = index;
    }
}
