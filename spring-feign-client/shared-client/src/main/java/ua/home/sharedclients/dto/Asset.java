package ua.home.sharedclients.dto;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
public class Asset {

    private String id;
    private String name;

    public Asset() {
    }

    public Asset(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
