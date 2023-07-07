package aaa.entity;

public class CommandEntity {
    private int id;
    private String name;
    private String explanation;
    private int technologyId;
    private int themeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(int technologyId) {
        this.technologyId = technologyId;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public CommandEntity(String name, String explanation, int technologyId, int themeId) {
        this.name = name;
        this.explanation = explanation;
        this.technologyId = technologyId;
        this.themeId = themeId;
    }

    public CommandEntity(int id, String name, String explanation, int technologyId, int themeId) {
        this.id = id;
        this.name = name;
        this.explanation = explanation;
        this.technologyId = technologyId;
        this.themeId = themeId;
    }
}
