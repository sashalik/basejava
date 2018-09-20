/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    String uuid;

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Resume))
            return false;
        Resume resume = (Resume) obj;
        return this.uuid.equals(resume.uuid);
    }
}
