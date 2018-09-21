/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    public String uuid;

    public Resume(){

    }

    public Resume(String uuid){
        this.uuid = uuid;
    }


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
